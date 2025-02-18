package com.PBL.DigiChequeApp.service;

import com.PBL.DigiChequeApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


@Service
public class NotificationService {

    @Autowired
    private JavaMailSender mailSender;

    // Method to send transaction notification (email and push)
    public void sendTransactionNotification(User user, String message) {
        sendEmailNotification(user, message);
        sendPushNotification(user, message);
    }

    // Send email notification
    private void sendEmailNotification(User user, String message) {
        jakarta.mail.internet.MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

        try {
            helper.setTo(user.getEmail());
            helper.setSubject("Digital Cheque Notification");
            helper.setText(message);
            mailSender.send(mimeMessage);
        } catch (jakarta.mail.MessagingException e) {
            e.printStackTrace();
        }
    }

    // Send push notification (temporary logic for now, could be integrated with a service like Firebase Cloud Messaging)
    private void sendPushNotification(User user, String message) {
        // Logic for push notifications (e.g., Firebase or OneSignal)
        System.out.println("Push Notification sent to " + user.getPhoneNumber() + ": " + message);
    }
}


