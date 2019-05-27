package com.obliq.obliq.SERVICE;

import com.obliq.obliq.ENTITYS.Tribe;
import com.obliq.obliq.ENTITYS.User;
import com.obliq.obliq.REPOS.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class tribe_assigment_SRV {

/* -Connection------------------------------------------------------------------------------------------ */
    private UserRepository userRepo;
    private PostRepository postRepo;
    private CommentRepository commentRepo;
    private CareersRepository careerRepo;
    private TribesRepository tribeRepo;

    public tribe_assigment_SRV(TribesRepository tribeRepo, UserRepository userRepo, PostRepository postRepo, CommentRepository commentRepo, CareersRepository careerRepo) {
        this.userRepo = userRepo;
        this.postRepo = postRepo;
        this.commentRepo = commentRepo;
        this.careerRepo = careerRepo;
        this.tribeRepo = tribeRepo;
    }
/* -Connection------------------------------------------------------------------------------------------ */

/* -Returns a list of all tribes from database------------------------------------------------------------------------------------------ */
    public List<Tribe> CREATE_master_Tribe_List() {
        List<Tribe> list = new ArrayList<>();
        for (Tribe t: tribeRepo.findAll()) {
            list.add(t);
        }
        return list;
    }

/* -Returns a list of all users from database------------------------------------------------------------------------------------------ */
    public List<User> CREATE_master_User_List() {
        List<User> list = new ArrayList<>();
        for (User u: userRepo.findAll()) {
            list.add(u);
        }
        return list;
    }

/* -Test a list to see if it has 0 members------------------------------------------------------------------------------------------ */
    public boolean TEST_is_list_empty(List<Tribe> list) {
        if (list.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean TEST_is_User_list_empty(List<User> list) {
        if (list.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

/* -Takes a boolean and if true creates a tribe------------------------------------------------------------------------------------------ */
    public void CREATE_a_new_tribe() {
            Tribe tribe = new Tribe();
            tribeRepo.save(tribe);
    }

/* -Updates all member tribe count------------------------------------------------------------------------------------------ */
    public void UPDATE_tribe_member_count() {
        for (Tribe t: CREATE_master_Tribe_List()) {
            long count = 0;
            for (User u: CREATE_master_User_List()) {
                if (u.getTribe_id() == t.getId()) {
                    count++;
                }
            }
            Tribe tribe = tribeRepo.findOne(t.getId());
            tribe.setMember_count(count);
            tribeRepo.save(tribe);
        }
    }

/* -Make a list of tribes with user less than the chosen number------------------------------------------------------------------------------------------ */
    public List<Tribe> CREATE_max_tribe_member_list(long max_count) {
        List<Tribe> list = new ArrayList<>();
        UPDATE_tribe_member_count();
        //Loop 1
        for (Tribe t: CREATE_master_Tribe_List()) {
            if (t.getMember_count() < max_count) {
                list.add(t);
            }
        }
        return list;
    }

/* -Filters all tribes containing a member with a matching careers to the new user------------------------------------------------------------------------------------------ */
    public List<Tribe> FILTER_list_using_new_member_career(List<Tribe> candidate_List, User user) {

        List<Tribe> candidate_rewrite = new ArrayList<>();
        List<User> userList = CREATE_master_User_List();

        Iterator t = candidate_List.iterator();
        Iterator u = userList.iterator();

        Tribe tribe = new Tribe();
        User user1 = new User();
        while (t.hasNext()) {
            tribe = (Tribe) t.next();
            while (u.hasNext()) {
                user1 = (User) u.next();
                if (tribe.getId() == user1.getTribe_id() && user1.getCareer_id() == user.getCareer_id()) {
                    t.remove();
                    break;
                }
            }
        }

        return candidate_List;

    }

/* -Filters all tribes containing a member with a matching careers to the new user------------------------------------------------------------------------------------------ */
    public long return_Tribe_ID_with_highest_member_count(List<Tribe> list) {
        List<Tribe> max_tribe_list = new ArrayList<>();
        List<Long> list_size_tracker = new ArrayList<>();
        long tribe_ID = 0;

        for (Tribe t: list) {
            list_size_tracker.add(t.getMember_count());
        }


        for (Tribe t: list) {
            if (t.getMember_count() == Collections.max(list_size_tracker)){
                max_tribe_list.add(t);
            }
        }

        if (max_tribe_list.size() == 1) {
            tribe_ID = max_tribe_list.get(0).getId();
        }

        if (max_tribe_list.size() > 1) {
            Random rand = new Random();
            int rand_int = rand.nextInt(max_tribe_list.size());
            tribe_ID = max_tribe_list.get(rand_int).getId();
        }

        return tribe_ID;
    }

/* ---Put new user in database---------------------------------------------------------------------------------------- */
    public void PUT_user_in_tribe(User user, long tribe_ID) {
        user.setTribe_id(tribe_ID);
    }


/* --------------------------------------------------------------------------------------------------------------------- */
/* --------------------------------------------------------------------------------------------------------------------- */
/* -Tibe assigment master tool (Assigns a User a tribe and returns that user)---------------------------------------------------------------------------------------- */
    public User tribe_assigment_master_tool(User user) {
        System.out.println(user.getFirst_name());
        while (true) {
            //1: Update all tribe member count
            System.out.println("Step 1");
            UPDATE_tribe_member_count();

            //2: Test to see if there are any tribe and if not (CREATE NEW TRIBE)
            System.out.println("Step 2");
            if (TEST_is_list_empty(CREATE_master_Tribe_List())) {
                CREATE_a_new_tribe();
                System.out.println("Starting over: Create_master_Tribe_list empty");
                continue;
            }

            System.out.println("Step 3");
            //3: Set max members per tribe variable;
            long max_members_per_tribe = 5;

            System.out.println("Step 4");
            //4: Create 2 lists to filter and test for new user placement
            List<Tribe> candidate_List;
            List<Tribe> candidate_List_2 = new ArrayList<>();

            System.out.println("Step 5");
            //5; Fill candidate_List with Tribes who have less than x members;
            candidate_List = CREATE_max_tribe_member_list(max_members_per_tribe);

            System.out.println("Step 6");
            //6: Test candidate list to see if its empty if so (CREATE NEW TRIBE)
            if (TEST_is_list_empty(candidate_List)) {
                CREATE_a_new_tribe();
                System.out.println("Starting over: candidate_List: All tribes full");
                continue;
            }

            System.out.println("Step 7");
//            7: Filter max member tribe list for career members matching new user
            candidate_List = FILTER_list_using_new_member_career(candidate_List, user);

            System.out.println("Step 8");
//            8: Test candidate list to see if its empty if so (CREATE NEW TRIBE)
            if (TEST_is_list_empty(candidate_List)) {
                CREATE_a_new_tribe();
                System.out.println("Starting over: candidate_List: no tribes with open career spot");
                continue;
            }

            System.out.println("Step 9");
            //9: Create the tribe ID variable that will be used to assign new member to tribe
            long tribe_Id = 0;

            System.out.println("Step 10");
            //10: find Tribe ID with the highest member count and assign to tribe_Id
            tribe_Id = return_Tribe_ID_with_highest_member_count(candidate_List);

            System.out.println("Step 11");
//            11: Set tribe Id on new member
            user.setTribe_id(tribe_Id);

            return user;
        }
    }

}




