package com.ltms.ltms.Authentication;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentRegistration {
    public static void studentRegistration(Scanner scanner, Connection connection) throws SQLException {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE email = '" + email + "'");

        if (resultSet.next()) {
            System.out.println("Email already exists.");
            statement.close();
            return;
        }

        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        statement.executeUpdate("INSERT INTO users (name, id, email, password) VALUES ('" + name + "','" + id + "','" + email + "', '" + password + "')");
        System.out.println("Registration successful.");
        statement.close();
    }
}
