package ru.inno.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.inno.connection.ConnectionManagerImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDaoImpl implements ProductDao {
    private static Logger dbLog = LoggerFactory.getLogger("dbAppender");
    private static Logger systemLog = LoggerFactory.getLogger("systemAppender");
    private static Logger securityLog = LoggerFactory.getLogger("securityAppender");
    private static Logger eventLog = LoggerFactory.getLogger("eventAppender");
    public static final ConnectionManagerImpl connectionManager = ConnectionManagerImpl.getINSTANCE();
    //SQL
    private static final String insertQuery = "INSERT INTO products(product_name, cost) VALUES (?, ?);";
    //SQL
    private static final String updateByIdQuery =
            "UPDATE products SET product_name = ?, cost = ? WHERE product_id = ?;";
    //SQL
    private static final String deleteByIdQuery = "DELETE FROM products WHERE product_id = ?;";

    public ProductDaoImpl() {
    }

    @Override
    public void create(String name, int cost) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(insertQuery)) {
            connection.setAutoCommit(false);
            ps.setString(1, name);
            ps.setInt(2, cost);
            ps.execute();
            connection.commit();
            eventLog.info("create product " + name);
            dbLog.info("create product " + name);
        } catch (SQLException e) {
            securityLog.error("problems with create product");
            dbLog.error("problems with create product");
        }
    }

    @Override
    public void updateById(int productId, String name, int cost) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(updateByIdQuery)) {
            connection.setAutoCommit(false);
            ps.setString(1, name);
            ps.setInt(2, cost);
            ps.setInt(3, productId);
            eventLog.info(ps.executeUpdate() + " records updated.");
            connection.commit();
            eventLog.info("Fields of product " + name + " updated");
            dbLog.info("Fields of product " + name + " updated");
        } catch (SQLException e) {
            systemLog.error("problems with create product");
            dbLog.error("problems with create product");
        }
    }

    @Override
    public void deleteById(int productId) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(deleteByIdQuery)) {
            connection.setAutoCommit(false);
            ps.setInt(1, productId);
            ResultSet rs = ps.executeQuery();
            connection.commit();
            eventLog.info("Product: " + rs.getString(2) + "(id: " + productId + " ) deleted");
            dbLog.info("Product: " + rs.getString(2) + "(id: " + productId + " ) deleted");
        } catch (SQLException e) {
            systemLog.error("Cannot delete product");
            dbLog.error("Cannot delete product");
        }
    }

}
