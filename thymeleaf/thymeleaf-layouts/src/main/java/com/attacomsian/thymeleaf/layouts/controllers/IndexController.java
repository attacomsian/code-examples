package com.attacomsian.thymeleaf.layouts.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String homePage() {
        return "index";
    }

    @GetMapping("/contact")
    public String contactPage() {
        return "contact";
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }
}
