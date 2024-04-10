package com.devlukas.designpatterns.bridge;

import com.devlukas.designpatterns.structural.bridge.Product;
import com.devlukas.designpatterns.structural.bridge.delivery.ExpressDelivery;
import com.devlukas.designpatterns.structural.bridge.delivery.NormalDelivery;
import com.devlukas.designpatterns.structural.bridge.order.OrderRetail;
import com.devlukas.designpatterns.structural.bridge.order.OrderWhosale;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderDeliveryTest {

    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product("Pepper Jelly", 12.0);
    }

    @Test
    void testWhoSaleOrderExpressDelivery() {
        var order = new OrderWhosale(new ExpressDelivery());
        order.price(product);

        Assertions.assertThat(Math.floor(product.getPrice() * 100)/100).isEqualTo(10.8);
        Assertions.assertThat(order.deliveryTime()).isEqualTo(5);
    }

    @Test
    void testRetailOrderNormalDelivery() {
        var order = new OrderRetail(new NormalDelivery());
        order.price(product);

        Assertions.assertThat(Math.floor(product.getPrice() * 100)/100).isEqualTo(11.39);
        Assertions.assertThat(order.deliveryTime()).isEqualTo(10);
    }

    @Test
    void testWhoSaleOrderNormalDelivery() {
        var order = new OrderWhosale(new NormalDelivery());
        order.price(product);

        Assertions.assertThat(Math.floor(product.getPrice() * 100)/100).isEqualTo(10.8);
        Assertions.assertThat(order.deliveryTime()).isEqualTo(10);
    }

    @Test
    void testRetailOrderExpressDelivery() {
        var order = new OrderRetail(new ExpressDelivery());
        order.price(product);

        Assertions.assertThat(Math.floor(product.getPrice() * 100)/100).isEqualTo(11.39);
        Assertions.assertThat(order.deliveryTime()).isEqualTo(5);
    }
}
