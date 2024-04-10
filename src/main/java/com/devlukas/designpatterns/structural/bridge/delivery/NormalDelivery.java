package com.devlukas.designpatterns.structural.bridge.delivery;

public class NormalDelivery implements DeliveryType {
    @Override
    public int deliveryTime() {
        return 10;
    }
}
