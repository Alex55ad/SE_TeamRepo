package com.rss.se.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    private String defaultMessage = "";

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("message", "Hello" + defaultMessage);
        return "index"; // Thymeleaf view name
    }

    @PostMapping("/greet")
    public String greetSubmit(@RequestParam("name") String name, Model model) {
        defaultMessage = defaultMessage + ", " + name;
        model.addAttribute("message", defaultMessage);
        return "index";
    }
    @PostMapping("/reset")
    public String reset(Model model) {
        defaultMessage = "";
        model.addAttribute("message", "");
        return "index";
    }

}
