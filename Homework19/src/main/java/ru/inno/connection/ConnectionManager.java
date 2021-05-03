package ru.inno.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    public static final ConnectionManager INSTANCE = new ConnectionManager();

    private ConnectionManager() {
    }

    public static ConnectionManager getINSTANCE() {
        return INSTANCE;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hwDB",
                    "postgres", "qwerty123");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
