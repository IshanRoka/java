import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class EmployeeTable {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/your_database_name";

    // Database credentials
    static final String USER = "your_username";
    static final String PASS = "your_password";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Employee Information");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);

            // Table model
            DefaultTableModel model = new DefaultTableModel();
            JTable table = new JTable(model);
            model.addColumn("Name");
            model.addColumn("Email");
            model.addColumn("Address");

            // Fetch and display data
            try {
                // Load JDBC driver
                Class.forName(JDBC_DRIVER);

                // Establish connection
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

                // Execute SQL query
                String sql = "SELECT name, email, address FROM employees";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                // Process result set and populate table model
                while (rs.next()) {
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    String address = rs.getString("address");
                    model.addRow(new Object[]{name, email, address});
                }

                // Clean-up environment
                rs.close();
                stmt.close();
                conn.close();

            } catch (SQLException | ClassNotFoundException se) {
                se.printStackTrace();
            }

            // Add table to scroll pane and set it to frame
            JScrollPane scrollPane = new JScrollPane(table);
            frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
            frame.setVisible(true);
        });
    }
}
