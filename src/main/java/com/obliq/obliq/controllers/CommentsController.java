package com.obliq.obliq.controllers;

import com.obliq.obliq.models.Comment;
import com.obliq.obliq.models.User;
import com.obliq.obliq.repositories.CommentRepository;
import com.obliq.obliq.repositories.PostRepository;
import com.obliq.obliq.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CommentsController {

    private UserRepository userRepo;
    private PostRepository postRepo;
    private CommentRepository commentRepo;

    public CommentsController(UserRepository userRepo, PostRepository postRepo, CommentRepository commentRepo) {
        this.userRepo = userRepo;
        this.postRepo = postRepo;
        this.commentRepo = commentRepo;
    }

    @GetMapping("/comments/create")
    public String showCommentForm(Model model) {
        model.addAttribute("comment", new Comment());
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        return "posts/showPost";
    }

    @PostMapping("/comments/create")
    public String createComment(@ModelAttribute Comment comment, @RequestParam(name="postId") long postId) {
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userDb = userRepo.findOne(sessionUser.getId());
        comment.setUser(userRepo.findOne(sessionUser.getId()));
        comment.setPost(postRepo.findOne(postId));
        commentRepo.save(comment);
        return "redirect:/posts/showPost/" + postId;
    }

    @GetMapping("/add/{id}")
    public String upVoteShow(@PathVariable long id, Model model) {
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userDb = userRepo.findOne(sessionUser.getId());
        Comment comment = commentRepo.findOne(id);
        userDb.addToCommentList(comment);

        userRepo.save(userDb);
        model.addAttribute("comment", commentRepo.findOne(id));
        return "redirect:/posts/showPost/" + comment.getPost().getId();
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        Comment comment = commentRepo.findOne(id);
        model.addAttribute("comment", comment);
        model.addAttribute("post", comment.getPost());
        return "comments/edit";
    }
    @PostMapping("/edit/{id}")
    public String editComment(@ModelAttribute Comment commentEdited) {
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        commentEdited.setUser(userRepo.findOne(sessionUser.getId()));
        commentRepo.save(commentEdited);
        return "redirect:/posts/showPost/" + commentEdited.getPost().getId();
    }

    @GetMapping("/delete/{id}")
    public String deleteComment(@PathVariable long id) {
        Comment comment = commentRepo.findOne(id);

        commentRepo.delete(comment);
        return "redirect:/my-profile";
    }




}
