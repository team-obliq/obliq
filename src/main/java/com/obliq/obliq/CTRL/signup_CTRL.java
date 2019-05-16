package com.obliq.obliq.CTRL;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class signup_CTRL {

    @GetMapping("/signup")
    public String signup_get() {

        System.out.println("signup_working");


        return "signup";

    }

    @PostMapping("/signup")
    public String login_post() {

        System.out.println("working");


        return "signup";

    }

    @GetMapping("/signup/{user}")
    public String login_get_var(@PathVariable String user) {

        System.out.println(user + " signup_working");


        return "signup";

    }



}
