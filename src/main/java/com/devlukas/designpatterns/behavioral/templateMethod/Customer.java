package com.devlukas.designpatterns.behavioral.templateMethod;

public class Customer {
    private String name;
    private Integer age;
    private String cpf;

    public Customer() {
    }

    public Customer(String name, Integer age, String cpf) {
        this.name = name;
        this.age = age;
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
