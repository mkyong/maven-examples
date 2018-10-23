package com.mkyong.web.controller;

import com.mkyong.password.PasswordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {

    private final Logger logger = LoggerFactory.getLogger(WelcomeController.class);

    @Autowired
    private PasswordService passwordService;

    @GetMapping("/")
    public String welcome(@RequestParam(name = "query",
            required = false, defaultValue = "123456") String query, Model model) {

        logger.debug("Welcome to mkyong.com... Query : {}", query);

        model.addAttribute("query", query);
        model.addAttribute("hash", passwordService.hash(query));
        model.addAttribute("algorithm", passwordService.algorithm());

        return "index";
    }

}
