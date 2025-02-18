package com.PBL.DigiChequeApp.controller;

import com.PBL.DigiChequeApp.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/process")
    public String processTransaction(@RequestParam Long issuerId, @RequestParam Long payeeId, @RequestParam double amount) {
        return transactionService.processTransaction(issuerId, payeeId, amount);
    }

    @GetMapping("/details/{transactionId}")
    public String viewTransactionDetails(@PathVariable Long transactionId) {
        return transactionService.viewTransactionDetails(transactionId);
    }
}


