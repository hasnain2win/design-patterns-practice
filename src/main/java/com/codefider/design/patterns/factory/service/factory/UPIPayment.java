package com.codefider.design.patterns.factory.service.factory;

import com.codefider.design.patterns.strategyPaymentapp.model.Payment;
import com.codefider.design.patterns.strategyPaymentapp.service.strategy.PaymentStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("upi")
@Slf4j
public class UPIPayment implements PaymentService {

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
