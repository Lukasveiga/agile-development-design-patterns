package com.devlukas.designpatterns.structural.proxy.repositoryAccess;

public interface IProductRepository {

    Object findById(long id);
}
