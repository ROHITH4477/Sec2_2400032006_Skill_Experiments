package com.klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.service.EmailService;

@RestController
@RequestMapping("/mail")
public class EmailController {

    @Autowired
    private EmailService emailService;

    // Send email API
    @PostMapping("/send")
    public String sendMail(@RequestParam String to,
                           @RequestParam String subject,
                           @RequestParam String body) {

        return emailService.sendEmail(to, subject, body);
    }
}


