package com.example.minnanonihongo_test_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/landingpage")
public class HomeController {

    @GetMapping("/home")
    public String showHomePage() {
        return "landingpage/home"; // đường dẫn tới templates/landingpage/home.html
    }
}
