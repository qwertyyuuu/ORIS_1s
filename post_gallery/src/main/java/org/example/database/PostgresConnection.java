package org.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnection {
    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception ignored) {}

        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/library",
                    "postgres",
                    "outlaw");
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
