package com.PBL.DigiChequeApp.controller;

import com.PBL.DigiChequeApp.dto.LoginRequest;
import com.PBL.DigiChequeApp.dto.RegisterRequest;
import com.PBL.DigiChequeApp.service.AuthService;
import com.PBL.DigiChequeApp.service.VerifyEmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;
    
    @Autowired
    private VerifyEmailService verifyEmailService;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest registerRequest) {
        return authService.register(registerRequest);
    }
    
    @PostMapping("/verify-email")
    public String verifyEmail(@RequestParam String email, @RequestParam String verificationCode) {
        return verifyEmailService.verifyEmail(email, verificationCode);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }
}
