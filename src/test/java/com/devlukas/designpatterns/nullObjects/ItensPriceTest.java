package com.devlukas.designpatterns.nullObjects;

import com.devlukas.designpatterns.others.nullObjects.Item;
import com.devlukas.designpatterns.others.nullObjects.PercentDiscount;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItensPriceTest {

    @Test
    void totalPriceWithoutAnyDiscount() {
        var item = new Item("T-Shirt", 75.50);
        var totalPrice = item.totalPrice(2);
        Assertions.assertThat(totalPrice).isEqualTo(151);
    }

    @Test
    void totalPriceWithPercentDiscount() {
        var discount = new PercentDiscount(10);
        var item = new Item("T-Shirt", 75.50, discount);
        var totalPrice = item.totalPrice(2);
        Assertions.assertThat(totalPrice).isEqualTo(135.90);
    }
}
