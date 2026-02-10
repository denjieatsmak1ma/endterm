package com.atads.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DatabaseConnection {

    private static DatabaseConnection instance;

    private String url;
    private String username;
    private String password;

    private DatabaseConnection() { }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public void configure(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() throws SQLException {
        if (url == null || url.isBlank()) {
            throw new IllegalStateException("DatabaseConnection is not configured. Call configure(...) first.");
        }
        return DriverManager.getConnection(url, username, password);
    }
}
