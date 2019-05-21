package com.obliq.obliq.controllers;

import com.obliq.obliq.models.Comment;
import com.obliq.obliq.models.User;
import com.obliq.obliq.repositories.CardRepository;
import com.obliq.obliq.repositories.CommentRepository;
import com.obliq.obliq.repositories.PostRespository;
import com.obliq.obliq.repositories.UserRespository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CommentsController {

    private UserRespository userRepo;
    private PostRespository postRepo;
    private CommentRepository commentRepo;
    private CardRepository cardRepo;

    public CommentsController(UserRespository userRepo, PostRespository postRepo, CommentRepository commentRepo, CardRepository cardRepo) {
        this.userRepo = userRepo;
        this.postRepo = postRepo;
        this.commentRepo = commentRepo;
        this.cardRepo = cardRepo;
    }

    @GetMapping("/comments/create")
    public String showCommentForm(Model model) {
        model.addAttribute("comment", new Comment());
        return "posts/showPost";
    }

    @PostMapping("/comments/create")
    public String createComment(@ModelAttribute Comment comment, @RequestParam(name="postId") long postId) {
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        comment.setUser(userRepo.findOne(sessionUser.getId()));
//        String thisPost = postId;
        comment.setPost(postRepo.findOne(postId));
        System.out.println(postId);


        commentRepo.save(comment);
        System.out.println(comment.getBody());
        System.out.println(comment.getUser().getId());
//        System.out.println(comment.getPost().getId());

//        return "redirect:/posts/showPost/" + comment.getPost().getId();
            return "/comments/create";
    }

    @GetMapping("/comments/edit/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        model.addAttribute("comment", commentRepo.findOne(id));
        model.addAttribute("card", cardRepo.findOne(id));
        return "comments/edit";
    }
    @PostMapping("/comments/edit/{id}")
    public String editComment(@ModelAttribute Comment commentEdited) {
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        commentEdited.setUser(userRepo.findOne(sessionUser.getId()));
        commentRepo.save(commentEdited);
        return "redirect:/posts/showPost";
    }
}
