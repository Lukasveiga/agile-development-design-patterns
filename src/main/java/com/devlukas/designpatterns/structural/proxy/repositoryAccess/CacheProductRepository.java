package com.devlukas.designpatterns.structural.proxy.repositoryAccess;

import java.util.HashMap;

public class CacheProductRepository extends ProductRepository{

    public static final HashMap<Long, Object> CACHE = new HashMap<>();

    @Override
    public Object findById(long id) {
        var product = CACHE.get(id);
        if (product == null) {
            product = super.findById(id);
            CACHE.put(id, product);
            return product;
        }
        return product;
    }
}
