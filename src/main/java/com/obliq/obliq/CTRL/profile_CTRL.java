package com.obliq.obliq.CTRL;

import com.obliq.obliq.ENTITYS.User;
import com.obliq.obliq.REPOS.CardsRepository;
import com.obliq.obliq.REPOS.CommentRepository;
import com.obliq.obliq.REPOS.PostRepository;
import com.obliq.obliq.REPOS.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class profile_CTRL {

//    repo injection
    private UserRepository userRepo;
    private PostRepository postRepo;
    private CommentRepository commentRepo;
    private CardsRepository cardsRepo;

    public profile_CTRL(UserRepository userRepo, PostRepository postRepo, CommentRepository commentRepo, CardsRepository cardsRepo) {
        this.userRepo = userRepo;
        this.postRepo = postRepo;
        this.commentRepo = commentRepo;
        this.cardsRepo = cardsRepo;
    }


//    map profile view
    @GetMapping("/profile")
    public String profile_get() {
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();


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
