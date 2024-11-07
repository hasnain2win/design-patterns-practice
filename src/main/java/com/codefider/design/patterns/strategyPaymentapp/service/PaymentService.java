package com.codefider.design.patterns.strategyPaymentapp.service;


import com.codefider.design.patterns.strategyPaymentapp.request.PaymentDTO;

public interface PaymentService {
    public PaymentDTO processPayment(PaymentDTO payment);
}
