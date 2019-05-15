package com.obliq.obliq.TESTING;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class testing_CTRL {

    /* -Connection------------------------------------------------------------------------------------------ */
    private testing_Repo connectionTest;

    public testing_CTRL(testing_Repo connectionTest) {
        this.connectionTest = connectionTest;
    }
    /* -Connection------------------------------------------------------------------------------------------ */


    @GetMapping("/testing")
    public String welcome() {

        System.out.println("working");


        return "testing";
    }


}



