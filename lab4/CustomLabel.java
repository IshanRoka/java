import javax.swing.*;
import java.awt.*;

public class CustomLabel {

    public static void main(String[] args) {
        // Create a new frame
        JFrame frame = new JFrame("Custom Label Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new BorderLayout()); // Using BorderLayout as the layout manager

        // Create a label with text
        JLabel label = new JLabel("This is a custom label");
        
        // Set font to italics and size to 24
        Font font = new Font("Serif", Font.ITALIC, 24);
        label.setFont(font);
        
        // Set the color of the label
        label.setForeground(Color.BLUE);
        
        // Add the label to the frame
        frame.add(label, BorderLayout.CENTER);
        
        // Make the frame visible
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true);
    }
}
