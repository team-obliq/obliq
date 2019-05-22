package com.obliq.obliq.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SplashController {

    @GetMapping("/splash")
    public String getSplash(Model model){
        return "splash";
    }

    @PostMapping("/")
    public String postSplash() {

        return "splash";
    }
}
