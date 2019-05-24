package com.obliq.obliq.CTRL;

import com.obliq.obliq.REPOS.CommentRepository;
import com.obliq.obliq.REPOS.PostRepository;
import com.obliq.obliq.REPOS.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class home_CTRL {

    private PostRepository postRepo;
    private UserRepository userRepo;
    private CommentRepository commentRepo;

    public home_CTRL(PostRepository postRepo, UserRepository userRepo, CommentRepository commentRepo) {
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
