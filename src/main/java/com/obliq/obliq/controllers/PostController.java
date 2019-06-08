package com.obliq.obliq.controllers;

import com.obliq.obliq.models.Card;
import com.obliq.obliq.models.Comment;
import com.obliq.obliq.models.Post;
import com.obliq.obliq.models.User;
import com.obliq.obliq.repositories.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class PostController {

//    repo injection
    private PostRepository postRepo;
    private UserRepository userRepo;
    private CommentRepository commentRepo;
    private CareersRepository careerRepo;
    private CardsRepository cardsRepo;

    public PostController(PostRepository postRepo, UserRepository userRepo, CommentRepository commentRepo, CareersRepository careerRepo, CardsRepository cardsRepo) {
        this.postRepo = postRepo;
        this.userRepo = userRepo;
        this.commentRepo = commentRepo;
        this.careerRepo = careerRepo;
        this.cardsRepo = cardsRepo;
    }

    @GetMapping("/posts/showPost/{id}")
    public String showPost(@PathVariable long id, Model model) {
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Post post = postRepo.findOne(id);
        Card postCard = cardsRepo.findOne(post.getCardID());
        User userDb = userRepo.findOne(sessionUser.getId());

//        list of comments by userId
        List<Comment> userComments = new ArrayList<>();
        for(Comment comment : commentRepo.findByUserId(userDb.getId())) {
            if (comment.getUser().getId() == userDb.getId())
                userComments.add(comment);
        }

        model.addAttribute("user", userRepo.findOne(sessionUser.getId()));
        model.addAttribute("post", postRepo.findOne(id));
        model.addAttribute("comment", new Comment());
        model.addAttribute("comments", commentRepo.findByPostId(id));
        model.addAttribute("postId");
        model.addAttribute("card", postCard);
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
        Random random =  new Random();
        long randomNumber = (long) random.nextInt(133);
        Card postCard = cardsRepo.findOne(randomNumber);
        post.setCardID(postCard.getId());

        postRepo.save(post);
        return "redirect:/my-tribe";
    }

//    map for edit form in the edit view
    @GetMapping("/posts/edit/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        Post post = postRepo.findOne(id);
        Card card = cardsRepo.findOne(post.getCardID());
        model.addAttribute("post", post);
        model.addAttribute("card", card);
        System.out.println("get card id: " + cardsRepo.findOne(post.getCardID()).getId());
        System.out.println("get card card: " + cardsRepo.findOne(post.getCardID()).getCard());
        return "posts/edit";
    }

    @PostMapping(value = "posts/edit/{id}", params = "change-card")
    public String changeCard(@ModelAttribute Post post) {
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(userRepo.findOne(sessionUser.getId()));
        Random random = new Random();
        long newRandomNumber = (long) random.nextInt(133);
        Card newPostCard = cardsRepo.findOne(newRandomNumber);
        post.setCardID(newPostCard.getId());
        postRepo.save(post);
        return "redirect:/posts/edit/" + post.getId();
    }
//    map for edited post. save to DB
    @PostMapping("posts/edit/{id}")
    public String editPost(@ModelAttribute Post postEdited) {
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        postEdited.setUser(userRepo.findOne(sessionUser.getId()));
        postRepo.save(postEdited);
        return "redirect:/my-profile";
    }

//    map for delete function
    @GetMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable long id) {
//        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Post post = postRepo.findOne(id);
        postRepo.delete(post);
        return "redirect:/my-profile";
    }


}
