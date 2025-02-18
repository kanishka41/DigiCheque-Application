package com.PBL.DigiChequeApp.repository;

import com.PBL.DigiChequeApp.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}

