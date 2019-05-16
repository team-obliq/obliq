package com.obliq.obliq.CTRL;

import com.obliq.obliq.ENTITYS.Career;
import com.obliq.obliq.ENTITYS.User;
import com.obliq.obliq.REPOS.CareersRepository;
import com.obliq.obliq.REPOS.CommentRepository;
import com.obliq.obliq.REPOS.PostRespository;
import com.obliq.obliq.REPOS.UserRespository;
import com.obliq.obliq.TESTING.testing_Repo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.swing.text.View;
import java.util.ArrayList;
import java.util.List;

@Controller
public class signup_CTRL {

    /* -Connection------------------------------------------------------------------------------------------ */
    private testing_Repo connectionTest;
    private UserRespository userRepo;
    private PostRespository postRepo;
    private CommentRepository commentRepo;
    private CareersRepository careerRepo;

    public signup_CTRL(testing_Repo connectionTest, UserRespository userRepo, PostRespository postRepo, CommentRepository commentRepo, CareersRepository careerRepo) {
        this.connectionTest = connectionTest;
        this.userRepo = userRepo;
        this.postRepo = postRepo;
        this.commentRepo = commentRepo;
        this.careerRepo = careerRepo;
    }
    /* -Connection------------------------------------------------------------------------------------------ */

    @GetMapping("/signup")
    public String signup_get(Model model) {
        model.addAttribute("user", new User());

        List<Career> careerList =  new ArrayList<>();
        for(Career x: careerRepo.findAll()) {
            careerList.add(x);
        }

        model.addAttribute("careerList", careerList);


        return "signup";

    }

    @PostMapping("/signup")
    public String login_post(@ModelAttribute User user) {

        System.out.println(user.getBio());


        return "redirect:/profile";

    }




}
