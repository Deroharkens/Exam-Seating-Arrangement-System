// DBConnection.java
// Provides a connection to SQL Server using Windows Authentication

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() {
        try {
            // Ensure integratedSecurity=true and DLL is in the PATH
            String url = "jdbc:sqlserver://localhost:1433;databaseName=ExamSeatingArrangementSystemDB;integratedSecurity=true;";
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.err.println("Database connection failed:");
            e.printStackTrace();
            return null;
        }
    }
}
