package com.devlukas.designpatterns.structural.proxy.repositoryAccess;

public class ProductRepository implements IProductRepository{

    public ProductRepository() {
        simulateDelay();
    }

    public Object findById(long id) {
        simulateDelay();
        return new Object();
    }

    private void simulateDelay() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
