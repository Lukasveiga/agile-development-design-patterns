package com.devlukas.designpatterns.behavioral.strategy;

public class CalculationPerHour implements FeeCalculation {

    private final int hourValue;
    public CalculationPerHour(int hourValue) {
        this.hourValue = hourValue;
    }

    @Override
    public double calculateFee(int amountHours) {
        return amountHours * this.hourValue;
    }
}
