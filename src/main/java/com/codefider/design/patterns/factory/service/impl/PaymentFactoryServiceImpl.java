package com.codefider.design.patterns.factory.service.impl;

import com.codefider.design.patterns.factory.service.abstactfactory.PaymentAbstractFactory;
import com.codefider.design.patterns.factory.service.abstactfactory.PaymentServiceAbstractFactory;
import com.codefider.design.patterns.factory.service.factory.PaymentFactory;
import com.codefider.design.patterns.factory.service.factory.PaymentService;
import com.codefider.design.patterns.strategyPaymentapp.model.Payment;
import com.codefider.design.patterns.strategyPaymentapp.repository.PaymentRepository;
import com.codefider.design.patterns.strategyPaymentapp.request.PaymentDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import static com.codefider.design.patterns.strategyPaymentapp.constants.PaymentStatus.COMPLETED;
@Service
@Slf4j
public class PaymentFactoryServiceImpl {

    @Autowired
    PaymentFactory paymentFactory;

    @Autowired
    PaymentAbstractFactory paymentAbstractFactory;


    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private PaymentAbstractFactory paymentServiceAbstractFactory;


    public PaymentDTO processPayment(PaymentDTO paymentDTO) {
        log.info("Processing payment for payment type {}", paymentDTO.getPaymentMethod());
        PaymentService paymentService=paymentFactory.getPaymentService(paymentDTO.getPaymentMethod());

        // Calculate the final amount using the selected strategy
        Double calculatedAmount = paymentService.calculate(paymentDTO.getAmount());
        if (calculatedAmount != null) {
            paymentDTO.setTotalAmount(calculatedAmount);
            // Mark payment as processed
             Payment payment = new Payment();
             payment.setAmount(paymentDTO.getAmount());
             payment.setCurrency("INR");
             payment.setTotalAmount(calculatedAmount);
             payment.setPaymentMethod(paymentDTO.getPaymentMethod());
             payment.setTransactionId(generateTransactionId());
             payment.setEmiDuration(paymentDTO.getEmiDuration());
             paymentService.pay(payment);
             payment = paymentRepository.save(payment);

             // Save to the database
             log.info("Payment saved with transaction ID: {}", payment.getTransactionId());
             if(payment.getId()!=null) {
                 paymentDTO.setStatus(COMPLETED.toString());
                 paymentDTO.setTotalAmount(payment.getTotalAmount());
                 paymentDTO.setTransactionId(payment.getTransactionId());
                 paymentDTO.setEmiAmount(payment.getEmiAmount());
             }
         }

        log.info("Payment processed for payment type {} with calculatedAmount {}", paymentDTO.getPaymentMethod(), calculatedAmount);
        return paymentDTO;
    }

    public PaymentDTO processPaymentAbstract(PaymentDTO paymentDTO,String paymentType) {
        log.info("Processing payment for payment type {}", paymentDTO.getPaymentMethod());
        PaymentService paymentService=paymentAbstractFactory.getPaymentService(paymentType,paymentDTO.getPaymentMethod());

        // Calculate the final amount using the selected strategy
        Double calculatedAmount = paymentService.calculate(paymentDTO.getAmount());
        if (calculatedAmount != null) {
            paymentDTO.setTotalAmount(calculatedAmount);
            // Mark payment as processed
            Payment payment = new Payment();
            payment.setAmount(paymentDTO.getAmount());
            payment.setCurrency("INR");
            payment.setTotalAmount(calculatedAmount);
            payment.setPaymentMethod(paymentDTO.getPaymentMethod());
            payment.setTransactionId(generateTransactionId());
            payment.setEmiDuration(paymentDTO.getEmiDuration());
            paymentService.pay(payment);
            payment = paymentRepository.save(payment);

            // Save to the database
            log.info("Payment saved with transaction ID: {}", payment.getTransactionId());
            if(payment.getId()!=null) {
                paymentDTO.setStatus(COMPLETED.toString());
                paymentDTO.setTotalAmount(payment.getTotalAmount());
                paymentDTO.setTransactionId(payment.getTransactionId());
                paymentDTO.setEmiAmount(payment.getEmiAmount());
            }
        }

        log.info("Payment processed for payment type {} with calculatedAmount {}", paymentDTO.getPaymentMethod(), calculatedAmount);
        return paymentDTO;
    }


    // Generate a unique transaction ID (you can customize this method)
    private String generateTransactionId() {
        return "TXN-" + System.currentTimeMillis();
    }
}
