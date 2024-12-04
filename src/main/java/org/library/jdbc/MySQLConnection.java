package org.library.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/library_management";
        String username = "username";
        String password = "password";

        Connection connection = null;

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            connection = DriverManager.getConnection(url, username, password);

            // If the connection was successful
            System.out.println("Connection established successfully!");

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Failed to establish connection.");
            e.printStackTrace();
        } finally {
            // Close the connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
