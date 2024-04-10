package com.devlukas.designpatterns.strategy;

import com.devlukas.designpatterns.behavioral.strategy.CalculationPerDay;
import com.devlukas.designpatterns.behavioral.strategy.CalculationPerHour;
import com.devlukas.designpatterns.behavioral.strategy.CalculationPerHourFixed;
import com.devlukas.designpatterns.behavioral.strategy.ParkingFee;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


public class TestParkingFee {

    @Test
    public void ParkingFeeFixedPerHour() {
        ParkingFee pf = new ParkingFee(3, new CalculationPerHour(4));

        var value = pf.value();
        Assertions.assertThat(value).isEqualTo(12.0);
    }

    @Test
    public void ParkingFeeInitialValueFixedPerHourAfter() {
        ParkingFee pf = new ParkingFee(5, new CalculationPerHourFixed(5, 3, 2));

        var value = pf.value();
        Assertions.assertThat(value).isEqualTo(9.0);
    }

    @Test
    public void ParkingFeeInitialValueFixedPerHourAfter_InsideOfLimit() {
        ParkingFee pf = new ParkingFee(2, new CalculationPerHourFixed(5, 3, 2));

        var value = pf.value();
        Assertions.assertThat(value).isEqualTo(5.0);
    }

    @Test
    public void ParkingFeeFixedDaily() {
        ParkingFee pf = new ParkingFee(50, new CalculationPerDay(20));

        var value = pf.value();
        Assertions.assertThat(value).isEqualTo(60.0);
    }

    @Test
    public void ParkingFeeFixedDailyLessThanOneDay() {
        ParkingFee pf = new ParkingFee(10, new CalculationPerDay(20));

        var value = pf.value();
        Assertions.assertThat(value).isEqualTo(20.0);
    }
}
