package com.devlukas.designpatterns.creational.factoryMethod;

public class RepositoryInMemory implements Repository {
    @Override
    public String searchUserName(String id) {
        return "User from In Memory DB";
    }
}
