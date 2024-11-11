package com.codefider.design.patterns.decorator.model.decorator;

import com.codefider.design.patterns.decorator.model.Beverage;

public class HoneyDecorator extends BeverageDecorator{

    public HoneyDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Honey";
    }

    @Override
    public double getCost() {
        return beverage.getCost() + 4;
    }
}
