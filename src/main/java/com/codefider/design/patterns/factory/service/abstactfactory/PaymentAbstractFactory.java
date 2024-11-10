package com.codefider.design.patterns.factory.service.abstactfactory;

import com.codefider.design.patterns.factory.service.factory.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PaymentAbstractFactory {

    // The map will hold factories that correspond to different payment types
    final Map<String, PaymentServiceAbstractFactory> paymentServiceFactories;

    // Constructor injection of the map that holds all concrete factories
    @Autowired
    public PaymentAbstractFactory(Map<String, PaymentServiceAbstractFactory> paymentServiceFactories) {
        this.paymentServiceFactories = paymentServiceFactories;
    }

    /**
     * Get the payment service based on payment type and payment method.
     * @param paymentType e.g. "online", "installment"
     * @param paymentMethod e.g. "paypal", "stripe"
     * @return The PaymentService corresponding to the type and method
     */
    public PaymentService getPaymentService(String paymentType, String paymentMethod) {
        // Fetch the factory based on the payment type (like "online", "installment")
        PaymentServiceAbstractFactory factory = paymentServiceFactories.get(paymentType.toLowerCase());

        if (factory == null) {
            throw new IllegalArgumentException("Unknown payment type: " + paymentType);
        }

        // Use the factory to fetch the specific PaymentService for the given method (e.g. "paypal", "stripe")
        PaymentService paymentService = factory.getPaymentService(paymentMethod);

        if (paymentService == null) {
            throw new IllegalArgumentException("Unknown payment method: " + paymentMethod);
        }

        return paymentService;
    }
}
