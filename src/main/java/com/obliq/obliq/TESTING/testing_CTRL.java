package com.obliq.obliq.TESTING;




import com.obliq.obliq.ENTITYS.Career;
import com.obliq.obliq.ENTITYS.Tribe;
import com.obliq.obliq.ENTITYS.User;
import com.obliq.obliq.REPOS.*;
import com.obliq.obliq.SERVICE.tribe_assigment_SRV;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Random;

import java.lang.reflect.Array;
import java.util.*;

@Controller
public class testing_CTRL {

    /* -Connection------------------------------------------------------------------------------------------ */
    private testing_Repo connectionTest;
    private UserRespository userRepo;
    private PostRespository postRepo;
    private CommentRepository commentRepo;
    private CareersRepository careerRepo;
    private TribesRepository tribeRepo;

    private tribe_assigment_SRV assigment_tool;

    public testing_CTRL(tribe_assigment_SRV assigment_tool, TribesRepository tribeRepo, testing_Repo connectionTest, UserRespository userRepo, PostRespository postRepo, CommentRepository commentRepo, CareersRepository careerRepo) {
        this.connectionTest = connectionTest;
        this.userRepo = userRepo;
        this.postRepo = postRepo;
        this.commentRepo = commentRepo;
        this.careerRepo = careerRepo;
        this.tribeRepo = tribeRepo;
        this.assigment_tool = assigment_tool;
    }
    /* -Connection------------------------------------------------------------------------------------------ */


    @GetMapping("/testing")
    public String welcome(Model model) {

//        Tribe tribe1 = new Tribe();
//        Tribe tribe2 = new Tribe();
//        Tribe tribe3 = new Tribe();

//        tribeRepo.save(tribe1);
//        tribeRepo.save(tribe2);
//        tribeRepo.save(tribe3);

        User one = new User();
        User two = new User();
        User three = new User();
        User four = new User();
        User five = new User();
        User six = new User();
        User seven = new User();

//        one.setUsername("Adam");
//        one.setEmail("adam@gmail.com");
//        one.setPassword("041s2e1w0");
//        one.setTribe_id(1);
//        one.setCareer_id(3);
//        userRepo.save(one);
//
//        two.setUsername("Bill");
//        two.setEmail("Bill@gmail.com");
//        two.setPassword("041s2e1w0");
//        two.setTribe_id(1);
//        two.setCareer_id(5);
//        userRepo.save(two);
//
//        three.setUsername("Charlie");
//        three.setEmail("Charlie@gmail.com");
//        three.setPassword("041s2e1w0");
//        three.setTribe_id(1);
//        three.setCareer_id(4);
//        userRepo.save(three);
//
//        four.setUsername("Doug");
//        four.setEmail("Doug@gmail.com");
//        four.setPassword("041s2e1w0");
//        four.setTribe_id(2);
//        four.setCareer_id(3);
//        userRepo.save(four);
//
//        five.setUsername("Ethan");
//        five.setEmail("Ethan@gmail.com");
//        five.setPassword("041s2e1w0");
//        five.setTribe_id(2);
//        five.setCareer_id(4);
//        userRepo.save(five);

//        six.setUsername("Frank");
//        six.setEmail("Frank@gmail.com");
//        six.setPassword("041s2e1w0");
//        six.setTribe_id(3);
//        six.setCareer_id(5);
//        userRepo.save(six);

//        seven.setUsername("Graig");
//        seven.setEmail("Graig@gmail.com");
//        seven.setPassword("041s2e1w0");
//        seven.setTribe_id(3);
//        seven.setCareer_id(2);
//        userRepo.save(seven);

        for (Tribe t: assigment_tool.CREATE_master_Tribe_List()) {
            long count = 0;
            for (User u: assigment_tool.CREATE_master_User_List()) {
                if (u.getTribe_id() == t.getId()) {
                    count++;
                }
            }
            Tribe tribe = tribeRepo.findOne(t.getId());
            tribe.setMember_count(count);
            tribeRepo.save(tribe);
        }



        List<Tribe> list = new ArrayList<>();
        //Loop 1
        for (Tribe t: assigment_tool.CREATE_master_Tribe_List()) {
            if (t.getMember_count() < 3) {
                list.add(t);
            }
        }

//        for (Tribe t: list) {
//            System.out.println(t.getId());
//        }

        User eight = new User();
        eight.setUsername("Frank");
        eight.setEmail("Frank@gmail.com");
        eight.setPassword("041s2e1w0");
        eight.setCareer_id(3);

        for (Tribe t: list) {
            System.out.println(list.size());
        }

        //loop 1
        for (Tribe t: list) {
            //loop 2
            for (User u: assigment_tool.CREATE_master_User_List()) {
                if (u.getTribe_id() == t.getId() & eight.getCareer_id() == u.getCareer_id()) {
                    list.remove(t);
                }
            }
        }

        for (Tribe t: list) {
            System.out.println(list.size());
        }




        return "testing";
    }

}



