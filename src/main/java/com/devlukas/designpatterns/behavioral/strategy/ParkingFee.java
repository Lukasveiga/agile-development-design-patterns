package com.devlukas.designpatterns.behavioral.strategy;

public class ParkingFee {

    private final int amountHours;
    private final FeeCalculation feeCalculation;
    public ParkingFee(int amountHours, FeeCalculation feeCalculation) {
        this.feeCalculation = feeCalculation;
        this.amountHours = amountHours;

        System.out.println();
    }

    public double value() {
        return this.feeCalculation.calculateFee(this.amountHours);
    }
}
