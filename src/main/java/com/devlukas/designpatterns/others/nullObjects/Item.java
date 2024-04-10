package com.devlukas.designpatterns.others.nullObjects;

public class Item {

    private final String name;
    private Discount discount = new NoDiscount();
    private final double price;

    public Item(String name, double price, Discount discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double totalPrice(int quantity) {
        return discount.calculate(this.price * quantity);
    }
}
