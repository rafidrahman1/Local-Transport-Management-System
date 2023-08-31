package com.ltms.ltms;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

import static com.ltms.ltms.Authentication.StudentRegistration.*;
import static com.ltms.ltms.Authentication.UserLogin.*;

@SpringBootApplication
public class LtmsApplication {

	public static void main(String[] args) {
        SpringApplication.run(LtmsApplication.class, args);
//		Scanner sc = new Scanner(System.in);
//		try {
//			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ltms_db", "root", "root");
//			Statement statement = connection.createStatement();
//			Scanner scanner = new Scanner(System.in);
//			boolean running = true;
//
//			while (running) {
//				System.out.println("1. Register");
//				System.out.println("2. User Login");
//				System.out.println("3. Admin Login");
//				System.out.println("4. Exit");
//				System.out.print("Choose an option: ");
//				int choice = scanner.nextInt();
//				scanner.nextLine(); // Consume newline character
//				switch (choice) {
//					case 1 -> studentRegistration(scanner, connection);
//					case 2 -> userLogin(scanner, connection);
//					case 3 -> teacherLogin(scanner, connection);
//					case 4 -> {
//						running = false;
//						System.out.println("Exiting...");
//					}
//					default -> System.out.println("Invalid choice. Please choose again.");
//				}
//			}
//			statement.close();
//			connection.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}


	}
}
