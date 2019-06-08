package com.obliq.obliq.testing;




import com.obliq.obliq.repositories.CommentRepository;
import com.obliq.obliq.repositories.PostRepository;
import com.obliq.obliq.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestingController {

    /* -Connection------------------------------------------------------------------------------------------ */
    private UserRepository userRepo;
    private PostRepository postRepo;
    private CommentRepository commentRepo;

    public TestingController(UserRepository userRepo, PostRepository postRepo, CommentRepository commentRepo) {
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



