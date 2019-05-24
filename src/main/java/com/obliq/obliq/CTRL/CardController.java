package com.obliq.obliq.CTRL;

import com.obliq.obliq.ENTITYS.Card;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/fragments")
@ResponseBody
public class CardController {
    public String getCards(Model model){

        model.addAttribute("card", new Card());

        return "card";
    }
}
