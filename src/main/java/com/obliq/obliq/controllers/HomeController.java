package com.obliq.obliq.controllers;

import com.obliq.obliq.repositories.CommentRepository;
import com.obliq.obliq.repositories.PostRepository;
import com.obliq.obliq.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private PostRepository postRepo;
    private UserRepository userRepo;
    private CommentRepository commentRepo;

    public HomeController(PostRepository postRepo, UserRepository userRepo, CommentRepository commentRepo) {
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
