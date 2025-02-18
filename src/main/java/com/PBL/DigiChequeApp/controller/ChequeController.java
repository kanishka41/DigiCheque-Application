package com.PBL.DigiChequeApp.controller;

import com.PBL.DigiChequeApp.service.ChequeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/cheques")
public class ChequeController {

    @Autowired
    private ChequeService chequeService;

    @PostMapping("/create/{userId}")
    public String createCheque(@PathVariable Long userId, @RequestParam double amount, @RequestParam String payeeName, @RequestParam String purpose) {
        return chequeService.createCheque(userId, amount, payeeName, purpose);
    }

    @PostMapping("/schedule/{chequeId}")
    public String scheduleCheque(@PathVariable Long chequeId, @RequestParam Date scheduledDate) {
        return chequeService.scheduleCheque(chequeId, scheduledDate);
    }

    @GetMapping("/track/{chequeId}")
    public String trackChequeStatus(@PathVariable Long chequeId) {
        return chequeService.trackChequeStatus(chequeId);
    }
}


