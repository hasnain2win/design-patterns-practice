package com.codefider.design.patterns.observer.subject;

import com.codefider.design.patterns.observer.enums.NotificationType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductNotificationService extends ProductSubject {

    public void notifyBackInStock(String productId) {
        String message = "Product " + productId + " is back in stock.";
        notifyObservers(NotificationType.STOCK_UPDATE,productId, message);
    }
    public void notifyDiscount(String productId,Double discountPercentage) {
        String message = "Product " + productId + " has a " + discountPercentage + "% discount.";
        notifyObservers(NotificationType.DISCOUNT_APPLIED,productId, message);
    }
    public void notifyPriceDrop(String productId, double newPrice) {
        String message = "Product " + productId + " price dropped to " + newPrice + ".";
        notifyObservers(NotificationType.PRICE_DROP, productId, message);
    }
}
