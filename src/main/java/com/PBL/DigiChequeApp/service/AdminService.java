package com.PBL.DigiChequeApp.service;

import com.PBL.DigiChequeApp.entity.Cheque;
import com.PBL.DigiChequeApp.entity.Transaction;
import com.PBL.DigiChequeApp.entity.User;
import com.PBL.DigiChequeApp.repository.ChequeRepository;
import com.PBL.DigiChequeApp.repository.TransactionRepository;
import com.PBL.DigiChequeApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private ChequeRepository chequeRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NotificationService notificationService;

    // Method to approve or reject a cheque
    public String reviewCheque(Long chequeId, boolean approve) {
        Optional<Cheque> cheque = chequeRepository.findById(chequeId);

        if (cheque.isEmpty()) {
            return "Cheque not found.";
        }

        Cheque chequeToReview = cheque.get();
        if (approve) {
            chequeToReview.setStatus("Approved");
            // Notify the user
            notificationService.sendTransactionNotification(chequeToReview.getUser(), "Your cheque has been approved.");
        } else {
            chequeToReview.setStatus("Rejected");
            // Notify the user
            notificationService.sendTransactionNotification(chequeToReview.getUser(), "Your cheque has been rejected.");
        }

        chequeRepository.save(chequeToReview);
        return "Cheque review completed.";
    }

    // Method to manage transactions (e.g., confirming status)
    public String processTransaction(Long transactionId, String status) {
        Optional<Transaction> transaction = transactionRepository.findById(transactionId);

        if (transaction.isEmpty()) {
            return "Transaction not found.";
        }

        Transaction transactionToProcess = transaction.get();
        transactionToProcess.setStatus(status);
        transactionRepository.save(transactionToProcess);

        // Notify the users
        notificationService.sendTransactionNotification(transactionToProcess.getIssuer(), "Transaction status updated to " + status);
        notificationService.sendTransactionNotification(transactionToProcess.getPayee(), "Transaction status updated to " + status);

        return "Transaction processed.";
    }

    // Method to retrieve user details (for admin to validate users)
    public String getUserDetails(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            return "User not found.";
        }
        return user.get().toString();
    }
}


