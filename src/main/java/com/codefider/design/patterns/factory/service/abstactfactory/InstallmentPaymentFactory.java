package com.codefider.design.patterns.factory.service.abstactfactory;

import com.codefider.design.patterns.factory.service.factory.PaymentService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component("installment")
public class InstallmentPaymentFactory implements PaymentServiceAbstractFactory {


    final Map<String ,PaymentService> installmentPaymentsFactory;

    public InstallmentPaymentFactory(Map<String, PaymentService> installmentPaymentsFactory) {
        this.installmentPaymentsFactory = installmentPaymentsFactory;
    }


    @Override
    public PaymentService getPaymentService(String paymentType) {
        PaymentService paymentService = installmentPaymentsFactory.get(paymentType);
        if (paymentService == null) {
            throw new IllegalArgumentException("Unknown payment type: " + paymentType);
        }
        return paymentService;
    }
}
