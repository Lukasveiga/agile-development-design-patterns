package com.devlukas.designpatterns.templateMethod;

import com.devlukas.designpatterns.behavioral.templateMethod.CustomerDataParserJson;
import com.devlukas.designpatterns.behavioral.templateMethod.CustomerDataParserTxt;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerDataParserTest {

    private final String PATH = "src/test/java/com/devlukas/designpatterns/templateMethod/files/customer";

    @Test
    void customerDataParserTxtSuccess() {
        var customerDataParserTxt = new CustomerDataParserTxt(PATH + ".txt");
        customerDataParserTxt.formatCustomerData();
        var formatedCustomers = customerDataParserTxt.getCustomersData();

        Assertions.assertThat(formatedCustomers.get(0).getCpf()).isEqualTo("26137913066");
        Assertions.assertThat(formatedCustomers.get(1).getCpf()).isEqualTo("82864837072");
        Assertions.assertThat(formatedCustomers.get(2).getCpf()).isEqualTo("29780036008");
    }

    @Test
    void customerDataParserJsonSuccess() {
        var customerDataParserJson = new CustomerDataParserJson(PATH + ".json");
        customerDataParserJson.formatCustomerData();
        var formatedCustomers = customerDataParserJson.getCustomersData();

        Assertions.assertThat(formatedCustomers.get(0).getCpf()).isEqualTo("26137913066");
        Assertions.assertThat(formatedCustomers.get(1).getCpf()).isEqualTo("82864837072");
        Assertions.assertThat(formatedCustomers.get(2).getCpf()).isEqualTo("29780036008");
    }
}
