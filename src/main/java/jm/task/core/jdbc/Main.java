package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Ivan", "Ivanov", (byte) 35);
        userService.saveUser("Petr", "Petrov", (byte) 25);
        userService.saveUser("Stepan", "Stepanov", (byte) 53);
        userService.saveUser("Nikolay", "Nikolaev", (byte) 20);

        userService.getAllUsers();

        userService.cleanUsersTable();

        userService.dropUsersTable();
    }
}