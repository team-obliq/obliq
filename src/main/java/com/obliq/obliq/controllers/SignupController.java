package com.obliq.obliq.controllers;

import com.obliq.obliq.repositories.*;
import com.obliq.obliq.service.TribeAssignmentService;
import org.springframework.stereotype.Controller;

@Controller
public class SignupController {

    /* -Connection------------------------------------------------------------------------------------------ */
    private UserRespository userRepo;
    private PostRespository postRepo;
    private CommentRepository commentRepo;
    private CareersRepository careerRepo;
    private TribesRepository tribeRepo;

    private TribeAssignmentService assigment_tool;

    public SignupController(TribesRepository tribeRepo, UserRespository userRepo, PostRespository postRepo, CommentRepository commentRepo, CareersRepository careerRepo, TribeAssignmentService assigment_tool) {
        this.userRepo = userRepo;
        this.postRepo = postRepo;
        this.commentRepo = commentRepo;
        this.careerRepo = careerRepo;
        this.tribeRepo = tribeRepo;
        this.assigment_tool = assigment_tool;
    }
    /* -Connection------------------------------------------------------------------------------------------ */
//
//    @GetMapping("/old_signup")
//    public String signup_get(Model model) {
//
//
//
//        List<Career> careerList =  new ArrayList<>();
//        for(Career x: careerRepo.findAll()) {
//            careerList.add(x);
//        }
//
//        List<Career> careerListAdd =  new ArrayList<>();
//
//
//        model.addAttribute("careerList", careerList);
//        model.addAttribute("user", new User());
//        model.addAttribute("careerListAdd", careerListAdd);


//        return "old_signup";

//    }

//    @PostMapping("/signup")
//    public String login_post(@ModelAttribute User user) {
//
//        assigment_tool.tribe_assigment_master_tool(user);
//
//        userRepo.save(user);
//
//        assigment_tool.UPDATE_tribe_member_count();
//
//        return "signup";
////        return "redirect:/profile";
//
//    }


}
