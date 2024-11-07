package com.codefider.design.patterns.strategyPaymentapp.service.strategy.factory;

import com.codefider.design.patterns.strategyPaymentapp.service.strategy.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentStrategyFactory {

    @Autowired
    private CreditCardPayment creditCardPayment;
    @Autowired
    private PayPalPayment payPalPayment;
    @Autowired
    private CODPayment codPayment;
    @Autowired
    private BuyNowPayLater buyNowPayLater;

    @Autowired
    private DebitCardPayment debitCardPayment;


    public PaymentStrategy getPaymentStrategy(String paymentMethod) {
        switch (paymentMethod.toUpperCase()) {
            case "CREDIT-CARD":
                return creditCardPayment;
            case "PAYPAL":
                return payPalPayment;
            case "COD":
                return codPayment;
            case "BUY-NOW-PAY-LATER":
                return buyNowPayLater;
            case "DEBIT-CARD":
                return debitCardPayment;
            default:
                throw new IllegalArgumentException("Invalid payment method: " + paymentMethod);
        }
    }
}
