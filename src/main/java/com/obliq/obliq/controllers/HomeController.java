package com.obliq.obliq.controllers;

import com.obliq.obliq.repositories.CommentRepository;
import com.obliq.obliq.repositories.PostRespository;
import com.obliq.obliq.repositories.UserRespository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private PostRespository postRepo;
    private UserRespository userRepo;
    private CommentRepository commentRepo;

    public HomeController(PostRespository postRepo, UserRespository userRepo, CommentRepository commentRepo) {
        this.postRepo = postRepo;
        this.userRepo = userRepo;
        this.commentRepo = commentRepo;
    }

    @GetMapping("/")
    public String indexPage(Model model) {
        model.addAttribute("posts", postRepo.findAll());
        model.addAttribute("users", userRepo.findAll());
        model.addAttribute("comments", commentRepo.findAll());
        return "index";
    }
}
