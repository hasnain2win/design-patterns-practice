package com.codefider.design.patterns.decorator.model;

public class Espresso implements Beverage {


    @Override
    public String getDescription() {
        return "Espresso";
    }

    @Override
    public double getCost() {
        return 6.0;
    }
}
