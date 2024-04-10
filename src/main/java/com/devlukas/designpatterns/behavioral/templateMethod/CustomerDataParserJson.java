package com.devlukas.designpatterns.behavioral.templateMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CustomerDataParserJson extends CustomerDataParser {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public CustomerDataParserJson(String filePath) {
        super(filePath);
    }

    @Override
    protected List<Customer> parseData() {

        List<Customer> customersData;

        try {
            customersData = objectMapper.readValue(new File(this.filePath), new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return customersData;
    }
}
