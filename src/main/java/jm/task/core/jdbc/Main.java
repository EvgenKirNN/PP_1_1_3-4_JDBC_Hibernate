package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        Util.getConnection();

        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Ivan", "Ivanov", (byte) 35);
        userService.saveUser("Petr", "Petrov", (byte) 25);
        userService.saveUser("Stepan", "Stepanov", (byte) 53);
        userService.saveUser("Nikolay", "Nikolaev", (byte) 20);

        userService.getAllUsers();

        userService.cleanUsersTable();

        userService.dropUsersTable();

        try {
            Util.getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}