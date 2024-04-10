package com.devlukas.designpatterns.creational.builder;

public class DesignationComposite implements Designation {

    private Designation d1;
    private Designation d2;

    public DesignationComposite(Designation d1, Designation d2) {
        this.d1 = d1;
        this.d2 = d2;
    }

    @Override
    public String designate() {
        return d1.designate() + d2.designate();
    }
}
