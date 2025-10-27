package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CollegeController {

    @Autowired
    CollegeService collegeService;

    @GetMapping("/home")
    public String home(){
        return "welcome to home!";
    }

    @GetMapping("/admin")
    public String admin(){
        return "welcome to admin panel";
    }

    @GetMapping("/student")
    public String student(){
        return "welcome to student panel";
    }

    @PostMapping("/signup")
    public String addPerson(@RequestBody Person person){
        return collegeService.addPerson(person);
    }


}
