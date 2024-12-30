package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsFrame extends JFrame {

    public SettingsFrame() {
        setTitle("Settings");

        setLayout(null);
        getContentPane().setBackground(new Color(245, 245, 245));

        // Back Button
        JButton backButton = new JButton("Back");
        backButton.setBounds(10, 10, 100, 40);
        backButton.setFont(new Font("Arial", Font.PLAIN, 16));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UserProfile("John Doe");
                dispose(); // Close the current window
            }
        });
        add(backButton);

        // Settings Content
        JLabel settingsLabel = new JLabel("Settings for the Employee Profile");
        settingsLabel.setFont(new Font("Arial", Font.BOLD, 18));
        settingsLabel.setBounds(250, 50, 300, 30);
        add(settingsLabel);

        setSize(800, 600);
        setLocation(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SettingsFrame();
    }
}
