package com.obliq.obliq.CTRL;

import com.obliq.obliq.ENTITYS.test;
import com.obliq.obliq.REPOS.test_Repo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class testing_CTRL {

    /* -Connection------------------------------------------------------------------------------------------ */
    private test_Repo connectionTest;

    public testing_CTRL(test_Repo connectionTest) {
        this.connectionTest = connectionTest;
    }
    /* -Connection------------------------------------------------------------------------------------------ */


    @GetMapping("/testing")
    public String welcome() {

        System.out.println("working");

        test test = new test();


        return "testing";
    }


}



