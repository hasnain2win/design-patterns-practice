package com.codefider.design.patterns.decorator.model.decorator;

import com.codefider.design.patterns.decorator.model.Beverage;

public class BaseCostDecorator extends BeverageDecorator{

    private Double baseCost;
    public BaseCostDecorator(Beverage beverage, Double baseCost) {
        super(beverage);
        this.baseCost = baseCost;
    }
    @Override
    public String getDescription() {
        return beverage.getDescription();
    }

    @Override
    public double getCost() {
        return baseCost;
    }
}
