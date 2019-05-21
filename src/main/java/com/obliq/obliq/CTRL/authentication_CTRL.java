package com.obliq.obliq.CTRL;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class authentication_CTRL {
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
}
