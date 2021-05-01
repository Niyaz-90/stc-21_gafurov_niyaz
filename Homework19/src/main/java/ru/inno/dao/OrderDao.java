package ru.inno.dao;

import ru.inno.model.Order;

import java.sql.Date;

public interface OrderDao {
    void create(int buyerId, int productId);
    Order findById(int orderId);
    void updateById(int orderId, String address, Date date, String paymentStatus);
    void deleteOrderById(int orderId);
    void deleteProductFromBucket(int orderId, int productId);
}
