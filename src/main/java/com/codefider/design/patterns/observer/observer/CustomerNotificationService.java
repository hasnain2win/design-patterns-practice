package com.codefider.design.patterns.observer.observer;

import com.codefider.design.patterns.observer.enums.NotificationType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerNotificationService implements NotificationObserver {

    private final JavaMailSender mailSender;

    @Autowired
    public CustomerNotificationService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }


    @Override
    public void update(NotificationType type, String productId, String message) {
        String subject;
        switch (type) {
            case STOCK_UPDATE:
                subject = "Product Back in Stock!";
                break;
            case DISCOUNT_APPLIED:
                subject = "Discount Applied on Product!";
                break;
            case PRICE_DROP:
                subject = "Price Drop Alert!";
                break;
            default:
                subject = "Product Notification";
        }

        // Send email notification
        sendEmailNotification(subject, message);
    }

    private void sendEmailNotification(String subject, String messageText) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo("hasnain.lead@gmail.com");
            message.setSubject(subject);
            message.setText(messageText);
        //    mailSender.send(message);
            log.info("Sending email to {}", message.getTo());
        }catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
