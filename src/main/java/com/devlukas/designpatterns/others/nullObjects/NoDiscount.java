package com.devlukas.designpatterns.others.nullObjects;

public class NoDiscount implements Discount{
    @Override
    public double calculate(double value) {
        return value;
    }
}
