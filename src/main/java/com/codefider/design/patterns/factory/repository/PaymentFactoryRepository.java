package com.codefider.design.patterns.factory.repository;


import com.codefider.design.patterns.strategyPaymentapp.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentFactoryRepository extends JpaRepository<Payment, Long> {
    Payment findByTransactionId(String transactionId);
}