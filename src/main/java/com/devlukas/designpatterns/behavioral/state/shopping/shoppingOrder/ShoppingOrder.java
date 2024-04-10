package com.devlukas.designpatterns.behavioral.state.shopping.shoppingOrder;

import com.devlukas.designpatterns.behavioral.state.shopping.shoppingOrderState.OrderPending;
import com.devlukas.designpatterns.behavioral.state.shopping.shoppingOrderState.ShoppingOrderState;

public class ShoppingOrder {

    private ShoppingOrderState shoppingOrderState = new OrderPending(this);

    public ShoppingOrderState getState() {
        return this.shoppingOrderState;
    }

    public void setState(ShoppingOrderState state) {

        this.shoppingOrderState = state;
        System.out.println("Current State: " + this.shoppingOrderState.getName());
    }

    public String getStateName() {
        return this.shoppingOrderState.getName();
    }

    public void approvePayment() {
        this.shoppingOrderState.approvePayment();
    }

    public void waitPayment() {
        this.shoppingOrderState.waitPayment();
    }

    public void rejectPayment() {
        this.shoppingOrderState.rejectPayment();
    }

    public void shipOrder() {
        this.shoppingOrderState.shipOrder();
    }
}
