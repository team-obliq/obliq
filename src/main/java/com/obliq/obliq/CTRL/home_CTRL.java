package com.obliq.obliq.CTRL;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class home_CTRL {

    @GetMapping("/index")
    public String indexPage() {

        return "index";
    }
}
