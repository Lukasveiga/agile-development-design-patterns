package com.devlukas.designpatterns.behavioral.state.shopping.shoppingOrderState;

import com.devlukas.designpatterns.behavioral.state.shopping.shoppingOrder.ShoppingOrder;

public class OrderRejected implements ShoppingOrderState {
    public OrderRejected(ShoppingOrder shoppingOrder) {
    }

    @Override
    public String getName() {
        return "OrderRejected";
    }

    @Override
    public void approvePayment() {
        System.out.println("Order rejected, approval is no longer possible");
    }

    @Override
    public void rejectPayment() {
        System.out.println("Order already rejected");
    }

    @Override
    public void waitPayment() {
        System.out.println("Order rejected, pending is no longer possible");
    }

    @Override
    public void shipOrder() {
        System.out.println("Order rejected, send product is no longer possible");
    }
}
