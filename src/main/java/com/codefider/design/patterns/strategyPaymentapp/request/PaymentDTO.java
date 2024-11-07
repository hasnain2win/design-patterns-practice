package com.codefider.design.patterns.strategyPaymentapp.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {

    private Double amount;          // Total amount for the payment
    private String paymentMethod;   // Payment method (e.g., PayPal, CreditCard, COD, etc.)
    private Double totalAmount;     // Total amount after applying any charges or discounts
    private String status;          // Payment status (e.g., "Pending", "Completed", etc.)
    private String transactionId;   // Unique transaction ID for the payment
    private CardDetailsDTO cardDetails;
    private Integer emiDuration;
    private Double emiAmount;

    // Optionally, you can add other fields such as customer information or payment date
}

