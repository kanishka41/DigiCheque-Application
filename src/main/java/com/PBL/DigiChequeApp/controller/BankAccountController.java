package com.PBL.DigiChequeApp.controller;

import com.PBL.DigiChequeApp.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bankaccount")
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    @GetMapping("/validate/{userId}")
    public String validateAccount(@PathVariable Long userId) {
        return bankAccountService.validateAccount(userId);
    }

    @PostMapping("/update/{userId}")
    public String updateBalance(@PathVariable Long userId, @RequestParam double amount) {
        return bankAccountService.updateBalance(userId, amount);
    }
}
