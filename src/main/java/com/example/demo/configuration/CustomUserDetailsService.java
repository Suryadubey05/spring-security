package com.example.demo.configuration;

import com.example.demo.model.Person;
import com.example.demo.repository.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    CollegeRepository collegeRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person = collegeRepository.findByUsername(username);
        if(person==null){
            throw new RuntimeException("Invalid username");
        }

        return new CustomUserDetails(person);
    }
}
