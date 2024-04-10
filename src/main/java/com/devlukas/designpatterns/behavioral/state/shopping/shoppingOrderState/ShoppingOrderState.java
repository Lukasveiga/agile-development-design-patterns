package com.devlukas.designpatterns.behavioral.state.shopping.shoppingOrderState;

public interface ShoppingOrderState {

    String getName();
    void approvePayment();
    void rejectPayment();
    void waitPayment();

    void shipOrder();
}
