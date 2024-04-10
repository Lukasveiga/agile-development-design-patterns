package com.devlukas.designpatterns.proxy.repositoryAccess;

import com.devlukas.designpatterns.structural.proxy.repositoryAccess.CacheProductRepository;
import com.devlukas.designpatterns.structural.proxy.repositoryAccess.LazyProductRepository;
import com.devlukas.designpatterns.structural.proxy.repositoryAccess.LogProductRepository;
import com.devlukas.designpatterns.structural.proxy.repositoryAccess.ProductService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestProxyRepository {

    @Test
    void testProxyRepositoryLog() {
        var repository = new LogProductRepository();
        var service = new ProductService(repository);

        var product = service.findProductById(1);

        var logs = repository.getLogs();
        Assertions.assertThat(product).isNotNull();
        Assertions.assertThat(logs.size()).isEqualTo(1);
        Assertions.assertThat(logs.get(0)).isEqualTo("Search product with id: 1");
    }

    @Test
    void testProxyRepositoryCache() {
        var repository = new CacheProductRepository();
        var service = new ProductService(repository);

        var product = service.findProductById(1);

        Assertions.assertThat(product).isNotNull();
        Assertions.assertThat(CacheProductRepository.CACHE.size()).isEqualTo(1);
        Assertions.assertThat(CacheProductRepository.CACHE.get(1L)).isEqualTo(product);
    }

    @Test
    void testProxyRepositoryLazy() {
        var repository = new LazyProductRepository();
        var service = new ProductService(repository);

        var product = service.findProductById(1);

        Assertions.assertThat(product).isNotNull();
    }
}
