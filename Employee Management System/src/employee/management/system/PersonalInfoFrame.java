package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonalInfoFrame extends JFrame {

    public PersonalInfoFrame() {
        setTitle("Personal Information");

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

        // Personal Info Content
        JLabel personalInfoLabel = new JLabel("Personal Information:");
        personalInfoLabel.setFont(new Font("Arial", Font.BOLD, 18));
        personalInfoLabel.setBounds(250, 50, 300, 30);
        add(personalInfoLabel);

        setSize(800, 600);
        setLocation(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new PersonalInfoFrame();
    }
}
