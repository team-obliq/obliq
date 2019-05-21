
package com.obliq.obliq.CTRL;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class splash_CTRL {

    @GetMapping("/splash")
    public String getSplash(){

        return "splash";
    }

    @PostMapping("/splash")
    public String postSplash() {

        return "splash";
    }
}

