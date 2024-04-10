package com.devlukas.designpatterns.factoryMethod;

import com.devlukas.designpatterns.creational.factoryMethod.RepositoryFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepositoryFactoryTest {

    @Test
    void repositoryFactoryMySQL() {
        var repository = RepositoryFactory.getInstance("prod");
        Assertions.assertThat(repository.searchUserName("1")).isEqualTo("User from MySQL DB");
    }

    @Test
    void repositoryFactoryInMemory() {
        var repository = RepositoryFactory.getInstance("dev");
        Assertions.assertThat(repository.searchUserName("1")).isEqualTo("User from In Memory DB");
    }
}
