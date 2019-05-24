package com.obliq.obliq.CTRL;

import com.obliq.obliq.ENTITYS.Post;
import com.obliq.obliq.ENTITYS.User;
import com.obliq.obliq.REPOS.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    @GetMapping("/tribe")
    public String profile_get(Model model) {
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User user = userRepo.findOne(sessionUser.getId());
        List<User> tribe_users = new ArrayList<>();
        for (User u : userRepo.findAll()) {
            if (u.getTribe_id() == user.getTribe_id())
                tribe_users.add(u);
        }

        model.addAttribute("users", tribe_users);

        List<Post> tribe_posts = new ArrayList<>();
        for (Post p : postRepo.findAll()) {
            if (p.getUser().getTribe_id() == user.getTribe_id())
                tribe_posts.add(p);
        }

        model.addAttribute("posts", tribe_posts);

        return "tribe";

    }

    @PostMapping("/Tribe")
    public String profile_post() {


        return "Tribe";

    }


}