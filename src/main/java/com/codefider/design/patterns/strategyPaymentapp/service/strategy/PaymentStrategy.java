package com.codefider.design.patterns.strategyPaymentapp.service.strategy;

import com.codefider.design.patterns.strategyPaymentapp.model.Payment;

public interface PaymentStrategy {
    public Double calculate(Double amount);
    public Payment pay(Payment payment);
}


