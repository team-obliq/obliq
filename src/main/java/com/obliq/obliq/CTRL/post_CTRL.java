package com.obliq.obliq.CTRL;

import com.obliq.obliq.ENTITYS.Comment;
import com.obliq.obliq.ENTITYS.Post;
import com.obliq.obliq.ENTITYS.User;
import com.obliq.obliq.REPOS.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
public class post_CTRL {

//    repo injection
    private PostRespository postRepo;
    private UserRespository userRepo;
    private CommentRepository commentRepo;
    private CareersRepository careerRepo;
    private CardRepository cardRepo;

    public post_CTRL(PostRespository postRepo, UserRespository userRepo, CommentRepository commentRepo, CareersRepository careerRepo, CardRepository cardRepo) {
        this.postRepo = postRepo;
        this.userRepo = userRepo;
        this.commentRepo = commentRepo;
        this.careerRepo = careerRepo;
        this.cardRepo = cardRepo;
    }






//    map to show individual posts
//    @GetMapping("/posts/showPost/{id}")
//    public String showPost(@PathVariable long id, Model model, String post_owner_name, String post_owner_career, Date post_date) {
//        model.addAttribute("post", postRepo.findOne(id));
//
//        /* ---Post info attributes---------------------------------------------------------------------------------------- */
//        post_owner_name = postRepo.findOne(id).getUser().getFirst_name();
//        long career_id = postRepo.findOne(id).getUser().getCareer_id();
//        post_owner_career = careerRepo.findOne(career_id).getTitle();
//        post_date = postRepo.findOne(id).getDateCreated();
//
//        model.addAttribute("post_owner_name", post_owner_name);
//        model.addAttribute("post_owner_career", post_owner_career);
//        model.addAttribute("post_date", post_date);
//        /* ------------------------------------------------------------------------------------------- */
//
//
//        model.addAttribute("comment", new Comment());
//        model.addAttribute("comments", commentRepo.findByPostId(id));
//        model.addAttribute("postId");
//        return "posts/showPost";
//    }

    @GetMapping("/posts/showPost/{id}")
    public String showPost(@PathVariable long id, Model model) {
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        model.addAttribute("user", userRepo.findOne(sessionUser.getId()));
        model.addAttribute("post", postRepo.findOne(id));
        model.addAttribute("comment", new Comment());
        model.addAttribute("comments", commentRepo.findByPostId(id));
        model.addAttribute("card", cardRepo.findOne(id));
        model.addAttribute("postId");
        return "posts/showPost";
    }

    @PostMapping("/posts/showPost")
        public String login_post(@PathVariable long id, @ModelAttribute Comment comment) {

        System.out.println(comment.getBody());


        return "/posts/showPost";
//        return "redirect:/posts/showPost/{id}";

    }










//    map for creating posts
    @GetMapping("/posts/create")
    public String showCreatePostForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post) {
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(userRepo.findOne(sessionUser.getId()));
        postRepo.save(post);
        return "redirect:/posts/showPost/" + post.getId();
    }

//    map for edit form in the edit view
    @GetMapping("/posts/edit/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        Post post = postRepo.findOne(id);
        model.addAttribute("post", post);
        return "posts/edit";
    }

//    map for edited post. save to DB
    @PostMapping("posts/edit/{id}")
    public String editPost(@ModelAttribute Post postEdited) {
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        postEdited.setUser(userRepo.findOne(sessionUser.getId()));
        postRepo.save(postEdited);
        return "redirect:/profile";
    }

//    map for delete function
    @GetMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable long id) {
//        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Post post = postRepo.findOne(id);
        postRepo.delete(post);
        return "redirect:/profile";
    }


}
