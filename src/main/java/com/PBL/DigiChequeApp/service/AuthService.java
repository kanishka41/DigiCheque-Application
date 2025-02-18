package com.PBL.DigiChequeApp.service;

import com.PBL.DigiChequeApp.dto.LoginRequest;

import com.PBL.DigiChequeApp.dto.RegisterRequest;
import com.PBL.DigiChequeApp.entity.BankAccount;
import com.PBL.DigiChequeApp.entity.User;
import com.PBL.DigiChequeApp.repository.UserRepository;
import com.PBL.DigiChequeApp.util.VerificationCodeUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private EmailService emailService; // Inject the email service

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    
    // Email regex pattern (basic email format validation)
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    public String register(RegisterRequest registerRequest) {
    	
        if (!isValidEmail(registerRequest.getEmail())) {
            return "Invalid email format. Please provide a valid email address.";
        }
    	
    	
        Optional<User> existingUser = userRepository.findByEmail(registerRequest.getEmail());

        if (existingUser.isPresent()) {
            return "Email already registered.";
        }
        
        // Generate verification code
        String verificationCode = VerificationCodeUtil.generateVerificationCode();

        User user = new User();
        user.setName(registerRequest.getName());
        user.setEmail(registerRequest.getEmail());
        user.setPhoneNumber(registerRequest.getPhoneNumber());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword())); // Secure password
        user.setVerificationCode(verificationCode);  // Set the generated verification code
        user.setStatus("PENDING_VERIFICATION"); // User is in pending verification status
        
        // Handle BankAccount
        if (registerRequest.getBankAccount() != null) {
            BankAccount bankAccount = new BankAccount();
            bankAccount.setAccountNumber(registerRequest.getBankAccount().getAccountNumber());
            bankAccount.setAccountType(registerRequest.getBankAccount().getAccountType());
            bankAccount.setBalance(registerRequest.getBankAccount().getBalance());
            bankAccount.setUser(user); // Bidirectional mapping
            user.setBankAccount(bankAccount);
        }

        userRepository.save(user);
       
        
        // Send email with verification code
        emailService.sendVerificationEmail(registerRequest.getEmail(), verificationCode);

        return "User registered successfully! Please check your email for the verification code.";
    }
        
    // Method to check email validity using regex
    private boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
        



    public String login(LoginRequest loginRequest) {
        Optional<User> user = userRepository.findByEmail(loginRequest.getEmail());

        if (!user.isPresent() || !passwordEncoder.matches(loginRequest.getPassword(), user.get().getPassword())) {
            return "Invalid email or password.";
        }

        return "Login successful!";
    }
    
    

    
}

