package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JobInfoFrame extends JFrame {

    public JobInfoFrame() {
        setTitle("Job Information");

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

        // Job Info Content
        JLabel jobInfoLabel = new JLabel("Job Information:");
        jobInfoLabel.setFont(new Font("Arial", Font.BOLD, 18));
        jobInfoLabel.setBounds(250, 50, 300, 30);
        add(jobInfoLabel);

        setSize(800, 600);
        setLocation(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new JobInfoFrame();
    }
}
