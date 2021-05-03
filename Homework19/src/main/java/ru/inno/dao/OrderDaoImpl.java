package ru.inno.dao;

import ru.inno.connection.ConnectionManager;
import ru.inno.model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class OrderDaoImpl implements OrderDao {

    private static final ConnectionManager connectionManager = ConnectionManager.getINSTANCE();
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
            "DELETE FROM orders WHERE product_id = ? AND order_id = ?";

    public OrderDaoImpl() {
    }

    @Override
    public void addNewProductToBucket(int buyerId, int productId){
        int orderIdOfBuyer = 0;
        try(Connection connection = connectionManager.getConnection();
        PreparedStatement ps = connection.prepareStatement(checkBuyerOrdersQuery)){
            connection.setAutoCommit(false);
            ps.setInt(1, buyerId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                orderIdOfBuyer = rs.getInt(1);
            }
            connection.commit();
        } catch (SQLException e){
            e.printStackTrace();
        }
        create(orderIdOfBuyer, buyerId,productId);
    }

    @Override
    public void create(int orderId, int buyerId, int productId) { //createNewOrder(...)
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(insertQuery)) {
            connection.setAutoCommit(false);
            ps.setInt(1, orderId);
            ps.setInt(2, buyerId);
            ps.setInt(3, productId);
            ps.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
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
                System.out.println(order.toString());
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
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
            System.out.println(modifiedRows + " rows are updated");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrderById(int orderId) {
        try(Connection connection = connectionManager.getConnection();
        PreparedStatement ps = connection.prepareStatement(deleteOrderQuery)){
            connection.setAutoCommit(false);
            ps.setInt(1, orderId);
            int deletedRows = ps.executeUpdate();
            connection.commit();
            System.out.println("Order " + orderId + "is deleted. " + deletedRows);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProductFromBucket(int orderId, int productId){
        try(Connection connection = connectionManager.getConnection();
        PreparedStatement ps = connection.prepareStatement(deleteProductFromBucketQuery)) {
            connection.setAutoCommit(false);
            ps.setInt(1, productId);
            ps.setInt(2, orderId);
            System.out.println("Product " + productId + " deleted from bucket. " + ps.executeUpdate());
            connection.commit();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

}
