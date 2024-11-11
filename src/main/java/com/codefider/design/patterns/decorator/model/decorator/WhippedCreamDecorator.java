package com.codefider.design.patterns.decorator.model.decorator;

import com.codefider.design.patterns.decorator.model.Beverage;

public class WhippedCreamDecorator extends BeverageDecorator{


    public WhippedCreamDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whipped Cream";
    }

    @Override
    public double getCost() {
        return beverage.getCost() + 2;
    }
}
