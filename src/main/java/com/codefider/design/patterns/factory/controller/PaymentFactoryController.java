package com.codefider.design.patterns.factory.controller;

import com.codefider.design.patterns.factory.service.impl.PaymentFactoryServiceImpl;
import com.codefider.design.patterns.strategyPaymentapp.request.PaymentDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("factory")
@Slf4j
public class PaymentFactoryController {

    @Autowired
    private PaymentFactoryServiceImpl paymentService;

    @PostMapping("/process-payment")
    public ResponseEntity<PaymentDTO> processPayment(@RequestBody PaymentDTO payment) {
        log.info("Processing payment method {}", payment.getPaymentMethod());

        return ResponseEntity.ok(paymentService.processPayment(payment));
    }
}
