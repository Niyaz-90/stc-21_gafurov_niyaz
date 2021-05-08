package ru.inno.connection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    public static final ConnectionManager INSTANCE = new ConnectionManager();
    private static Logger systemLog = LoggerFactory.getLogger("systemAppender");
    private static Logger dbLog = LoggerFactory.getLogger("dbAppender");

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
            systemLog.error(e.getMessage());
            dbLog.error(e.getMessage());
        }
        return connection;
    }

}
