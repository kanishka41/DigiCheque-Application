package com.PBL.DigiChequeApp.service;


import com.PBL.DigiChequeApp.entity.BankAccount;
import com.PBL.DigiChequeApp.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankAccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    public String validateAccount(Long userId) {
        BankAccount account = bankAccountRepository.findByUserId(userId);

        if (account == null) {
            return "Bank account not linked to user.";
        }

        return "Account is valid.";
    }

    public String updateBalance(Long userId, double amount) {
        BankAccount account = bankAccountRepository.findByUserId(userId);

        if (account == null) {
            return "Bank account not found.";
        }

        account.setBalance(account.getBalance() + amount);
        bankAccountRepository.save(account);

        return "Balance updated successfully.";
    }
}



