package com.PBL.DigiChequeApp.repository;

import com.PBL.DigiChequeApp.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
