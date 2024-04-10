package com.devlukas.designpatterns.structural.proxy.repositoryAccess;

public class LazyProductRepository implements IProductRepository {

    private IProductRepository productRepository;

    @Override
    public Object findById(long id) {
        initializerRepository();
        return this.productRepository.findById(id);
    }

    private void initializerRepository() {
        if(productRepository == null) {
            productRepository = new ProductRepository();
        }
    }
}
