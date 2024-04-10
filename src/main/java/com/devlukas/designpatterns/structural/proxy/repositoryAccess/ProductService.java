package com.devlukas.designpatterns.structural.proxy.repositoryAccess;

public class ProductService {

    private final IProductRepository productRepository;

    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Object findProductById(long id) {
        return this.productRepository.findById(id);
    }
}
