package com.PBL.DigiChequeApp.controller;

import com.PBL.DigiChequeApp.entity.User;
import com.PBL.DigiChequeApp.service.NotificationService;
import com.PBL.DigiChequeApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private UserRepository userRepository;

    // Endpoint to manually trigger a notification
    @PostMapping("/send")
    public String sendNotification(@RequestParam Long userId, @RequestParam String message) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            notificationService.sendTransactionNotification(user, message);
            return "Notification sent successfully!";
        }
        return "User not found!";
    }
}


