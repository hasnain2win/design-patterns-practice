package com.codefider.design.patterns.factory.service.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PaymentFactory {

    final Map<String, PaymentService> paymentService;

    @Autowired
    public PaymentFactory(Map<String, PaymentService> paymentService) {
        this.paymentService = paymentService;
    }


    public PaymentService getPaymentService(String paymentMethod) {
        PaymentService service = paymentService.get(paymentMethod);
        if (service == null) {
            throw new IllegalArgumentException("Unknown payment method: " + paymentMethod);
        }
        return service;
    }
}
