package com.devlukas.designpatterns.others.nullObjects;

public class PercentDiscount implements Discount {

    private final double percent;
    public PercentDiscount(double percent) {
        this.percent = percent;
    }

    @Override
    public double calculate(double value) {
        return value * (1 - (this.percent/100));
    }
}

