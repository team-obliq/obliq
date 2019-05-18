package com.obliq.obliq.SERVICE;

import com.obliq.obliq.ENTITYS.Tribe;
import com.obliq.obliq.ENTITYS.User;
import com.obliq.obliq.REPOS.*;
import com.obliq.obliq.TESTING.testing_Repo;
import javassist.compiler.Javac;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.logging.Filter;

@Service
public class tribe_assigment_SRV {

/* -Connection------------------------------------------------------------------------------------------ */
    private testing_Repo connectionTest;
    private UserRespository userRepo;
    private PostRespository postRepo;
    private CommentRepository commentRepo;
    private CareersRepository careerRepo;
    private TribesRepository tribeRepo;

    public tribe_assigment_SRV(TribesRepository tribeRepo, testing_Repo connectionTest, UserRespository userRepo, PostRespository postRepo, CommentRepository commentRepo, CareersRepository careerRepo) {
        this.connectionTest = connectionTest;
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
    public void FILTER_list_using_new_member_career(List<Tribe> list, User user) {

        for (Tribe t: list) {
            //loop2
            for (User u: CREATE_master_User_List()) {
                if (u.getTribe_id() == t.getId() & user.getCareer_id() == u.getCareer_id()) {
                    list.remove(t);
                }
            }
        }
    }

/* -Filters all tribes containing a member with a matching careers to the new user------------------------------------------------------------------------------------------ */
    public long return_Tribe_ID_with_highest_member_count(List<Tribe> list) {

        list = CREATE_master_Tribe_List();
        List<Tribe> max_tribe_list = new ArrayList<>();
        List<Integer> list_size_tracker = new ArrayList<>();
        long tribe_ID = 0;

        for (Tribe t: list) {
            Integer i = (int) (long) t.getMember_count();
            list_size_tracker.add(i);
        }

        for (Tribe t: list) {
            Integer i = (int) (long) t.getMember_count();
            if (i == Collections.max(list_size_tracker)){
                max_tribe_list.add(t);
            }
        }

        if (max_tribe_list.size() == 1) {
            tribe_ID = max_tribe_list.get(0).getId();
        }

        if (max_tribe_list.size() > 1) {
            Random rand = new Random();
            int rand_int = rand.nextInt(max_tribe_list.size())-1;
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
        while (true) {

            //1: Update all tribe member count
            UPDATE_tribe_member_count();

            //2: Test to see if there are any tribe and if not (CREATE NEW TRIBE)
            if (TEST_is_list_empty(CREATE_master_Tribe_List())) {
                CREATE_a_new_tribe();
                continue;
            }

            //3: Set max members per tribe variable;
            long max_members_per_tribe = 3;

            //4: Create a list to filter and test for new user placement
            List<Tribe> candidate_List;

            //5; Fill candidate_List with Tribes who have less than x members;
            candidate_List = CREATE_max_tribe_member_list(max_members_per_tribe);

            //6: Test candidate list to see if its empty if so (CREATE NEW TRIBE)
            if (TEST_is_list_empty(candidate_List)) {
                CREATE_a_new_tribe();
                continue;
            }


            //loop 1
            for (Tribe t: candidate_List) {
                //loop 2
                for (User u: CREATE_master_User_List()) {
                    if (u.getTribe_id() == t.getId() && user.getCareer_id() == u.getCareer_id()) {
                        candidate_List.remove(t);
                    }
                }
            }


            //7: Filter max member tribe list for career members matching new user
//            FILTER_list_using_new_member_career(candidate_List, user);


            //8: Test candidate list to see if its empty if so (CREATE NEW TRIBE)
//            if (TEST_is_list_empty(candidate_List)) {
//                CREATE_a_new_tribe();
//                continue;
//            }

            //9: Create the tribe ID variable that will be used to assign new member to tribe
            long tribe_Id;

            //9: find Tribe ID with the highest member count and assign to tribe_Id
//            tribe_Id = return_Tribe_ID_with_highest_member_count(candidate_List);

            //10: Set tribe Id on new member
//            user.setTribe_id(tribe_Id);

            return user;
        }
    }

}




