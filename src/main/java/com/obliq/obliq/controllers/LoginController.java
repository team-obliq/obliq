package com.obliq.obliq.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login_get() {

        System.out.println("Login_working");


        return "login";

    }

    @PostMapping("/login")
    public String login_post() {

        System.out.println("working");


        return "login";

    }

    @GetMapping("/login/{user}")
    public String login_get_var(@PathVariable String user) {

        System.out.println(user + " Login_working");


        return "login";

    }



}
