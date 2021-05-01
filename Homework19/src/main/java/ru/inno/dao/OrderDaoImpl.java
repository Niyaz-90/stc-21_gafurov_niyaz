package ru.inno.dao;

import ru.inno.connection.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class OrderDaoImpl implements OrderDao {

    //SQL
    private static final String insertQuery = "INSERT INTO orders(buyer_id, product_id) VALUES(?, ?)";
    //SQL
    private static final String selectQuery = "SELECT * FROM orders WHERE order_id = ?";
    @Override
    public void create(int buyerId, int productId) {
        try(Connection connection = ConnectionManager.getConnection();
            PreparedStatement ps = connection.prepareStatement(insertQuery)){
            connection.setAutoCommit(false);
            ps.setInt(1, buyerId);
            ps.setInt(2,productId);
            ps.execute();
            connection.commit();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void findById(int orderId) {
        try(Connection connection = ConnectionManager.getConnection();
        PreparedStatement ps = connection.prepareStatement(selectQuery)){
            connection.setAutoCommit(false);
            ps.setInt(1, orderId);
            ps.executeQuery();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateById(int orderId, String address, Date date, String paymentStatus) {

    }

    @Override
    public void deleteById(int orderId) {

    }

}
