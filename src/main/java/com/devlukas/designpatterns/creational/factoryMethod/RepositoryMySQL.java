package com.devlukas.designpatterns.creational.factoryMethod;

public class RepositoryMySQL implements Repository{
    @Override
    public String searchUserName(String id) {
        return "User from MySQL DB";
    }
}
