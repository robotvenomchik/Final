package org.example.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Welcome to Our Shop");
        model.addAttribute("description", "We are a leading retailer of high-quality products. Our mission is to provide the best products and services to our customers.");
        return "home";
    }
}
