package com.obliq.obliq.CTRL;

import com.obliq.obliq.ENTITYS.Card;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class post_CTRL {

//    repo injection
    private PostRepository postRepo;
    private UserRepository userRepo;
    private CommentRepository commentRepo;
    private CareersRepository careerRepo;
    private CardsRepository cardsRepo;

    public post_CTRL(PostRepository postRepo, UserRepository userRepo, CommentRepository commentRepo, CareersRepository careerRepo, CardsRepository cardsRepo) {
        this.postRepo = postRepo;
        this.userRepo = userRepo;
        this.commentRepo = commentRepo;
        this.careerRepo = careerRepo;
        this.cardsRepo = cardsRepo;
    }

    @GetMapping("/posts/showPost/{id}")
    public String showPost(@PathVariable long id, Model model) {
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Random random =  new Random();
        long randomNumber = (long) random.nextInt(133);
        Card postCard = cardsRepo.findOne(randomNumber);
        User userDb = userRepo.findOne(sessionUser.getId());
        System.out.println(userDb.getComment_with_points());

//        list of comments by userId
        List<Comment> userComments = new ArrayList<>();
        for(Comment comment : commentRepo.findByUserId(userDb.getId())) {
            if (comment.getUser().getId() == userDb.getId())
                userComments.add(comment);
        }
        System.out.println("line 52: " + userComments.size());

//        if (commentRepo.findByPostId(id).contains(userComments))

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
