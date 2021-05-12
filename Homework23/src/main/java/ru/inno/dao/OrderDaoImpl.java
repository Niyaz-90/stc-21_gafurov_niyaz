package ru.inno.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.inno.connection.ConnectionManager;
import ru.inno.connection.ConnectionManagerImpl;
import ru.inno.exception.IllegalIdException;
import ru.inno.model.Order;

import java.sql.*;

public class OrderDaoImpl implements OrderDao {
    private static Logger dbLog = LoggerFactory.getLogger("dbAppender");
    private static Logger systemLog = LoggerFactory.getLogger("systemAppender");
    private static Logger securityLog = LoggerFactory.getLogger("securityAppender");
    private static Logger eventLog = LoggerFactory.getLogger("eventAppender");
    private ConnectionManager connectionManager;
    //SQL
    private static final String insertQuery = "INSERT INTO orders(order_id, buyer_id, product_id) VALUES(?, ?, ?)";
    //SQL
    public static final String checkBuyerOrdersQuery = "SELECT * FROM orders WHERE buyer_id = ?";
    //SQL
    private static final String selectQuery = "SELECT * FROM orders WHERE order_id = ?";
    //SQL
    private static final String updateQuery = "UPDATE orders SET address = ?," +
            " payment_date = ?, payment_status = ? WHERE order_id = ?";
    //SQL
    private static final String deleteOrderQuery = "DELETE FROM orders WHERE order_id = ?";
    //SQL
    private static final String deleteProductFromBucketQuery =
            "DELETE FROM orders WHERE buyer_id = ? AND product_id = ? ";

    public OrderDaoImpl(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    public OrderDaoImpl() {
        this.connectionManager = ConnectionManagerImpl.getINSTANCE();
    }

    @Override
    public void addNewProductToBucket(int buyerId, int productId) throws IllegalIdException {
        int orderIdOfBuyer = 0;
        if(buyerId > 0 & productId > 0) {
            try (Connection connection = connectionManager.getConnection();
                 PreparedStatement ps = connection.prepareStatement(checkBuyerOrdersQuery)) {
                connection.setAutoCommit(false);
                ps.setInt(1, buyerId);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    orderIdOfBuyer = rs.getInt(1);
                }
                connection.commit();
                eventLog.info("Buyer " + buyerId + " add product " + productId);
                dbLog.info("Buyer " + buyerId + " add product " + productId);
            } catch (SQLException e) {
                eventLog.warn("Cannot add product (id):" + productId + " in buyer's (id:" + buyerId + " bucket.");
                dbLog.warn("Cannot add product (id):" + productId + " in buyer's (id:" + buyerId + " bucket.");
            }
            createNewOrder(orderIdOfBuyer, buyerId, productId);
        } else {
            throw new IllegalIdException();
        }
    }

    @Override
    public void createNewOrder(int orderId, int buyerId, int productId) throws IllegalIdException {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(insertQuery)) {
            ps.setInt(1, orderId);
            ps.setInt(2, buyerId);
            ps.setInt(3, productId);
            if(orderId > 0){
                ps.execute();
            } else {
                throw new IllegalIdException();
            }
            eventLog.info(" order " + orderId + " created");
            dbLog.info(" order " + orderId + " created");
        } catch (SQLException e) {
            eventLog.warn("Cannot create order: " + orderId);
            securityLog.warn("Cannot add order");
            dbLog.warn("Cannot create order: " + orderId);
        }
    }

    @Override
    public Order findById(int orderId) {
        Order order = null;
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(selectQuery)) {
            connection.setAutoCommit(false);
            ps.setInt(1, orderId);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                order = new Order(resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getString(3),
                        resultSet.getDate(4),
                        resultSet.getInt(5),
                        resultSet.getString(6));
            }
            connection.commit();
        } catch (SQLException e) {
            eventLog.info("Cannot find order:" + orderId);
            dbLog.info("Cannot find order:" + orderId);
        }
        return order;
    }

    @Override
    public void updateById(int orderId, String address, Date paymentDate, String paymentStatus) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(updateQuery)) {
            connection.setAutoCommit(false);
            ps.setString(1, address);
            ps.setDate(2, paymentDate);
            ps.setString(3, paymentStatus);
            ps.setInt(4, orderId);
            int modifiedRows = ps.executeUpdate();
            connection.commit();
            eventLog.info("Order:" + orderId + " . " + modifiedRows + " rows are updated");
            dbLog.info("Order:" + orderId + " . " + modifiedRows + " rows are updated");
        } catch (SQLException e) {
            eventLog.warn("Order:" + orderId + "don't update");
            securityLog.error("Attempt to change fields");
            dbLog.warn("Order:" + orderId + "don't update");
        }
    }

    @Override
    public void deleteOrderById(int orderId) throws IllegalIdException {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(deleteOrderQuery)) {
            connection.setAutoCommit(false);
            ps.setInt(1, orderId);
            int deletedRows = ps.executeUpdate();
            if (deletedRows == 0){
                throw new IllegalIdException();
            }
            connection.commit();
            eventLog.info("Order " + orderId + "is deleted. " + deletedRows);
            dbLog.info("Order " + orderId + "is deleted. " + deletedRows);
        } catch (SQLException e) {
            systemLog.error("Problems with delete order");
            dbLog.error("Problems with delete order");
        }
    }

    @Override
    public void deleteProductFromBucket(int buyerId, int productId) throws IllegalIdException {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(deleteProductFromBucketQuery)) {
            connection.setAutoCommit(false);
            ps.setInt(1, buyerId);
            ps.setInt(2, productId);
            ps.executeUpdate();
            if(buyerId <= 0 | productId <= 0){
                throw new IllegalIdException();
            }
            connection.commit();
            eventLog.info("Product " + productId + " deleted from bucket. " + ps.executeUpdate());
            dbLog.info("Product " + productId + " deleted from bucket. " + ps.executeUpdate());
        } catch (SQLException e) {
            systemLog.error("Cannot delete product from bucket");
            dbLog.error("Cannot delete product from bucket");
        }
    }

}
