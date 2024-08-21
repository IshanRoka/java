import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeInsertion {
    public static void main(String[] args) {
     
        String url = "jdbc:mysql://localhost:3306/employee_db";
        String username = "root"; 
        String password = ""; 
        String name = "Ishan Roka";
        String email = "ishanroka@gmail.com";
        String address = "Kathmandu, Nepal";
        String sql = "INSERT INTO employees (name, email, address) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, address);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Employee information inserted successfully.");
            } else {
                System.out.println("Failed to insert employee information.");
            }

        } catch (SQLException e) {
            System.out.println("Database connection or SQL error: " + e.getMessage());
        }
    }
}
