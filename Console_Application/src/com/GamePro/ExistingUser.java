package com.GamePro;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class ExistingUser {

    private static String DB_URL;
    private static String DB_USER;
    private static String DB_PASSWORD;

    public static boolean ValidateExistingUser() {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Name");
        String username = scanner.nextLine();
        System.out.println("Enter Password");
        String password = scanner.nextLine();

        // Load database properties
        loadDatabaseProperties();

        // Validate the username and password from the database
        boolean isValidUser = validateUserFromDatabase(username, password);

        if (isValidUser) {
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Invalid username or password.");
            return false;
        }
    }

    private static boolean validateUserFromDatabase(String username, String password) {
        String sql = "SELECT userPassword FROM users WHERE userName = ?";
        
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            // Set the username parameter
            preparedStatement.setString(1, username);

            // Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            // If username is found, verify the password
            if (resultSet.next()) {
                String storedPassword = resultSet.getString("userPassword");
                // Check if the provided password matches the stored password
                if (storedPassword.equals(password)) {
                    return true; // Password matches
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false; // Username not found or password doesn't match
    }

    private static void loadDatabaseProperties() {
        Properties properties = new Properties();
        try (FileInputStream inputStream = new FileInputStream("config.properties")) {
            properties.load(inputStream);  // Load the properties file
            DB_URL = properties.getProperty("db.url");
            DB_USER = properties.getProperty("db.username");
            DB_PASSWORD = properties.getProperty("db.password");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
