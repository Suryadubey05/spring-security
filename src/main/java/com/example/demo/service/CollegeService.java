package com.example.demo.service;

import com.example.demo.model.Person;
import com.example.demo.repository.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CollegeService {

    @Autowired
    CollegeRepository collegeRepository;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String addPerson(Person person) {
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        person.setRoles("STUDENT");
        collegeRepository.save(person);


        return "person added!";
    }
}
