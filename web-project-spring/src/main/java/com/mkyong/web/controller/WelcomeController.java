package com.mkyong.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class WelcomeController {

    @GetMapping("/")
    public String index(Model model){

        model.addAttribute("date", new Date());
        return "index";

    }
}
