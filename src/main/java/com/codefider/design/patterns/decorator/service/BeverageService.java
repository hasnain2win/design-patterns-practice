package com.codefider.design.patterns.decorator.service;

import com.codefider.design.patterns.decorator.model.Beverage;
import com.codefider.design.patterns.decorator.model.Size;

public interface BeverageService {

    public Beverage createBeverage(String type, Size size, boolean addMilk, boolean addSugar, boolean addVanilla, boolean addWhippedCream, boolean addHoney);
}
