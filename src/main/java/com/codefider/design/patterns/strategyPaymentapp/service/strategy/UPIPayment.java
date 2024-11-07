package com.codefider.design.patterns.strategyPaymentapp.service.strategy;

import com.codefider.design.patterns.strategyPaymentapp.model.Payment;
import com.codefider.design.patterns.strategyPaymentapp.request.PaymentDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UPIPayment implements PaymentStrategy {

    public static final Double charge=0.05;

    @Override
    public Double calculate(Double amount) {
        log.info("Calculating UPI payment for amount {}", amount);
        return amount * charge;
    }

    @Override
    public Payment pay(Payment payment) {

        log.info("Paying UPI payment for amount {}", payment.getTotalAmount());
        return payment;
    }

}
