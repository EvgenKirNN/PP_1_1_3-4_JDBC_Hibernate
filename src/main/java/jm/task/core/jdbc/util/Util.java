package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {
    // реализуйте настройку соеденения с БД
    private static Connection connection;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/";
    private static final String DB_NAME = "myDB";
    private static final String DB_USER = "root";
    private static final String DB_PASSW = "root";

    private Util() {

    }
    public static Connection getConnection() {
        try {
            try (Statement statement = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSW).createStatement()) {
                statement.executeUpdate("CREATE DATABASE IF NOT EXISTS " + DB_NAME);
            }
            connection = DriverManager.getConnection(DB_URL + DB_NAME, DB_USER, DB_PASSW);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
