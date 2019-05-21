package com.obliq.obliq.CTRL;

import com.obliq.obliq.REPOS.CommentRepository;
import com.obliq.obliq.REPOS.PostRespository;
import com.obliq.obliq.REPOS.UserRespository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class home_CTRL {

    private PostRespository postRepo;
    private UserRespository userRepo;
    private CommentRepository commentRepo;

    public home_CTRL(PostRespository postRepo, UserRespository userRepo, CommentRepository commentRepo) {
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
