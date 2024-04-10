package com.devlukas.designpatterns.creational.builder;

public class DoctorGenerator extends NameGenerator {

    @Override
    protected String getDesignation() {
        return "Doctor ";
    }
}
