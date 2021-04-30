package ru.inno.dao;

import ru.inno.connection.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BuyerDaoImpl implements BuyerDao {
    @Override
    public void create(String buyerName) {
        try (Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT  INTO buyer(buyer_name) VALUES (" + buyerName + ")");
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void findById(int buyerId) {
        try(Connection connection = ConnectionManager.getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM buyers WHERE buyer_id = " + buyerId +")");
            statement.execute();
        }
    }

    @Override
    public void updateById(int buyerId) {

    }

    @Override
    public void deleteById(int buyerId) {

    }

}
