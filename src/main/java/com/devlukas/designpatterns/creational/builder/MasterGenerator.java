package com.devlukas.designpatterns.creational.builder;

public class MasterGenerator extends NameGenerator {
    @Override
    protected String getDesignation() {
        return "Master ";
    }
}
