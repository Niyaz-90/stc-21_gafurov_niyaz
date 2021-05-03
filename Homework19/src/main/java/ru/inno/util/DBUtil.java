package ru.inno.util;

import ru.inno.connection.ConnectionManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
    public static void reNewTables() {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hwDB",
                "postgres", "qwerty123");
             Statement statement = connection.createStatement()) {
            statement.execute(
                    // TODO: 01.05.2021
                    "DROP TABLE IF EXISTS orders;\n" +
                            "DROP TABLE IF EXISTS buyers;\n" +
                            "DROP TABLE IF EXISTS products;\n" +
                            "CREATE TABLE products(product_id serial primary key," +
                            " product_name varchar (30) NOT NULL," +
                            "cost INTEGER );\n" +
                            "CREATE TABLE buyers(buyer_id serial primary key ," +
                            "buyer_name varchar(100) NOT NULL" +
                            ");\n" +
                            "CREATE TABLE orders(order_id INTEGER NOT NULL ,\n" +
                            "                    buyer_id Integer references buyers(buyer_id),\n" +
                            "                    address varchar(100), payment_date DATE, product_id INTEGER references products(product_id),\n" +
                            "                     payment_status varchar(10))\n;" +
                            "INSERT INTO buyers(buyer_name) VALUES ('Виктор');" +
                            "INSERT INTO buyers(buyer_name) VALUES ('Даниил');" +
                            "INSERT INTO buyers(buyer_name) VALUES ('Иван');" +
                            "INSERT INTO products(product_name, cost) VALUES ('книга1', 300);" +
                            "INSERT INTO products(product_name, cost) VALUES ('книга2', 290);" +
                            "INSERT INTO products(product_name, cost) VALUES ('сноуборд', 50000);" +
                            "INSERT INTO products(product_name, cost) VALUES ('ручка', 25);" +
                            "INSERT INTO products(product_name, cost) VALUES ('ноутбук', 35000);" +
                            "INSERT INTO products(product_name, cost) VALUES ('книга3', 280);" );
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }// order_
    }//10 24

}
