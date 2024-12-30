package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserProfile extends JFrame {

    UserProfile(String username) {
        // Frame Title
        setTitle("User Profile");

        // Set Layout and Background
        setLayout(null);
        getContentPane().setBackground(new Color(245, 245, 245));  // Light gray background

        // Header Section
        JPanel headerPanel = new JPanel(null);
        headerPanel.setBounds(0, 0, 800, 120);  // Increased header height
        headerPanel.setBackground(new Color(0, 102, 204));  // Dark blue background
        add(headerPanel);

        // Welcome Label
        JLabel welcomeLabel = new JLabel("Welcome, " + username + "!");
        welcomeLabel.setBounds(20, 40, 500, 40);  // Adjusted for larger frame
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));  // Increased font size
        welcomeLabel.setForeground(Color.WHITE);
        headerPanel.add(welcomeLabel);

        // Profile Icon
        JLabel profileIcon = new JLabel(new ImageIcon(ClassLoader.getSystemResource("icons/profile.png")));
        profileIcon.setBounds(600, 20, 100, 100);  // Increased profile icon size
        headerPanel.add(profileIcon);

        // Sidebar Section
        JPanel sidebarPanel = new JPanel(null);
        sidebarPanel.setBounds(0, 120, 200, 380);  // Adjusted sidebar size
        sidebarPanel.setBackground(new Color(230, 230, 230));  // Light gray background
        add(sidebarPanel);

        // Sidebar Buttons
        JButton overviewButton = new JButton("Overview");
        overviewButton.setBounds(10, 10, 180, 50);
        overviewButton.setFont(new Font("Arial", Font.PLAIN, 16));
        sidebarPanel.add(overviewButton);

        JButton personalInfoButton = new JButton("Personal Info");
        personalInfoButton.setBounds(10, 70, 180, 50);
        personalInfoButton.setFont(new Font("Arial", Font.PLAIN, 16));
        sidebarPanel.add(personalInfoButton);

        JButton jobInfoButton = new JButton("Job Info");
        jobInfoButton.setBounds(10, 130, 180, 50);
        jobInfoButton.setFont(new Font("Arial", Font.PLAIN, 16));
        sidebarPanel.add(jobInfoButton);

        JButton settingsButton = new JButton("Settings");
        settingsButton.setBounds(10, 190, 180, 50);
        settingsButton.setFont(new Font("Arial", Font.PLAIN, 16));
        sidebarPanel.add(settingsButton);

        // New Leave Request Button
        JButton leaveRequestButton = new JButton("Leave Request");
        leaveRequestButton.setBounds(10, 250, 180, 50);
        leaveRequestButton.setFont(new Font("Arial", Font.PLAIN, 16));
        sidebarPanel.add(leaveRequestButton);

        // New Logout Button
        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(10, 310, 180, 50);
        logoutButton.setFont(new Font("Arial", Font.PLAIN, 16));
        sidebarPanel.add(logoutButton);

        // Main Content Area
        JPanel contentPanel = new JPanel();
        contentPanel.setBounds(200, 120, 600, 380);  // Adjusted content panel size
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setLayout(new CardLayout());
        add(contentPanel);

        // Add a Default View to Main Content
        JLabel contentLabel = new JLabel("Select an option from the sidebar.");
        contentLabel.setFont(new Font("Arial", Font.ITALIC, 18));  // Increased font size
        contentLabel.setForeground(new Color(100, 100, 100));
        contentPanel.add(contentLabel);

        // Footer Section
        JPanel footerPanel = new JPanel(null);
        footerPanel.setBounds(0, 500, 800, 50);  // Increased footer panel size
        footerPanel.setBackground(new Color(0, 102, 204));  // Dark blue background
        add(footerPanel);

        JLabel footerText = new JLabel("Employee Management System © 2024");
        footerText.setFont(new Font("Arial", Font.PLAIN, 14));  // Adjusted font size
        footerText.setForeground(Color.WHITE);
        footerText.setBounds(250, 15, 300, 20);  // Adjusted position
        footerPanel.add(footerText);

        // Frame Settings
        setSize(800, 600);  // Increased frame size
        setLocation(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        // Button Actions
        overviewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new OverviewFrame();
                dispose(); // Close the current window
            }
        });

        personalInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PersonalInfoFrame();
                dispose(); // Close the current window
            }
        });

        jobInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new JobInfoFrame();
                dispose(); // Close the current window
            }
        });

        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SettingsFrame();
                dispose(); // Close the current window
            }
        });

        // Action for Leave Request Button
        leaveRequestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open Leave Request Frame
                new LeaveRequestFrame(username);  // Pass username to the Leave Request frame
            }
        });

        // Action for Logout Button
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the current frame and return to login screen (or close app)
                dispose();  // Close UserProfile
                new UserLogin();  // Open Login frame
            }
        });
    }

    public static void main(String[] args) {
        new UserProfile("John Doe");
    }
}
