package com.mkyong.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class WelcomeController {

    private final Logger logger = LoggerFactory.getLogger(WelcomeController.class);

    @GetMapping("/")
    public String index(Model model) {
        logger.debug("Welcome to mkyong.com...");
        model.addAttribute("msg", getMessage());
        model.addAttribute("today", new Date());
        return "index";

    }

    public String getMessage() {
        return "Hello World";
    }

}
