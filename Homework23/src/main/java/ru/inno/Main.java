package ru.inno;

import ru.inno.dao.OrderDao;
import ru.inno.dao.OrderDaoImpl;
import ru.inno.dao.ProductDao;
import ru.inno.dao.ProductDaoImpl;
import ru.inno.exception.IllegalIdException;
import ru.inno.model.Order;
import ru.inno.util.DBUtil;

import java.sql.Date;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            DBUtil.reNewTables();
            Main main = new Main();
            OrderDao orderDao = new OrderDaoImpl();
            main.testMethod(orderDao);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalIdException e) {
            e.printStackTrace();
        }
    }

    public void testMethod(OrderDao orderDao) throws IllegalIdException {

        ProductDao productDao = new ProductDaoImpl();
        productDao.create("блокнот", 50);
        orderDao.createNewOrder(Order.addNewOrder(), 2, 3);
        orderDao.createNewOrder(Order.addNewOrder(), 3, 5);
        orderDao.createNewOrder(Order.addNewOrder(), 2, 6);
        orderDao.addNewProductToBucket(3, 3);
        orderDao.addNewProductToBucket(3, 2);
        orderDao.addNewProductToBucket(3, 6);
        orderDao.deleteProductFromBucket(3, 6);
        System.out.println("-----------");
        System.out.println(orderDao.findById(3).toString());
        orderDao.updateById(2, "Bauman str, 56", Date.valueOf("2021-05-03"), "Unpaid");
        orderDao.updateById(3, "Tukai str, 98", Date.valueOf("2021-05-02"), "Paid");
        orderDao.updateById(1, "Nekrasov str, 23", Date.valueOf("2021-05-01"), "Paid");
        System.out.println(orderDao.findById(188).toString());
        System.out.println(orderDao.findById(2).toString());
        System.out.println(orderDao.findById(3).toString());
    }

}
