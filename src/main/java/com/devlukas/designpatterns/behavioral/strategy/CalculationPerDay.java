package com.devlukas.designpatterns.behavioral.strategy;

public class CalculationPerDay implements FeeCalculation {

    private final int dailyValue;
    public CalculationPerDay(int dailyValue) {
        this.dailyValue = dailyValue;
    }

    @Override
    public double calculateFee(int amountHours) {
        return this.dailyValue * Math.ceil((double) amountHours /24);
    }
}
