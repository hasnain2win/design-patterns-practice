package com.codefider.design.patterns.decorator.service;


import com.codefider.design.patterns.decorator.model.*;
import com.codefider.design.patterns.decorator.model.decorator.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BeverageServiceImpl implements BeverageService {


    @Override
    public Beverage createBeverage(String type, Size size, boolean addMilk, boolean addSugar, boolean addVanilla, boolean addWhippedCream, boolean addHoney) {
        Beverage beverage;
        // Select base beverage
        switch (type.toLowerCase()) {
            case "coffee":
                beverage = new Coffee();
                break;
            case "tea":
                beverage = new Tea();
                break;
            case "espresso":
                beverage = new Espresso();
                break;
            default:
                throw new IllegalArgumentException("Unknown beverage type");
        }

        // Apply size cost
        double baseCost = beverage.getCost() + size.getAdditionalCost();
        beverage=new BaseCostDecorator(beverage, baseCost);

        // Add decorators based on preferences
        if (addMilk) beverage = new MilkDecorator(beverage);
        if (addSugar) beverage = new SugarDecorator(beverage);
        if (addVanilla) beverage = new VanillaDecorator(beverage);
        if (addWhippedCream) beverage = new WhippedCreamDecorator(beverage);
        if (addHoney) beverage = new HoneyDecorator(beverage);
        return beverage;
    }
}
