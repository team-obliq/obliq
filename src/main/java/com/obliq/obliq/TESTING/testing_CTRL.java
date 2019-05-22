package com.obliq.obliq.TESTING;




import com.obliq.obliq.REPOS.CommentRepository;
import com.obliq.obliq.REPOS.PostRepository;
import com.obliq.obliq.REPOS.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class testing_CTRL {

    /* -Connection------------------------------------------------------------------------------------------ */
    private UserRepository userRepo;
    private PostRepository postRepo;
    private CommentRepository commentRepo;

    public testing_CTRL(UserRepository userRepo, PostRepository postRepo, CommentRepository commentRepo) {
        this.userRepo = userRepo;
        this.postRepo = postRepo;
        this.commentRepo = commentRepo;
    }
    /* -Connection------------------------------------------------------------------------------------------ */


    @GetMapping("/testing")
    public String welcome(Model model) {
        model.addAttribute("users", userRepo.findAll());
        model.addAttribute("posts", postRepo.findByUserId(1L));
        model.addAttribute("allComments", commentRepo.findAll());
        model.addAttribute("comments", commentRepo.findByUserId(2L));
        model.addAttribute("commentsByPostId", commentRepo.findByPostId(2L));
        return "testing";
    }


}



