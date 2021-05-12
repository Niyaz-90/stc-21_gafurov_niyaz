package ru.inno.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.inno.connection.ConnectionManagerImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class DBUtil {
    private static Logger dbLog = LoggerFactory.getLogger("dbAppender");
    public static final ConnectionManagerImpl connectionManager = ConnectionManagerImpl.getINSTANCE();
    private static Logger systemLog = LoggerFactory.getLogger("systemAppender");
    private static Logger securityLog = LoggerFactory.getLogger("securityAppender");
    private static Logger eventLog = LoggerFactory.getLogger("eventAppender");

    public static void reNewTables() throws SQLException {
        Connection connection = connectionManager.getConnection();
        Savepoint sp4 = null;
        try (Statement statement = connection.createStatement()) {
            connection.setAutoCommit(false);
            Savepoint sp1 = connection.setSavepoint();
            statement.execute("DROP TABLE IF EXISTS orders;\n" +
                    "DROP TABLE IF EXISTS buyers;\n" +
                    "DROP TABLE IF EXISTS products;\n" +
                    "DROP TABLE IF EXISTS logs_table;\n" +
                    "CREATE TABLE products(product_id serial primary key," +
                    " product_name varchar (30) NOT NULL," +
                    "cost INTEGER );\n" +
                    "CREATE TABLE buyers(buyer_id serial primary key ," +
                    "buyer_name varchar(100) NOT NULL);\n" +
                    "CREATE TABLE orders(order_id INTEGER NOT NULL , " +
                    "buyer_id Integer references buyers(buyer_id), " +
                    "address varchar(100), payment_date DATE, " +
                    "product_id INTEGER references products(product_id), " +
                    "payment_status varchar(10));\n" +
                    "CREATE TABLE logs_table(log_date varchar (20), " +
                    "log_issue varchar(200));");
            connection.commit();
            Savepoint sp2 = connection.setSavepoint();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO buyers(buyer_name) VALUES (?)");
            for (int i = 0; i < 5; i++) {
                ps.setString(1, "User_" + i);
                ps.addBatch();
            }
            ps.executeBatch();
            Savepoint sp3 = connection.setSavepoint();
            statement.execute("INSERT INTO products(product_name, cost) VALUES ('книга1', 300);" +
                    "INSERT INTO products(product_name, cost) VALUES ('книга2', 290);" +
                    "INSERT INTO products(product_name, cost) VALUES ('сноуборд', 50000);" +
                    "INSERT INTO products(product_name, cost) VALUES ('ручка', 25);" +
                    "INSERT INTO products(product_name, cost) VALUES ('ноутбук', 35000);" +
                    "INSERT INTO products(product_name, cost) VALUES ('книга3', 280);");
            sp4 = connection.setSavepoint();
            statement.execute("INSERT INTO products(product_name, cost) VALUES ('огурец', 25);" +
                    "INSERT INTO products(product_name, cost) VALUES ('помидор', 35);" +
                    "INSERT INTO products(product_name, cost) VALUES ('тыква', 28);");
            connection.commit();
            eventLog.info("Tables created");
            dbLog.info("Tables created");
        } catch (SQLException throwables) {
            connection.rollback(sp4);
            systemLog.error("Tables don't refreshed");
            dbLog.error("Tables don't refreshed");
        }
    }

}
