package com.codefider.design.patterns.decorator.model;

public class Coffee implements Beverage{

    @Override
    public String getDescription() {
        return "Coffee";
    }

    @Override
    public double getCost() {
        return 5.0;
    }
}
