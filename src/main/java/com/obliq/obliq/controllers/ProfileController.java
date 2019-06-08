package com.obliq.obliq.controllers;

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

@Controller
public class ProfileController {

    //    repo injection
    private UserRepository userRepo;
    private PostRepository postRepo;
    private CommentRepository commentRepo;
    private CareersRepository careersRepo;

    public ProfileController(UserRepository userRepo, PostRepository postRepo, CommentRepository commentRepo, CareersRepository careersRepo) {
        this.userRepo = userRepo;
        this.postRepo = postRepo;
        this.commentRepo = commentRepo;
        this.careersRepo = careersRepo;
    }


    //    map profile view
    @GetMapping("/my-profile")
    public String profile_get(Model model) {
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        model.addAttribute("user", userRepo.findOne(sessionUser.getId()));
        model.addAttribute("posts", postRepo.findByUserId(sessionUser.getId()));
        model.addAttribute("comments", commentRepo.findByUserId(sessionUser.getId()));
        model.addAttribute("careers", careersRepo.findOne(sessionUser.getId()));
        return "users/profile";

    }


//    //    map profile view with id
//    @GetMapping("/profile/{id}")
//    public String login_get_var(@PathVariable Long id, Model model) {
//        model.addAttribute("user", userRepo.findOne(id));
//        model.addAttribute("posts", postRepo.findByUserId(id));
//
//
//        return "/users/profile/" + id;
//
//    }

    @PostMapping("/my-profile")
    public String profile_post() {

        System.out.println("profile");


        return "user/profile";

    }

//    @GetMapping("/edit/{id}")
//    public String showEditForm(@PathVariable long id, Model model) {
//        Comment comment = commentRepo.findOne(id);
//        model.addAttribute("comment", comment);
//        model.addAttribute("post", comment.getPost());
//        return "comments/edit";
//    }
//    @PostMapping("/edit/{id}")
//    public String editCommentFromProfile(@ModelAttribute Comment comment) {
//        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        comment.setUser(userRepo.findOne(sessionUser.getId()));
//        commentRepo.save(comment);
//        return "redirect:/profile";
//    }
//
//    @GetMapping("/delete/{id}")
//    public String deleteComment(@PathVariable long id) {
//        Comment comment = commentRepo.findOne(id);
//
//        commentRepo.delete(comment);
//        return "redirect:/profile";
//}
}
