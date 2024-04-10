package com.devlukas.designpatterns.creational.builder;

public class NameGeneratorBuilder {

    private NameGenerator ng;

    public NameGenerator generate() {
        return ng;
    }

    public NameGeneratorBuilder base() {
        ng = new NameGenerator();
        return this;
    }

    public NameGeneratorBuilder master() {
        ng = new MasterGenerator();
        return this;
    }

    public NameGeneratorBuilder doctor() {
        ng = new DoctorGenerator();
        return this;
    }

    public NameGeneratorBuilder excellent() {
        if(ng.getDesignationStrategy() instanceof NullDesignation) {
            ng.setDesignation(new Excellent());
        } else {
            ng.setDesignation(new DesignationComposite(ng.getDesignationStrategy(), new Excellent()));
        }
        return this;
    }

    public NameGeneratorBuilder magnificent() {
        if(ng.getDesignationStrategy() instanceof NullDesignation) {
            ng.setDesignation(new Magnificent());
        } else {
            ng.setDesignation(new DesignationComposite(ng.getDesignationStrategy(), new Magnificent()));
        }
        return this;
    }
}
