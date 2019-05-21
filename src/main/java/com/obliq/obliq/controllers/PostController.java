package com.obliq.obliq.controllers;

import com.obliq.obliq.models.Comment;
import com.obliq.obliq.models.Post;
import com.obliq.obliq.models.User;
import com.obliq.obliq.repositories.CommentRepository;
import com.obliq.obliq.repositories.PostRespository;
import com.obliq.obliq.repositories.UserRespository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {

//    repo injection
    private PostRespository postRepo;
    private UserRespository userRepo;
    private CommentRepository commentRepo;

    public PostController(PostRespository postRepo, UserRespository userRepo, CommentRepository commentRepo) {
        this.postRepo = postRepo;
        this.userRepo = userRepo;
        this.commentRepo = commentRepo;
    }

//    map to show individual posts
    @GetMapping("/posts/showPost/{id}")
    public String showPost(@PathVariable long id, Model model) {
        model.addAttribute("post", postRepo.findOne(id));
        model.addAttribute("comment", new Comment());
        model.addAttribute("comments", commentRepo.findByPostId(id));
        model.addAttribute("postId");
        return "posts/showPost";
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
