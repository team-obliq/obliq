package com.obliq.obliq.controllers;

import com.obliq.obliq.repositories.CardRepository;
import org.springframework.stereotype.Controller;

@Controller
public class CardController {
    private CardRepository cardRepo;


    public CardController(CardRepository cardRepo) {
        this.cardRepo = cardRepo;
    }
}
