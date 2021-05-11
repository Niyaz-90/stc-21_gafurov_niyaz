package ru.inno.dao;

import ru.inno.exception.IllegalIdException;
import ru.inno.model.Order;

import java.sql.Date;

public interface OrderDao {
    void addNewProductToBucket(int buyerId, int productId) throws IllegalIdException;
    void createNewOrder(int orderId, int buyerId, int productId) throws IllegalIdException;
    Order findById(int orderId);
    void updateById(int orderId, String address, Date date, String paymentStatus);
    void deleteOrderById(int orderId);
    void deleteProductFromBucket(int buyerId, int productId);

}
