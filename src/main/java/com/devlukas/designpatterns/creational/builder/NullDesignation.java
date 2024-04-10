package com.devlukas.designpatterns.creational.builder;

public class NullDesignation implements Designation {
    @Override
    public String designate() {
        return "";
    }
}
