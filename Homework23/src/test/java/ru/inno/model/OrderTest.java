package ru.inno.model;

import org.apache.logging.log4j.core.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderTest {

    @Test
    void addNewOrder() {
        Order.addNewOrder();
        Assertions.assertEquals(2, Order.orderIdCounter);
    }

}