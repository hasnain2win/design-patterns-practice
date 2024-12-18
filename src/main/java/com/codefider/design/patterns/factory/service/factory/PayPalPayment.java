package com.codefider.design.patterns.factory.service.factory;

import com.codefider.design.patterns.strategyPaymentapp.model.Payment;
import com.codefider.design.patterns.strategyPaymentapp.service.strategy.PaymentStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("payPal")
@Slf4j
public class PayPalPayment implements PaymentService {
    public static final Double charge = 0.10;  // 10% charge for PayPal payment

    @Override
    public Double calculate(Double amount) {
        log.info("PayPalPayment: Calculating payment amount for amount {}", amount);
        // Calculate 10% of the amount as the charge
        Double additionalCharge = amount * charge;
        Double totalAmount = amount + additionalCharge;

        log.info("PayPalPayment: Charge applied: {}. Total amount to pay: {}", additionalCharge, totalAmount);
        return totalAmount;
    }

    @Override
    public Payment pay(Payment payment) {
        log.info("PayPalPayment: Paying amount {}", payment.getTotalAmount());
        return payment;
    }
}
