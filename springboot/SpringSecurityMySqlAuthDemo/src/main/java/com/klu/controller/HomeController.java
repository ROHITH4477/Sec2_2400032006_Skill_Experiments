package com.klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.klu.entity.User;
import com.klu.repo.UserRepository;

@RestController
public class HomeController {

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    UserRepository repo;

    // Home API
    @GetMapping("/")
    public String home(){
        return "Welcome Home";
    }

    // Dashboard API
    @GetMapping("/dashboard")
    public String dashboard(){
        return "Login Successful Dashboard";
    }

    // Admin API
    @GetMapping("/admin")
    public String admin(){
        return "Welcome Admin";
    }

    // API to save user in database
    @GetMapping("/save")
    public String saveUser(){
        User u = new User();
        u.setUsername("admin");
        u.setPassword(encoder.encode("admin123"));
        u.setRole("ADMIN");

        repo.save(u);

        return "User saved";
    }
}