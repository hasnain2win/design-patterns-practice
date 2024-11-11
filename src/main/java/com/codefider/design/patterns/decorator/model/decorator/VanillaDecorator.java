package com.codefider.design.patterns.decorator.model.decorator;

import com.codefider.design.patterns.decorator.model.Beverage;

public class VanillaDecorator extends BeverageDecorator{

    public VanillaDecorator(Beverage beverage) {
        super(beverage);
    }
    @Override
    public String getDescription() {
        return beverage.getDescription()+" Vanilla";
    }

    @Override
    public double getCost() {
        return beverage.getCost()+ 3;
    }
}
