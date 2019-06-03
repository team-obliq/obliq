package com.obliq.obliq.CTRL;

import com.obliq.obliq.ENTITYS.Career;
import com.obliq.obliq.ENTITYS.Post;
import com.obliq.obliq.ENTITYS.User;
import com.obliq.obliq.REPOS.CareersRepository;
import com.obliq.obliq.REPOS.CommentRepository;
import com.obliq.obliq.REPOS.PostRepository;
import com.obliq.obliq.REPOS.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class tribe_CTRL {

    //    repo injection
    private UserRepository userRepo;
    private PostRepository postRepo;
    private CommentRepository commentRepo;
    private CareersRepository careerRepo;

    public tribe_CTRL(UserRepository userRepo, PostRepository postRepo, CommentRepository commentRepo, CareersRepository careerRepo) {
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

        model.addAttribute("users", tribe_users);
//        model.addAttribute("careers", user.getCareer_id());
        model.addAttribute("career", careerRepo.findOne(sessionUser.getId()));
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