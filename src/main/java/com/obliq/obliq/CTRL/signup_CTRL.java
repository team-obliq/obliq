package com.obliq.obliq.CTRL;

import com.obliq.obliq.ENTITYS.Career;
import com.obliq.obliq.ENTITYS.Tribe;
import com.obliq.obliq.ENTITYS.User;
import com.obliq.obliq.REPOS.*;
import com.obliq.obliq.SERVICE.tribe_assigment_SRV;
import com.obliq.obliq.TESTING.testing_Repo;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class signup_CTRL {

    /* -Connection------------------------------------------------------------------------------------------ */
    private testing_Repo connectionTest;
    private UserRespository userRepo;
    private PostRespository postRepo;
    private CommentRepository commentRepo;
    private CareersRepository careerRepo;
    private TribesRepository tribeRepo;

    private tribe_assigment_SRV assigment_tool;

    public signup_CTRL(TribesRepository tribeRepo, testing_Repo connectionTest, UserRespository userRepo, PostRespository postRepo, CommentRepository commentRepo, CareersRepository careerRepo, tribe_assigment_SRV assigment_tool) {
        this.connectionTest = connectionTest;
        this.userRepo = userRepo;
        this.postRepo = postRepo;
        this.commentRepo = commentRepo;
        this.careerRepo = careerRepo;
        this.tribeRepo = tribeRepo;
        this.assigment_tool = assigment_tool;
    }
    /* -Connection------------------------------------------------------------------------------------------ */

    @GetMapping("/signup")
    public String signup_get(Model model) {



        List<Career> careerList =  new ArrayList<>();
        for(Career x: careerRepo.findAll()) {
            careerList.add(x);
        }

        List<Career> careerListAdd =  new ArrayList<>();


        model.addAttribute("careerList", careerList);
        model.addAttribute("user", new User());
        model.addAttribute("careerListAdd", careerListAdd);


        return "signup";

    }

    @PostMapping("/signup")
    public String login_post(@ModelAttribute User user) {

        assigment_tool.tribe_assigment_master_tool(user);


        return "signup";
//        return "redirect:/profile";

    }




}
