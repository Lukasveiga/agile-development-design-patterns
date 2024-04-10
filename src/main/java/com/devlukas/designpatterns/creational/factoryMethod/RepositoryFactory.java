package com.devlukas.designpatterns.creational.factoryMethod;

public class RepositoryFactory {
    public static Repository getInstance(String env) {
        return env.equals("prod") ? new RepositoryMySQL() : new RepositoryInMemory();
    }
}


