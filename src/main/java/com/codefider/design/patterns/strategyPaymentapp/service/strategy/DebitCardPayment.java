package com.codefider.design.patterns.strategyPaymentapp.service.strategy;

import com.codefider.design.patterns.strategyPaymentapp.model.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DebitCardPayment implements PaymentStrategy {
    public static final Double charge = 0.08;
    public static final Double discount = 0.0;

    @Override
    public Double calculate(Double amount) {
        log.info("Calculating debit card payment" + amount);
        return amount +(amount * charge);
    }

    @Override
    public Payment pay(Payment payment) {
        log.info("Paying debit card payment" + payment.getTotalAmount());
        return null;
    }
}
