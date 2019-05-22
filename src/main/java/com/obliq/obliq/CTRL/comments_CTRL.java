package com.obliq.obliq.CTRL;

import com.obliq.obliq.ENTITYS.Comment;
import com.obliq.obliq.ENTITYS.User;
import com.obliq.obliq.REPOS.CommentRepository;
import com.obliq.obliq.REPOS.PostRepository;
import com.obliq.obliq.REPOS.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class comments_CTRL {

    private UserRepository userRepo;
    private PostRepository postRepo;
    private CommentRepository commentRepo;

    public comments_CTRL(UserRepository userRepo, PostRepository postRepo, CommentRepository commentRepo) {
        this.userRepo = userRepo;
        this.postRepo = postRepo;
        this.commentRepo = commentRepo;
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
            return "redirect:/posts/showPost/" + postId;
    }

    @GetMapping("/comments/edit/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        model.addAttribute("comment", commentRepo.findOne(id));
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
