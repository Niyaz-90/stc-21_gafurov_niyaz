package ru.inno.util;

import ru.inno.connection.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
    public static void reNewTables() {
        try (Connection connection = ConnectionManager.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(
                    // TODO: 01.05.2021
                    "DROP TABLE IF EXISTS product;\n" +
                            "DROP TABLE IF EXISTS orders;\n" +
                            "DROP TABLE IF EXISTS employee;\n" +
                            "DROP TABLE IF EXISTS buyer;\n" +
                            "DROP TABLE IF EXISTS product;\n" +
                            "CREATE TABLE product(product_id serial primary key," +
                            " product_name varchar (30) NOT NULL," +
                            "cost INTEGER );\n" +
                            "CREATE TABLE buyer(buyer_id serial primary key ," +
                            "buyer_name varchar(100) NOT NULL" +
                            ");\n" +
                            "CREATE TABLE orders(order_id serial primary key,\n" +
                            "                    buyer_id Integer references buyer(buyer_id),\n" +
                            "                    address varchar(100), payment_date DATE, product_id INTEGER references product(product_id),\n" +
                            "                     payment_status varchar(10))\n;\n"); //prod id -
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }// order_
    }//10 24

}
