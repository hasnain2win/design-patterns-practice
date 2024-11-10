package com.codefider.design.patterns.observer.service;

import com.codefider.design.patterns.observer.observer.CustomerNotificationService;
import com.codefider.design.patterns.observer.subject.ProductNotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationManager {

    private final ProductNotificationService productNotificationService;

    @Autowired
    public NotificationManager(ProductNotificationService productNotificationService,
                               CustomerNotificationService customerNotificationService) {
        this.productNotificationService = productNotificationService;

        // Register observers
        productNotificationService.addObserver(customerNotificationService);
    }
    public void notifyBackInStock(String productId) {
        productNotificationService.notifyBackInStock(productId);
    }

    public void notifyDiscount(String productId, double discount) {
        productNotificationService.notifyDiscount(productId, discount);
    }

    public void notifyPriceDrop(String productId, double newPrice) {
        productNotificationService.notifyPriceDrop(productId, newPrice);
    }
}
