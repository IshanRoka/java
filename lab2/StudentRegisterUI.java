import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentRegisterUI {

    private JFrame frame;
    private JTextField firstNameField;
    private JTextField lastNameField;

    public StudentRegisterUI() {
        frame = new JFrame("Student Registration");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Create components
        JLabel firstNameLabel = new JLabel("First Name:");
        JLabel lastNameLabel = new JLabel("Last Name:");
        firstNameField = new JTextField(15);
        lastNameField = new JTextField(15);
        JButton registerButton = new JButton("Register");
        JButton clearButton = new JButton("Clear");

        // Create panels
        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(firstNameLabel);
        panel.add(firstNameField);
        panel.add(lastNameLabel);
        panel.add(lastNameField);
        panel.add(registerButton);
        panel.add(clearButton);

        // Add action listeners
        registerButton.addActionListener(new RegisterAction());
        clearButton.addActionListener(new ClearAction());

        // Add panel to frame
        frame.add(panel);
    }

    private class RegisterAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();

            // Replace with your registration logic
            if (!firstName.isEmpty() && !lastName.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Registration successful for " + firstName + " " + lastName);
            } else {
                JOptionPane.showMessageDialog(frame, "Please fill in both fields", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class ClearAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            firstNameField.setText("");
            lastNameField.setText("");
        }
    }

    public void show() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StudentRegisterUI().show();
            }
        });
    }
}
