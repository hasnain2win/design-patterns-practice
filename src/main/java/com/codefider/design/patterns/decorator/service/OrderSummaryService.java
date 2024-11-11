package com.codefider.design.patterns.decorator.service;

import com.codefider.design.patterns.decorator.model.Beverage;

public interface OrderSummaryService {

    public String getOrderSummary();
    public void addOrder(Beverage beverage);
}
