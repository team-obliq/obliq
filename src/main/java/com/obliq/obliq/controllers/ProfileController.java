package com.obliq.obliq.controllers;

import com.obliq.obliq.models.User;
import com.obliq.obliq.repositories.CardRepository;
import com.obliq.obliq.repositories.CommentRepository;
import com.obliq.obliq.repositories.PostRespository;
import com.obliq.obliq.repositories.UserRespository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProfileController {

//    repo injection
    private UserRespository userRepo;
    private PostRespository postRepo;
    private CommentRepository commentRepo;
    private CardRepository cardRepo;

    public ProfileController(UserRespository userRepo, PostRespository postRepo, CommentRepository commentRepo) {
        this.userRepo = userRepo;
        this.postRepo = postRepo;
        this.commentRepo = commentRepo;
    }


//    map profile view
    @GetMapping("/profile")
    public String profile_get(Model model) {
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        model.addAttribute("user", userRepo.findOne(sessionUser.getId()));
        model.addAttribute("posts", postRepo.findByUserId(sessionUser.getId()));

        System.out.println("profile_working");
        return "profile";

    }


    @PostMapping("/profile")
    public String profile_post() {

        System.out.println("profile");


        return "profile";

    }

//    map profile view with id
    @GetMapping("/profile/{id}")
    public String login_get_var(@PathVariable Long id, Model model) {
        model.addAttribute("user", userRepo.findOne(id));
        model.addAttribute("posts",postRepo.findByUserId(id));



        return "profile";

    }



}
