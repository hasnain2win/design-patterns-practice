package com.codefider.design.patterns.strategyPaymentapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    private String currency;

    @Column(name = "total_amount")
    private Double totalAmount;

    @Column(name = "payment_method")
    private String paymentMethod;

    private String status;
    @Column(name = "emi_duration")
    private Integer emiDuration;

    @Column(name="emi_amount")
    private Double emiAmount;

    @Column(name = "transaction_id", unique = true)
    private String transactionId;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @CreationTimestamp
    private LocalDateTime updatedAt;

}
