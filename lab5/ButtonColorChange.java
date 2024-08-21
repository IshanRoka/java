import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonColorChange {

    public static void main(String[] args) {
        // Create a new frame
        JFrame frame = new JFrame("Button Color Change Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout()); // Using FlowLayout as the layout manager

        // Create a button
        JButton button = new JButton("Click me!");

        // Add action listener to the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Generate a random color
                Color newColor = new Color((int)(Math.random() * 0x1000000));
                // Set the button's background color to the new color
                button.setBackground(newColor);
            }
        });

        // Add the button to the frame
        frame.add(button);

        // Make the frame visible
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true);
    }
}
