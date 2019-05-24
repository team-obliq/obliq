package com.obliq.obliq.CTRL;

import com.obliq.obliq.REPOS.*;
import com.obliq.obliq.SERVICE.tribe_assigment_SRV;
import org.springframework.stereotype.Controller;

@Controller
public class signup_CTRL {

    /* -Connection------------------------------------------------------------------------------------------ */
    private UserRepository userRepo;
    private PostRepository postRepo;
    private CommentRepository commentRepo;
    private CareersRepository careerRepo;
    private TribesRepository tribeRepo;

    private tribe_assigment_SRV assigment_tool;

    public signup_CTRL(TribesRepository tribeRepo, UserRepository userRepo, PostRepository postRepo, CommentRepository commentRepo, CareersRepository careerRepo, tribe_assigment_SRV assigment_tool) {
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
