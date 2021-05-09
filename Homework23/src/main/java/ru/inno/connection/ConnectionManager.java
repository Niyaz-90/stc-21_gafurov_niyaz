package ru.inno.connection;

import java.sql.Connection;

public interface ConnectionManager {
    Connection getConnection();
}
