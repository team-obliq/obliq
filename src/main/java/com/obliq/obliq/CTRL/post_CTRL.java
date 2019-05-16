package com.obliq.obliq.CTRL;

import com.obliq.obliq.ENTITYS.Post;
import com.obliq.obliq.REPOS.PostRespository;
import com.obliq.obliq.REPOS.UserRespository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class post_CTRL {

//    repo injection
    private PostRespository postRepo;
    private UserRespository userRepo;

    public post_CTRL(PostRespository postRepo, UserRespository userRepo) {
        this.postRepo = postRepo;
        this.userRepo = userRepo;
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
        postEdited.setUser(userRepo.findOne(1L));
        postRepo.save(postEdited);
        return "redirect:/profile";
    }

//    map for delete function
    @GetMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable long id) {
        Post post = postRepo.findOne(id);
        postRepo.delete(post);
        return "redirect:/profile";
    }

}
