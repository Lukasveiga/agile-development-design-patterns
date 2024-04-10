package com.devlukas.designpatterns.structural.proxy.repositoryAccess;

import java.util.ArrayList;
import java.util.List;

public class LogProductRepository extends ProductRepository {

    private final List<String> logs;

    public LogProductRepository() {
        this.logs = new ArrayList<>();
    }

    @Override
    public Object findById(long id) {
        logs.add("Search product with id: " + id);
        return super.findById(id);
    }

    public List<String> getLogs() {
        return logs;
    }
}
