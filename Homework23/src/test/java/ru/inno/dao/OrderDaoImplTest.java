package ru.inno.dao;

import org.junit.jupiter.api.*;
import ru.inno.connection.ConnectionManager;
import ru.inno.exception.IllegalIdException;
import ru.inno.mock.ConnectionManagerMock;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OrderDaoImplTest {
    ConnectionManager connectionManager = null;
    OrderDao orderDao = null;

    @Test
    void addNewProductToBucketWithIllegalId() {
        assertThrows(IllegalIdException.class, () -> orderDao.addNewProductToBucket(-1, -1));
    }

    @Test
    void addNewProductToBucketWithOk() {
        assertDoesNotThrow(() -> orderDao.addNewProductToBucket(1, 1));
    }

    @Test
    void addNewProductToBucketWithIllegalBuyerId() {
        assertThrows(IllegalIdException.class, () -> orderDao.addNewProductToBucket(-1, 1));
    }

    @Test
    void addNewProductToBucketWithIllegalProductId() {
        assertThrows(IllegalIdException.class, () -> orderDao.addNewProductToBucket(1, -1));
    }

    @Test
    void createNewOrderWithOk() {
        assertDoesNotThrow(() -> orderDao.createNewOrder(2, 2, 3));
    }

    @Test
    void createNewOrderWithIllegalId(){
        Assertions.assertThrows(IllegalIdException.class, () -> orderDao.createNewOrder(-1, 2, 3));
    }

    @Test
    void findById() {
    }

    @Test
    void deleteOrderById() {
    }

    @Test
    void deleteProductFromBucket() {
    }

    @BeforeEach
    void setUp() {
        connectionManager = new ConnectionManagerMock();
        orderDao = new OrderDaoImpl(connectionManager);
    }

    @AfterEach
    void tearDown() {
    }

}