package com.codefider.design.patterns.factory.service.factory;

import com.codefider.design.patterns.strategyPaymentapp.model.Payment;

public interface PaymentService {
    public Double calculate(Double amount);
    public Payment pay(Payment payment);
}


