package com.PBL.DigiChequeApp.service;

import com.PBL.DigiChequeApp.entity.Cheque;
import com.PBL.DigiChequeApp.entity.User;
import com.PBL.DigiChequeApp.repository.ChequeRepository;
import com.PBL.DigiChequeApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ChequeService {

    @Autowired
    private ChequeRepository chequeRepository;

    @Autowired
    private UserRepository userRepository;

    public String createCheque(Long userId, double amount, String payeeName, String purpose) {
        User user = userRepository.findById(userId).orElse(null);

        if (user == null) {
            return "User not found.";
        }

        Cheque cheque = new Cheque();
        cheque.setAmount(amount);
        cheque.setPayeeName(payeeName);
        cheque.setPurpose(purpose);
        cheque.setStatus("Created");
        cheque.setIssueDate(new Date());

        chequeRepository.save(cheque);

        return "Cheque created successfully!";
    }

    public String scheduleCheque(Long chequeId, Date scheduledDate) {
        Cheque cheque = chequeRepository.findById(chequeId).orElse(null);

        if (cheque == null) {
            return "Cheque not found.";
        }

        cheque.setScheduledDate(scheduledDate);
        cheque.setStatus("Scheduled");

        chequeRepository.save(cheque);

        return "Cheque scheduled successfully!";
    }

    public String trackChequeStatus(Long chequeId) {
        Cheque cheque = chequeRepository.findById(chequeId).orElse(null);

        if (cheque == null) {
            return "Cheque not found.";
        }

        return "Cheque status: " + cheque.getStatus();
    }
}


