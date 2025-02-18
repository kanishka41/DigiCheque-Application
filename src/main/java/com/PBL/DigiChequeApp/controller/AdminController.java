package com.PBL.DigiChequeApp.controller;

import com.PBL.DigiChequeApp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Endpoint to review and approve/reject cheques
    @PostMapping("/reviewCheque")
    public String reviewCheque(@RequestParam Long chequeId, @RequestParam boolean approve) {
        return adminService.reviewCheque(chequeId, approve);
    }

    // Endpoint to process transactions
    @PostMapping("/processTransaction")
    public String processTransaction(@RequestParam Long transactionId, @RequestParam String status) {
        return adminService.processTransaction(transactionId, status);
    }

    // Endpoint to get user details (for admin)
    @GetMapping("/user/{userId}")
    public String getUserDetails(@PathVariable Long userId) {
        return adminService.getUserDetails(userId);
    }
}


