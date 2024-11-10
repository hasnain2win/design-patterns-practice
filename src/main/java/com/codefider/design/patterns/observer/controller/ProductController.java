package com.codefider.design.patterns.observer.controller;

import com.codefider.design.patterns.observer.service.NotificationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private final NotificationManager notificationManager;

    @Autowired
    public ProductController(NotificationManager notificationManager) {
        this.notificationManager = notificationManager;
    }

    @GetMapping("/backInStock")
    public String notifyBackInStock(@RequestParam String productId) {
        notificationManager.notifyBackInStock(productId);
        return "Back in stock notification sent.";
    }

    @GetMapping("/discount")
    public String notifyDiscount(@RequestParam String productId, @RequestParam double discount) {
        notificationManager.notifyDiscount(productId, discount);
        return "Discount notification sent.";
    }

    @GetMapping("/priceDrop")
    public String notifyPriceDrop(@RequestParam String productId, @RequestParam double newPrice) {
        notificationManager.notifyPriceDrop(productId, newPrice);
        return "Price drop notification sent.";
    }
}

