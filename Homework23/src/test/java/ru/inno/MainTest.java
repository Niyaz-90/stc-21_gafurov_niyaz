package ru.inno;

import org.junit.jupiter.api.*;
import ru.inno.connection.ConnectionManager;
import ru.inno.dao.OrderDao;
import ru.inno.dao.OrderDaoImpl;
import ru.inno.mock.ConnectionManagerMock;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private Main main;
    private OrderDao orderDao;
    private ConnectionManager connectionManager;

    @BeforeEach
    void setUp() {
        main = new Main();
        connectionManager = new ConnectionManagerMock();
    }

    @AfterEach
    void tearDown() {
    }

    @BeforeAll
    static void setUpAll(){

    }
    @AfterAll
    static void tearDownAll(){

    }

    @Test
    void testMethodWithNPE() {
        assertThrows(NullPointerException.class, () -> main.testMethod(null));
    }
    @Test
    void testMethodWithOk(){
        orderDao = new OrderDaoImpl(connectionManager);
        assertDoesNotThrow(() -> main.testMethod(orderDao));
    }

}