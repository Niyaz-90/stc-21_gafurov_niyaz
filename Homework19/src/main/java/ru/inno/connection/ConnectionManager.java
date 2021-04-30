package ru.inno.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hwDB",
                        "postgres", "qwerty123");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

}
