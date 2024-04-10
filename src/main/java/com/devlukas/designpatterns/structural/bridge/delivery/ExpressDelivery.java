package com.devlukas.designpatterns.structural.bridge.delivery;

public class ExpressDelivery implements DeliveryType{
    @Override
    public int deliveryTime() {
        return 5;
    }
}
