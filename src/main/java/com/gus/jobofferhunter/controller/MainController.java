package com.gus.jobofferhunter.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    protected final Logger logger = LoggerFactory.getLogger(MainController.class);

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("message", "Pozdrawiamy!");
        return "loginForm";
    }

    @GetMapping("/mainForm")
    public String getMainForm(Model model) {

        return "mainForm";
    }
}
