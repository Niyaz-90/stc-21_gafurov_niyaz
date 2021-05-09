package ru.inno.mock;

import ru.inno.connection.ConnectionManager;

import java.sql.Connection;

public class ConnectionManagerMock implements ConnectionManager {
    @Override
    public Connection getConnection() {
        return new ConnectionMock();
    }

}
