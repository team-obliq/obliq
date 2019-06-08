package com.obliq.obliq.controllers;

import com.obliq.obliq.models.Career;
import com.obliq.obliq.models.Post;
import com.obliq.obliq.models.User;
import com.obliq.obliq.repositories.CareersRepository;
import com.obliq.obliq.repositories.CommentRepository;
import com.obliq.obliq.repositories.PostRepository;
import com.obliq.obliq.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TribeController {

    //    repo injection
    private UserRepository userRepo;
    private PostRepository postRepo;
    private CommentRepository commentRepo;
    private CareersRepository careerRepo;

    public TribeController(UserRepository userRepo, PostRepository postRepo, CommentRepository commentRepo, CareersRepository careerRepo) {
        this.userRepo = userRepo;
        this.postRepo = postRepo;
        this.commentRepo = commentRepo;
        this.careerRepo = careerRepo;
    }


    //    map profile view
    @GetMapping("/my-tribe")
    public String profile_get(Model model) {
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User user = userRepo.findOne(sessionUser.getId());
        List <User> tribe_users = new ArrayList<>();
        for (User u : userRepo.findAll()) {
            if (u.getTribe_id() == user.getTribe_id())
                tribe_users.add(u);
        }

        List<Career> careers = new ArrayList<>();
        for (Career c : careerRepo.findAll()) {
            for (User u : tribe_users) {
                if (c.getId() == u.getCareer_id()) {
                    careers.add(c);
                }
            }
        }

        model.addAttribute("users", tribe_users);
        model.addAttribute("careers", careers);
        List<Post> tribe_posts = new ArrayList<>();
        for(Post p: postRepo.findAll()) {
            if (p.getUser().getTribe_id() == user.getTribe_id())
                tribe_posts.add(p);
        }

        model.addAttribute("posts", tribe_posts);

        return "tribes/tribe";

    }


//
//        /* ---Post info attributes---------------------------------------------------------------------------------------- */
////        post_owner_name = postRepo.findOne(id).getUser().getFirst_name();
////        long career_id = postRepo.findOne(id).getUser().getCareer_id();
////        post_owner_career = careerRepo.findOne(career_id).getTitle();
////        post_date = postRepo.findOne(id).getDateCreated();
////
////        model.addAttribute("post_owner_name", post_owner_name);
////        model.addAttribute("post_owner_career", post_owner_career);
////        model.addAttribute("post_date", post_date);
//        /* ------------------------------------------------------------------------------------------- */
//
//
//        model.addAttribute("comment", new Comment());
//        model.addAttribute("comments", commentRepo.findByPostId(id));
//        model.addAttribute("postId");
//        return "tribes/posts";
//    }


    @PostMapping("/Tribe")
    public String profile_post() {



        return "Tribe";

    }


}