package com.codefider.design.patterns.strategyPaymentapp.service.strategy;


import com.codefider.design.patterns.strategyPaymentapp.model.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CreditCardPayment implements PaymentStrategy {

    public static final Double charge = 0.20;
    public static final Double discount = 0.0;

    @Override
    public Double calculate(Double amount) {
        log.info("Calculating Credit card payment" + amount);
        return amount +(amount * charge);
    }

    @Override
    public Payment pay(Payment payment) {
        log.info("Paying Credit card payment" + payment.getTotalAmount());
        return null;
    }

}
