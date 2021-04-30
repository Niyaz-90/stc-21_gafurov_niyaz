package ru.inno.dao;

import java.util.Date;

public interface OrderDao {
    void create(int buyerId, int productId, int employeeId);
    void findById(int orderId);
    void updateById(int orderid);
    void deleteById(int orderId);
}
