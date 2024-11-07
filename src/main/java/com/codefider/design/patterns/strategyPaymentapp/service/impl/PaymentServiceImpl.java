package com.codefider.design.patterns.strategyPaymentapp.service.impl;

import com.codefider.design.patterns.strategyPaymentapp.model.Payment;
import com.codefider.design.patterns.strategyPaymentapp.repository.PaymentRepository;
import com.codefider.design.patterns.strategyPaymentapp.request.PaymentDTO;
import com.codefider.design.patterns.strategyPaymentapp.service.PaymentService;
import com.codefider.design.patterns.strategyPaymentapp.service.strategy.PaymentStrategy;
import com.codefider.design.patterns.strategyPaymentapp.service.strategy.factory.PaymentStrategyFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.codefider.design.patterns.strategyPaymentapp.constants.PaymentStatus.COMPLETED;
import static com.codefider.design.patterns.strategyPaymentapp.constants.PaymentStatus.PENDING;

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentStrategyFactory paymentStrategyFactory;

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public PaymentDTO processPayment(PaymentDTO paymentDTO) {
        log.info("Processing payment for payment type {}", paymentDTO.getPaymentMethod());

        // Fetch the appropriate payment strategy
        PaymentStrategy paymentStrategy = paymentStrategyFactory.getPaymentStrategy(paymentDTO.getPaymentMethod());
        log.info("Strategy for payment type {}, paymentStrategy: {}", paymentDTO.getPaymentMethod(), paymentStrategy.getClass().getSimpleName());

        // Calculate the final amount using the selected strategy
        Double calculatedAmount = paymentStrategy.calculate(paymentDTO.getAmount());
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
             paymentStrategy.pay(payment);
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
