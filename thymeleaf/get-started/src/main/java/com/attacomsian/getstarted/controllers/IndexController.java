package com.attacomsian.getstarted.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model) {

        // add `message` attribute
        model.addAttribute("message", "Thank you for visiting.");

        // return view name
        return "index";
    }
}
