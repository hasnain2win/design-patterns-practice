package com.codefider.design.patterns.strategyPaymentapp.service.strategy;

import com.codefider.design.patterns.strategyPaymentapp.model.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CODPayment implements PaymentStrategy {

    public static final Double charge = 0.0;  // No additional charge for COD
    public static final Double discount = 0.05;  // 5% discount for COD payment

    @Override
    public Double calculate(Double amount) {
        log.info("Calculating COD Payment for amount {}", amount);

        // Apply the discount
        Double discountedAmount = amount - (amount * discount);

        // Total amount is the amount after discount
        log.info("CODPayment: Discount applied: {}. Total amount to pay: {}", amount * discount, discountedAmount);

        return discountedAmount;
    }

    @Override
    public Payment pay(Payment payment) {
        log.info("Paying COD Payment for amount {}", payment.getAmount());
        return payment;
    }
}
