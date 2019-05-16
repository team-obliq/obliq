package com.obliq.obliq.CTRL;

import com.obliq.obliq.REPOS.CommentRepository;
import com.obliq.obliq.REPOS.PostRespository;
import com.obliq.obliq.REPOS.UserRespository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class profile_CTRL {
    private UserRespository userRepo;
    private PostRespository postRepo;
    private CommentRepository commentRepo;

    public profile_CTRL(UserRespository userRepo, PostRespository postRepo, CommentRepository commentRepo) {
        this.userRepo = userRepo;
        this.postRepo = postRepo;
        this.commentRepo = commentRepo;
    }

    @GetMapping("/profile")
    public String profile_get(Model model) {
        model.addAttribute("user", userRepo.findOne(1L));
        model.addAttribute("posts", postRepo.findByUserId(1L));

        System.out.println("profile_working");


        return "profile";

    }

    @PostMapping("/profile")
    public String profile_post() {

        System.out.println("profile");


        return "profile";

    }

    @GetMapping("/profile/{id}")
    public String login_get_var(@PathVariable Long id, Model model) {
        model.addAttribute("user", userRepo.findOne(id));
        model.addAttribute("posts",postRepo.findByUserId(id));



        return "profile";

    }



}
