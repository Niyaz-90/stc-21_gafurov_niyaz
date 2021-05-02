package ru.inno.dao;

import ru.inno.connection.ConnectionManager;
import ru.inno.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDaoImpl implements ProductDao {
    //SQL
    private static final String insertQuery = "INSERT INTO products(product_name, cost) VALUES (?, ?);";
    //SQL
    private static final String updateByIdQuery =
            "UPDATE products(product_name, cost) SET (?, ?) WHERE product_id = ?;";
    //SQL
    private static final String deleteByIdQuery = "DELETE FROM products WHERE product_id = ?;";

    @Override
    public void create(String name, int cost) {
        try(Connection connection = ConnectionManager.getConnection();
            PreparedStatement ps = connection.prepareStatement(insertQuery)){
            connection.setAutoCommit(false);
            ps.setString(1, name);
            ps.setInt(2, cost);
            ps.execute();
            connection.commit();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateById(int productId, String name, int cost) {
        try(Connection connection = ConnectionManager.getConnection();
        PreparedStatement ps = connection.prepareStatement(updateByIdQuery)){
            connection.setAutoCommit(false);
            ps.setString(1, name);
            ps.setInt(2, cost);
            ps.setInt(3, productId);
            System.out.println(ps.executeUpdate() + " records updated.");
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(int productId) {
        try(Connection connection = ConnectionManager.getConnection();
        PreparedStatement ps = connection.prepareStatement(deleteByIdQuery)){
            connection.setAutoCommit(false);
            ps.setInt(1, productId);
            ResultSet rs = ps.executeQuery();
            System.out.println("Product: " + rs.getString(2) + "(id: " + productId + " ) deleted");
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
