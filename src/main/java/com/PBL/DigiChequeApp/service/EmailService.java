package com.PBL.DigiChequeApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    // Send email with verification code
    public void sendVerificationEmail(String toEmail, String verificationCode) {
        String subject = "Email Verification Code";
        String text = "Your verification code is: " + verificationCode;

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(text);

        javaMailSender.send(message);
    }
}

