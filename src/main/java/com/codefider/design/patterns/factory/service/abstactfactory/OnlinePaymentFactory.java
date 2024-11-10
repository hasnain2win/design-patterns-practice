package com.codefider.design.patterns.factory.service.abstactfactory;

import com.codefider.design.patterns.factory.service.factory.PaymentFactory;
import com.codefider.design.patterns.factory.service.factory.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("online")
public class OnlinePaymentFactory implements PaymentServiceAbstractFactory{

     final Map<String, PaymentService> onlinePaymentServices;

    public OnlinePaymentFactory(Map<String, PaymentService> onlinePaymentServices) {
        this.onlinePaymentServices = onlinePaymentServices;
    }

    @Override
    public PaymentService getPaymentService(String paymentMethod) {
        PaymentService service = onlinePaymentServices.get(paymentMethod);
        if (service == null) {
            throw new IllegalArgumentException("Unknown online payment method: " + paymentMethod);
        }
        return service;
    }
}
