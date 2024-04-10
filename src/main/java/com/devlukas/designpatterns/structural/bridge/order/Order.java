package com.devlukas.designpatterns.structural.bridge.order;

import com.devlukas.designpatterns.structural.bridge.delivery.DeliveryType;
import com.devlukas.designpatterns.structural.bridge.Product;

public abstract class Order {

    private final DeliveryType deliveryType;

    protected Order(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }

    public abstract void price(Product product);

    public int deliveryTime() {
        return this.deliveryType.deliveryTime();
    }
}
