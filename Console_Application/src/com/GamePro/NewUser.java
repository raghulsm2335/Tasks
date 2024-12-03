package com.GamePro;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;
/*
Author: Raghul_S_M
Developed on: 28-11-24
Modified on:01-12-2024
Reviewed by:
Reviewed on:
*/
public class NewUser {

    private static String DB_URL;
    private static String DB_USER;
    private static String DB_PASSWORD;
   
    public static void registerNewUser() {  //register a new user
    	
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter New Name");
        String username = scanner.nextLine();
        System.out.println("Enter New Password");
        String password = scanner.nextLine();
        loadDatabaseProperties(); // Assign values from property file to private variables
        saveUserToDatabase(username, password); // Save the user to MySQL
        scanner.close();
    }

    private static void loadDatabaseProperties() //load config.properties file and assign values
    {
        Properties properties = new Properties();
        try (FileInputStream inputStream = new FileInputStream("config.properties")) {        
            properties.load(inputStream);  // Load the properties file
            DB_URL = properties.getProperty("db.url");
            DB_USER = properties.getProperty("db.username");
            DB_PASSWORD = properties.getProperty("db.password");

        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }


   
    private static void saveUserToDatabase(String username, String password) { //save user to database
        
        String sql = "INSERT INTO users (userName, userPassword) VALUES (?, ?)";// SQL query to insert new user

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            // Set the username and password values in the query
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            // Execute the insert query
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("User registered successfully in the database.");
                RentalApplication.getStart();
            } else {
                System.out.println("Failed to register user.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
