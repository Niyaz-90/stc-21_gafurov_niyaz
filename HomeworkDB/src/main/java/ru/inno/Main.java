package ru.inno;

import ru.inno.dao.OrderDao;
import ru.inno.dao.OrderDaoImpl;
import ru.inno.dao.ProductDao;
import ru.inno.dao.ProductDaoImpl;
import ru.inno.model.Order;
import ru.inno.util.DBUtil;

import java.sql.Date;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            DBUtil.reNewTables();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        OrderDao orderDao = new OrderDaoImpl();
        ProductDao productDao = new ProductDaoImpl();
        productDao.create("блокнот", 50);
        orderDao.create(Order.addNewOrder(), 1, 3);
        orderDao.create(Order.addNewOrder(), 3, 5);
        orderDao.create(Order.addNewOrder(), 2, 6);
        orderDao.addNewProductToBucket(3, 3);
        orderDao.addNewProductToBucket(3, 2);
        orderDao.addNewProductToBucket(3, 6);
        orderDao.deleteProductFromBucket(3, 5);
        System.out.println(orderDao.findById(1).toString());
//        orderDao.deleteOrderById(2);
        orderDao.updateById(2, "Bauman str, 56", Date.valueOf("2021-05-03"), "Unpaid");
        orderDao.updateById(3, "Tukai str, 98", Date.valueOf("2021-05-02"), "Paid");
        orderDao.updateById(1, "Nekrasov str, 23", Date.valueOf("2021-05-01"), "Paid");
        orderDao.findById(1);
        orderDao.findById(2);
        orderDao.findById(3);

    }

}
