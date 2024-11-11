package com.codefider.design.patterns.decorator.model;

public class Tea implements Beverage{
    @Override
    public String getDescription() {
        return "Simple Tea";
    }

    @Override
    public double getCost() {
        return 5;
    }
}
