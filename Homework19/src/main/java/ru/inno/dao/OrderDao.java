package ru.inno.dao;

import java.util.Date;

public interface OrderDao {
    void create(int buyerId, int productId);
    void findById(int orderId);
    void updateById(int orderId, String address, Date date, String paymentStatus);
    void deleteById(int orderId);
}
