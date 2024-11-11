package com.codefider.design.patterns.decorator.controller;


import com.codefider.design.patterns.decorator.model.Beverage;
import com.codefider.design.patterns.decorator.model.Size;
import com.codefider.design.patterns.decorator.service.BeverageService;
import com.codefider.design.patterns.decorator.service.OrderSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/beverages")
public class BeverageController {

    @Autowired
    private BeverageService beverageService;

    @Autowired
    private OrderSummaryService orderSummaryService;

    @GetMapping("/order")
    public String orderBeverage(
            @RequestParam String type,
            @RequestParam Size size,
            @RequestParam(required = false, defaultValue = "false") boolean addMilk,
            @RequestParam(required = false, defaultValue = "false") boolean addSugar,
            @RequestParam(required = false, defaultValue = "false") boolean addVanilla,
            @RequestParam(required = false, defaultValue = "false") boolean addWhippedCream,
            @RequestParam(required = false, defaultValue = "false") boolean addHoney) {

        Beverage beverage = beverageService.createBeverage(type, size, addMilk, addSugar, addVanilla, addWhippedCream, addHoney);
        // Add the beverage to the order summary
        orderSummaryService.addOrder(beverage);

        return "Your " + size.name() + " " + beverage.getDescription() + " costs $" + beverage.getCost();
    }

    @GetMapping("/summary")
    public String getOrderSummary() {

        return orderSummaryService.getOrderSummary();
    }
}