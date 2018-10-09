package com.mkyong.web.controller;

import com.mkyong.hashing.CommonsCodecService;
import com.mkyong.hashing.DigestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class WelcomeController {

    private final Logger logger = LoggerFactory.getLogger(WelcomeController.class);

    private DigestService digest = new CommonsCodecService();

    @GetMapping("/")
    public String index(Model model) {
        logger.debug("Welcome to mkyong.com...");

        String msg = getMessage();

        model.addAttribute("msg", msg);
        model.addAttribute("sha256", digest.sha256hex(msg));
        model.addAttribute("today", new Date());
        
        return "index";

    }

    public String getMessage() {
        return "Hello World";
    }

}
