package com.obliq.obliq.TESTING;




import com.obliq.obliq.ENTITYS.Career;
import com.obliq.obliq.ENTITYS.Tribe;
import com.obliq.obliq.ENTITYS.User;
import com.obliq.obliq.REPOS.*;
import com.obliq.obliq.SERVICE.tribe_assigment_SRV;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Random;

import java.lang.reflect.Array;
import java.util.*;

@Controller
public class testing_CTRL {

    /* -Connection------------------------------------------------------------------------------------------ */
    private testing_Repo connectionTest;
    private UserRespository userRepo;
    private PostRespository postRepo;
    private CommentRepository commentRepo;
    private CareersRepository careerRepo;
    private TribesRepository tribeRepo;

    private tribe_assigment_SRV assigment_tool;

    public testing_CTRL(tribe_assigment_SRV assigment_tool, TribesRepository tribeRepo, testing_Repo connectionTest, UserRespository userRepo, PostRespository postRepo, CommentRepository commentRepo, CareersRepository careerRepo) {
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

        assigment_tool.CREATE_a_new_tribe();



        return "testing";
    }

}



