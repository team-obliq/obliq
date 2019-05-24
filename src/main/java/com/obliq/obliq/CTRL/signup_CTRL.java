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
}
