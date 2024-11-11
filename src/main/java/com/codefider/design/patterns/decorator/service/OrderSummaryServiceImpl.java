package com.codefider.design.patterns.decorator.service;

import com.codefider.design.patterns.decorator.model.Beverage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class OrderSummaryServiceImpl implements OrderSummaryService {

    private final List<Beverage> orders=new ArrayList<>();

    @Override
    public void addOrder(Beverage beverage) {
        orders.add(beverage);
    }

    @Override
    public String getOrderSummary() {
        if (orders.isEmpty()) {
            return "No orders placed yet.";
        }

        double totalCost = orders.stream().mapToDouble(Beverage::getCost).sum();
        StringBuilder summary = new StringBuilder("Order Summary:\n");

        for (Beverage beverage : orders) {
            summary.append("- ")
                    .append(beverage.getDescription())
                    .append(": $")
                    .append(beverage.getCost())
                    .append("\n");
        }

        summary.append("Total Order Cost: $").append(totalCost);
        return summary.toString();
    }
}
