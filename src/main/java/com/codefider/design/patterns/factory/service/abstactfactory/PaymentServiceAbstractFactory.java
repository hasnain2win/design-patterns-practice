package com.codefider.design.patterns.factory.service.abstactfactory;

import com.codefider.design.patterns.factory.service.factory.PaymentService;

public interface  PaymentServiceAbstractFactory {
    PaymentService getPaymentService(String paymentType);
}