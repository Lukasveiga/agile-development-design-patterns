package com.devlukas.designpatterns.structural.bridge.order;

import com.devlukas.designpatterns.structural.bridge.delivery.DeliveryType;
import com.devlukas.designpatterns.structural.bridge.Product;

public class OrderWhosale extends Order{
    public OrderWhosale(DeliveryType deliveryType) {
        super(deliveryType);
    }

    @Override
    public void price(Product product) {
        double descount = 10;
        product.setPrice(product.getPrice() * (1 - descount /100));
    }
}
