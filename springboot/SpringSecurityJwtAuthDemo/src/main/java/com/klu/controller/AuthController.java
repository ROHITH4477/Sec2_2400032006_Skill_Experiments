package com.klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.klu.config.JwtUtil;
import com.klu.entity.User;
import com.klu.repo.UserRepository;

@RestController
@RequestMapping("/auth")
public class AuthController {

 @Autowired
 AuthenticationManager authManager;

 @Autowired
 JwtUtil jwtUtil;

 @Autowired
 UserRepository repo;

 @Autowired
 PasswordEncoder encoder;

 // register
 @PostMapping("/register")
 public String register(@RequestBody User user){
     user.setPassword(encoder.encode(user.getPassword()));
     repo.save(user);
     return "User Registered";
 }

 // login
 @PostMapping("/login")
 public String login(@RequestBody User user){

     authManager.authenticate(
             new UsernamePasswordAuthenticationToken(
                     user.getUsername(), user.getPassword())
     );

     return jwtUtil.generateToken(user.getUsername());
 }
}
