package com.PBL.DigiChequeApp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PBL.DigiChequeApp.entity.User;
import com.PBL.DigiChequeApp.repository.UserRepository;

@Service
public class VerifyEmailService {

    @Autowired
    private UserRepository userRepository;

    public String verifyEmail(String email, String verificationCode) {
        // Find the user by email
        Optional<User> userOptional = userRepository.findByEmail(email);

        if (!userOptional.isPresent()) {
            return "User not found.";
        }

        User user = userOptional.get();

        // Check if the verification code matches
        if (!user.getVerificationCode().equals(verificationCode)) {
            return "Invalid verification code.";
        }

        // If the code is correct, update the user's status to 'VERIFIED'
        user.setStatus("VERIFIED");
        userRepository.save(user);

        return "Email verified successfully!";
    }
}

