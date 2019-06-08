package com.obliq.obliq.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {

    @GetMapping("/about-us")
    public String aboutUs(Model model){

        return "about";
    }

}