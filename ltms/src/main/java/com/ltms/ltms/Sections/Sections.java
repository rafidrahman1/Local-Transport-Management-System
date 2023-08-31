package com.ltms.ltms.Sections;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Sections {
    public static void Sections(Scanner scanner, Connection connection) throws SQLException {
        System.out.print("Enter id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter time: ");
        String time = scanner.nextLine();
        int seats = 30;


        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE id= '" + id + "'");

        if (resultSet.next()) {
            System.out.println("ID already exists.");
            statement.close();
            return;
        }


        statement.executeUpdate("INSERT INTO sections (id, name, time, seats) VALUES ('" + id + "','" + name + "','" + time + "', '" + seats + "')");
        System.out.println("Registration successful.");
        statement.close();
    }
}
