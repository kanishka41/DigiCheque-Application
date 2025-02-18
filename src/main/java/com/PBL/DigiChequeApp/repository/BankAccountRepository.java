package com.PBL.DigiChequeApp.repository;

import com.PBL.DigiChequeApp.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
    BankAccount findByUserId(Long userId);
}

