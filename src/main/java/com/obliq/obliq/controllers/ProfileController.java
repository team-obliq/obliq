package com.obliq.obliq.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProfileController {

    @GetMapping("/profile")
    public String profile_get() {

        System.out.println("profile_working");


        return "profile";

    }

    @PostMapping("/profile")
    public String profile_post() {

        System.out.println("profile");


        return "profile";

    }

    @GetMapping("/profile/{user}")
    public String login_get_var(@PathVariable String user) {

        System.out.println(user + " profile_working");


        return "profile";

    }



}
