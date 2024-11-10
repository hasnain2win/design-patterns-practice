package com.codefider.design.patterns.factory.service.factory;


import com.codefider.design.patterns.strategyPaymentapp.model.Payment;
import com.codefider.design.patterns.strategyPaymentapp.service.strategy.PaymentStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("credit-card")
@Slf4j
public class CreditCardPayment implements PaymentService {

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
