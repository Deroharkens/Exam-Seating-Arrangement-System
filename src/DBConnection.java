// DBConnection.java
// Provides a connection to SQL Server using Windows Authentication

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() {
        try {
            // Load the SQL Server JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Ensure integratedSecurity=true and DLL is in the PATH
            String url = "jdbc:sqlserver://localhost:1433;databaseName=ExamSeatingArrangementSystemDB;integratedSecurity=true;";
            return DriverManager.getConnection(url);
        } catch (ClassNotFoundException e) {
            System.err.println("SQL Server JDBC Driver not found.");
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            System.err.println("Database connection failed:");
            e.printStackTrace();
            return null;
        }
    }
}
