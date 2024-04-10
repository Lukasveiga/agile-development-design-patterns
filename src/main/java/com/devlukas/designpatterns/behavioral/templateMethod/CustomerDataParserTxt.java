package com.devlukas.designpatterns.behavioral.templateMethod;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CustomerDataParserTxt extends CustomerDataParser {

    public CustomerDataParserTxt(String filePath) {
        super(filePath);
    }

    @Override
    protected List<Customer> parseData() {
        List<Customer> customersData = new ArrayList<>();

        try {
            List<String> customerDataLines = Files.readAllLines(Paths.get(this.filePath));

            for(String line: customerDataLines) {
                var tokens = List.of(line.split(" "));
                tokens = tokens.stream().filter(s -> !s.isBlank()).toList();

                Customer customer = new Customer(tokens.get(0), Integer.getInteger(tokens.get(1)), tokens.get(2));
                customersData.add(customer);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return customersData;
    }
}
