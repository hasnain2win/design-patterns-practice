package com.codefider.design.patterns.decorator.model;

import lombok.Getter;

@Getter
public enum Size {
    SMALL(0),
    MEDIUM(1.00),
    LARGE(2.00);

    private final double additionalCost;

    Size(final double additionalCost) {
        this.additionalCost = additionalCost;
    }
}
