package com.obliq.obliq.TESTING;




import com.obliq.obliq.ENTITYS.Career;


import com.obliq.obliq.REPOS.CareersRepository;
import com.obliq.obliq.REPOS.CommentRepository;
import com.obliq.obliq.REPOS.PostRespository;
import com.obliq.obliq.REPOS.UserRespository;
import com.obliq.obliq.REPOS.CareersRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Random;

@Controller
public class testing_CTRL {

    /* -Connection------------------------------------------------------------------------------------------ */
    private TestingRepo connectionTest;
    private UserRespository userRepo;
    private PostRespository postRepo;
    private CommentRepository commentRepo;
    private CareersRepository careerRepo;
    private TribesRepository tribeRepo;


   


    public testing_CTRL(TestingRepo connectionTest, UserRespository userRepo, PostRespository postRepo, CommentRepository commentRepo) {


        this.connectionTest = connectionTest;
        this.userRepo = userRepo;
        this.postRepo = postRepo;
        this.commentRepo = commentRepo;
        this.careerRepo = careerRepo;
        this.tribeRepo = tribeRepo;
        this.assigment_tool = assigment_tool;
    }
    /* -Connection------------------------------------------------------------------------------------------ */


    @GetMapping("/testing")
    public String welcome(Model model) {

//        Career programmer = new Career("programmer");
//        Career lawyer = new Career("lawyer");
//        Career doctor = new Career("doctor");
//        Career scientist = new Career("scientist");
//        Career teacher = new Career("teacher");
//
//        careerRepo.save(programmer);
//        careerRepo.save(lawyer);
//        careerRepo.save(doctor);
//        careerRepo.save(scientist);
//        careerRepo.save(teacher);

        model.addAttribute("users", userRepo.findAll());
        model.addAttribute("posts", postRepo.findByUserId(1L));
        model.addAttribute("allComments", commentRepo.findAll());
        model.addAttribute("comments", commentRepo.findByUserId(2L));
        model.addAttribute("commentsByPostId", commentRepo.findByPostId(2L));
        model.addAttribute("careers", careerRepo.findAll());



        return "testing";
    }

}



