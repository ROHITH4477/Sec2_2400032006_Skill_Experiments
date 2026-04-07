package com.klu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    // Method to send email
    public String sendEmail(String toEmail,
                            String subject,
                            String body) {

        try {
            SimpleMailMessage message = new SimpleMailMessage();

            message.setFrom("yourgmail@gmail.com");
            message.setTo(toEmail);
            message.setSubject(subject);
            message.setText(body);

            mailSender.send(message);

            return "Email sent successfully";
        } 
        catch (Exception e) {
            return "Error while sending email: " + e.getMessage();
        }
    }
}
