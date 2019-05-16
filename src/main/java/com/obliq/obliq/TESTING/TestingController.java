package com.obliq.obliq.TESTING;




import com.obliq.obliq.repositories.CommentRepository;
import com.obliq.obliq.repositories.PostRespository;
import com.obliq.obliq.repositories.UserRespository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestingController {

    /* -Connection------------------------------------------------------------------------------------------ */
    private TestingRepo connectionTest;
    private UserRespository userRepo;
    private PostRespository postRepo;
    private CommentRepository commentRepo;

    public TestingController(TestingRepo connectionTest, UserRespository userRepo, PostRespository postRepo, CommentRepository commentRepo) {
        this.connectionTest = connectionTest;
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



