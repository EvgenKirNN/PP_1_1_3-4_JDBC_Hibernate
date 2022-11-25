package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.sql.*;

public class Util {
    //настройка соеденения с БД
    private static Connection connection;
    private static SessionFactory sessionFactory;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/";
    private static final String DB_NAME = "myDB";
    private static final String DB_USER = "root";
    private static final String DB_PASSW = "root";

    static {
        sessionFactory = new Configuration()
                .setProperty(Environment.URL, DB_URL + DB_NAME)
                .setProperty(Environment.USER, DB_USER)
                .setProperty(Environment.PASS, DB_PASSW)
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
    }

    private Util() {

    }
    public static Connection getConnection() {
        if (connection == null) {
            try {
                try (Statement statement = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSW).createStatement()) {
                    statement.executeUpdate("CREATE DATABASE IF NOT EXISTS " + DB_NAME);
                }
                connection = DriverManager.getConnection(DB_URL + DB_NAME, DB_USER, DB_PASSW);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
