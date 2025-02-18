package com.PBL.DigiChequeApp.service;

import com.PBL.DigiChequeApp.entity.Transaction;
import com.PBL.DigiChequeApp.entity.User;
import com.PBL.DigiChequeApp.repository.TransactionRepository;
import com.PBL.DigiChequeApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NotificationService notificationService;

    public String processTransaction(Long issuerId, Long payeeId, double amount) {
        User issuer = userRepository.findById(issuerId).orElse(null);
        User payee = userRepository.findById(payeeId).orElse(null);

        if (issuer == null || payee == null) {
            return "Invalid users.";
        }

        // Create the transaction
        Transaction transaction = new Transaction();
        transaction.setIssuer(issuer);
        transaction.setPayee(payee);
        transaction.setAmount(amount);
        transaction.setStatus("Pending");
        transaction.setTransactionDate(new Date());

        transactionRepository.save(transaction);

        // Send notification to both users
        notificationService.sendTransactionNotification(issuer, "Your transaction is pending.");
        notificationService.sendTransactionNotification(payee, "You have received a transaction.");

        return "Transaction processed successfully.";
    }

    public String viewTransactionDetails(Long transactionId) {
        Transaction transaction = transactionRepository.findById(transactionId).orElse(null);

        if (transaction == null) {
            return "Transaction not found.";
        }

        return transaction.toString();
    }
}


