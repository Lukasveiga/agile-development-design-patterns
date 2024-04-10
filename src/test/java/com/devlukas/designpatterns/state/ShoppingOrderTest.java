package com.devlukas.designpatterns.state;

import com.devlukas.designpatterns.behavioral.state.shopping.shoppingOrder.ShoppingOrder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ShoppingOrderTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private ShoppingOrder order;

    @BeforeEach
    public void setUpStreams() {
        order = new ShoppingOrder();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void shoppingOrderPending() {
        order.shipOrder();

        Assertions.assertThat(outContent.toString()).isEqualTo("Cannot send product while order is pending...\n");
    }

    @Test
    void shoppingOrderRejected() {
        order.rejectPayment();
        order.shipOrder();

        Assertions.assertThat(outContent.toString()).isEqualTo(
                """
                        Current State: OrderRejected
                        Order rejected, send product is no longer possible
                        """);
    }

    @Test
    void shoppingOrderApproved() {
        order.approvePayment();
        order.shipOrder();

        Assertions.assertThat(outContent.toString()).isEqualTo(
                """
                        Current State: OrderApproved
                        Sending product to the client...
                        """);
    }

    @Test
    void shoppingOrderChangeStateAfterOrderRejected() {
        order.rejectPayment();
        order.waitPayment();
        order.approvePayment();
        order.shipOrder();

        Assertions.assertThat(outContent.toString()).isEqualTo(
                """
                        Current State: OrderRejected
                        Order rejected, pending is no longer possible
                        Order rejected, approval is no longer possible
                        Order rejected, send product is no longer possible
                        """);
    }
}
