package com.devlukas.designpatterns.behavioral.strategy;

public class CalculationPerHourFixed implements FeeCalculation {

    private final int fixedInitialValue;
    private final int fixedInitialHours;
    private final int feeRateAfterInitialPeriod;

    public CalculationPerHourFixed(int fixedInitialValue, int fixedInitialHours, int feeRateAfterInitialPeriod) {
        this.fixedInitialValue = fixedInitialValue;
        this.fixedInitialHours = fixedInitialHours;
        this.feeRateAfterInitialPeriod = feeRateAfterInitialPeriod;
    }

    @Override
    public double calculateFee(int amountHours) {
        if (amountHours >= fixedInitialHours) {
            return this.fixedInitialValue + (feeRateAfterInitialPeriod * (amountHours - fixedInitialHours));
        }

        return this.fixedInitialValue;

    }
}
