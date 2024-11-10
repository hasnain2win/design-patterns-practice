package com.codefider.design.patterns.factory.service.factory;

import com.codefider.design.patterns.strategyPaymentapp.model.Payment;
import com.codefider.design.patterns.strategyPaymentapp.service.strategy.PaymentStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("debit-card")
public class DebitCardPayment implements PaymentService {
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
