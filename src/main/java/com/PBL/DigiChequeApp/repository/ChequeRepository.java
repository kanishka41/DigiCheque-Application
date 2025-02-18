package com.PBL.DigiChequeApp.repository;

import com.PBL.DigiChequeApp.entity.Cheque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChequeRepository extends JpaRepository<Cheque, Long> {
}
