package com.codefider.design.patterns.factory.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardDetailsDTO {
    private String cardNumber;
    private String cvv;
    private String expiryDate;
    private String holderName;
    private String cardType;
}
