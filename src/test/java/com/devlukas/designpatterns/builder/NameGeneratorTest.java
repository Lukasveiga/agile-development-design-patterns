package com.devlukas.designpatterns.builder;

import com.devlukas.designpatterns.creational.builder.NameGeneratorBuilder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class NameGeneratorTest {

    @Test
    void testGenerateBaseName() {
        var ng = new NameGeneratorBuilder().base().generate();
        var name = ng.generateName("Lukas");
        Assertions.assertThat(name).isEqualTo("Lukas");
    }

    @Test
    void testGenerateMasterName() {
        var ng = new NameGeneratorBuilder().master().generate();
        var name = ng.generateName("Lukas");
        Assertions.assertThat(name).isEqualTo("Master Lukas");
    }

    @Test
    void testGenerateDoctorName() {
        var ng = new NameGeneratorBuilder().doctor().generate();
        var name = ng.generateName("Lukas");
        Assertions.assertThat(name).isEqualTo("Doctor Lukas");
    }


    @Test
    void testGenerateDoctorExcellentName() {
        var ng = new NameGeneratorBuilder().doctor().excellent().generate();
        var name = ng.generateName("Lukas");
        Assertions.assertThat(name).isEqualTo("Excellent Doctor Lukas");
    }

    @Test
    void testGenerateDoctorMagnificentExcellentName() {
        var ng = new NameGeneratorBuilder().doctor().excellent().magnificent().generate();
        var name = ng.generateName("Lukas");
        Assertions.assertThat(name).isEqualTo("Excellent Magnificent Doctor Lukas");
    }
}