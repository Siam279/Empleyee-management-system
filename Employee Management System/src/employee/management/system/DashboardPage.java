package employee.management.system;

import javax.swing.*;
import java.awt.*;

public class DashboardPage extends JFrame {

    public DashboardPage() {
        setTitle("Dashboard Overview");

        // Set layout
        setLayout(null);
        getContentPane().setBackground(new Color(240, 240, 240));  // Light gray background

        // Heading for Dashboard
        JLabel heading = new JLabel("Dashboard Overview");
        heading.setBounds(250, 20, 400, 40);
        heading.setFont(new Font("Poppins", Font.BOLD, 28));
        heading.setForeground(new Color(0, 123, 255));  // Blue color for heading
        add(heading);

        // Dummy statistics (You can replace with real data from the database)
        JLabel totalEmployees = new JLabel("Total Employees: 50");
        totalEmployees.setBounds(50, 100, 400, 30);
        totalEmployees.setFont(new Font("Arial", Font.PLAIN, 18));
        totalEmployees.setForeground(Color.BLACK);
        add(totalEmployees);

        JLabel totalDepartments = new JLabel("Total Departments: 5");
        totalDepartments.setBounds(50, 140, 400, 30);
        totalDepartments.setFont(new Font("Arial", Font.PLAIN, 18));
        totalDepartments.setForeground(Color.BLACK);
        add(totalDepartments);

        JLabel recentActivities = new JLabel("Recent Activities: 10");
        recentActivities.setBounds(50, 180, 400, 30);
        recentActivities.setFont(new Font("Arial", Font.PLAIN, 18));
        recentActivities.setForeground(Color.BLACK);
        add(recentActivities);

        // Add a back button to go back to the home page
        JButton backButton = new JButton("Back to Home");
        backButton.setBounds(250, 300, 200, 40);
        backButton.setFont(new Font("Arial", Font.PLAIN, 16));
        backButton.setBackground(new Color(0, 123, 255));  // Blue button
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(e -> {
            setVisible(false);
            new Home();  // Go back to the home page
        });
        add(backButton);

        // Set window properties
        setSize(600, 400);
        setLocationRelativeTo(null);  // Center the window on screen
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Exit on close
    }

    public static void main(String[] args) {
        new DashboardPage();
    }
}
