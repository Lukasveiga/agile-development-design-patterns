package com.devlukas.designpatterns.behavioral.templateMethod;

import java.util.List;

public abstract class CustomerDataParser {

    private List<Customer> customersData;
    protected final String filePath;

    protected CustomerDataParser(String filePath) {
        this.filePath = filePath;
    }

    public final void formatCustomerData() {
        this.customersData = this.parseData();
        this.formatCpf();
    }

    protected abstract List<Customer> parseData();

    private void formatCpf() {
        this.customersData.forEach(c -> c.setCpf(c.getCpf().replaceAll("[^0-9]", "")));
    };

    public List<Customer> getCustomersData() {
        return customersData;
    }
}
