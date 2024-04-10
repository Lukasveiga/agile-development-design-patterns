package com.devlukas.designpatterns.behavioral.state.shopping.shoppingOrderState;

import com.devlukas.designpatterns.behavioral.state.shopping.shoppingOrder.ShoppingOrder;

public class OrderPending implements ShoppingOrderState {

    private final ShoppingOrder shoppingOrder;

    public OrderPending(ShoppingOrder shoppingOrder) {
        this.shoppingOrder = shoppingOrder;
    }

    @Override
    public String getName() {
        return "OrderPending";
    }

    @Override
    public void approvePayment() {
        this.shoppingOrder.setState(new OrderApproved(this.shoppingOrder));
    }

    @Override
    public void rejectPayment() {
        this.shoppingOrder.setState(new OrderRejected(this.shoppingOrder));
    }

    @Override
    public void waitPayment() {
        System.out.println("Order is already pending");
    }

    @Override
    public void shipOrder() {
        System.out.println("Cannot send product while order is pending...");
    }
}
