package com.devlukas.designpatterns.creational.builder;

public class NameGenerator {

    private Designation designation = new NullDesignation();

    public String generateName(String baseName) {
        return this.designation.designate() + getDesignation() + baseName;
    }

    protected String getDesignation() {
        return "";
    }

    public Designation getDesignationStrategy() {
        return this.designation;
    }

    public void setDesignation(Designation designation) {
        this.designation = designation;
    }
}
