package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CollegeController {

    @GetMapping("/home")
    public String home(){
        return "welcome to home!";
    }

    @GetMapping("/admin")
    public String admin(){
        return "welcome to admin panel";
    }

    @GetMapping("/students")
    public String student(){
        return "welcome to student panel";
    }

}
