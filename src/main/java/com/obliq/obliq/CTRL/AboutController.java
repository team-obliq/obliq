package com.obliq.obliq.CTRL;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AboutController {

    @GetMapping("/about-us")
    public String aboutUs(Model model){

        return "about";
    }

}