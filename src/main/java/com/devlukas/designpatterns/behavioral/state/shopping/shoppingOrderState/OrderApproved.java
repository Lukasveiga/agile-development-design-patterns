package com.devlukas.designpatterns.behavioral.state.shopping.shoppingOrderState;

import com.devlukas.designpatterns.behavioral.state.shopping.shoppingOrder.ShoppingOrder;

public class OrderApproved implements ShoppingOrderState {

    private final ShoppingOrder shoppingOrder;

    public OrderApproved(ShoppingOrder shoppingOrder) {
        this.shoppingOrder = shoppingOrder;
    }
    @Override
    public String getName() {
        return "OrderApproved";
    }

    @Override
    public void approvePayment() {
        System.out.println("Order already approved");
    }

    @Override
    public void rejectPayment() {
        this.shoppingOrder.setState(new OrderRejected(this.shoppingOrder));
    }

    @Override
    public void waitPayment() {
        this.shoppingOrder.setState(new OrderPending(this.shoppingOrder));
    }

    @Override
    public void shipOrder() {
        System.out.println("Sending product to the client...");
    }
}
