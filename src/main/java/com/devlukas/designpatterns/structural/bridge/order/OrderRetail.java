package com.devlukas.designpatterns.structural.bridge.order;

import com.devlukas.designpatterns.structural.bridge.Product;
import com.devlukas.designpatterns.structural.bridge.delivery.DeliveryType;

public class OrderRetail extends Order{
    public OrderRetail(DeliveryType deliveryType) {
        super(deliveryType);
    }

    @Override
    public void price(Product product) {
        double descount = 5;
        product.setPrice(product.getPrice() * (1 - descount/100));
    }
}
