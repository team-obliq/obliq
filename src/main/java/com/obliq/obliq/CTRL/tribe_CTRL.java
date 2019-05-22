package com.obliq.obliq.CTRL;

import com.obliq.obliq.ENTITYS.Comment;
import com.obliq.obliq.ENTITYS.Post;
import com.obliq.obliq.ENTITYS.User;
import com.obliq.obliq.REPOS.CareersRepository;
import com.obliq.obliq.REPOS.CommentRepository;
import com.obliq.obliq.REPOS.PostRespository;
import com.obliq.obliq.REPOS.UserRespository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class tribe_CTRL {

    //    repo injection
    private UserRespository userRepo;
    private PostRespository postRepo;
    private CommentRepository commentRepo;
    private CareersRepository careerRepo;

    public tribe_CTRL(UserRespository userRepo, PostRespository postRepo, CommentRepository commentRepo, CareersRepository careerRepo) {
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
        model.addAttribute("user", userRepo.findOne(sessionUser.getId()));

        List<Post> tribe_posts = new ArrayList<>();
        for(Post p: postRepo.findAll()) {
            if (p.getUser().getTribe_id() == user.getTribe_id())
                tribe_posts.add(p);
        }

        model.addAttribute("posts", tribe_posts);


        return "tribe";

    }

    @GetMapping("tribe/{id}")
    public String showPost(@PathVariable long id, Model model, String post_owner_name, String post_owner_career, Date post_date) {
        model.addAttribute("post", postRepo.findOne(id));

        /* ---Post info attributes---------------------------------------------------------------------------------------- */
        post_owner_name = postRepo.findOne(id).getUser().getFirst_name();
        long career_id = postRepo.findOne(id).getUser().getCareer_id();
        post_owner_career = careerRepo.findOne(career_id).getTitle();
        post_date = postRepo.findOne(id).getDateCreated();

        model.addAttribute("post_owner_name", post_owner_name);
        model.addAttribute("post_owner_career", post_owner_career);
        model.addAttribute("post_date", post_date);
        /* ------------------------------------------------------------------------------------------- */


        model.addAttribute("comment", new Comment());
        model.addAttribute("comments", commentRepo.findByPostId(id));
        model.addAttribute("postId");
        return "tribes/posts";
    }


    @PostMapping("/Tribe")
    public String profile_post() {



        return "Tribe";

    }


}