package com.codefider.design.patterns.strategyPaymentapp.controller;

import com.codefider.design.patterns.strategyPaymentapp.request.PaymentDTO;
import com.codefider.design.patterns.strategyPaymentapp.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/process-payment")
    public ResponseEntity<PaymentDTO> processPayment(@RequestBody PaymentDTO payment) {
        log.info("Processing payment method {}", payment.getPaymentMethod());

        return ResponseEntity.ok(paymentService.processPayment(payment));
    }
}
