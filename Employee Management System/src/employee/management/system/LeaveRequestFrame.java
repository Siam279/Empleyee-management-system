package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeaveRequestFrame extends JFrame {

    LeaveRequestFrame(String username) {
        setTitle("Leave Request");

        // Set Layout and Background
        setLayout(null);
        getContentPane().setBackground(new Color(245, 245, 245));  // Light gray background

        // Header Section
        JPanel headerPanel = new JPanel(null);
        headerPanel.setBounds(0, 0, 800, 120);
        headerPanel.setBackground(new Color(0, 102, 204));  // Dark blue background
        add(headerPanel);

        // Title
        JLabel titleLabel = new JLabel("Leave Request");
        titleLabel.setBounds(20, 40, 300, 40);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        headerPanel.add(titleLabel);

        // Leave Details Form
        JLabel startDateLabel = new JLabel("Start Date:");
        startDateLabel.setBounds(20, 150, 200, 30);
        startDateLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        add(startDateLabel);

        JTextField startDateField = new JTextField();
        startDateField.setBounds(220, 150, 200, 30);
        add(startDateField);

        JLabel endDateLabel = new JLabel("End Date:");
        endDateLabel.setBounds(20, 200, 200, 30);
        endDateLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        add(endDateLabel);

        JTextField endDateField = new JTextField();
        endDateField.setBounds(220, 200, 200, 30);
        add(endDateField);

        JLabel reasonLabel = new JLabel("Reason:");
        reasonLabel.setBounds(20, 250, 200, 30);
        reasonLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        add(reasonLabel);

        JTextArea reasonArea = new JTextArea();
        reasonArea.setBounds(220, 250, 400, 100);
        reasonArea.setFont(new Font("Arial", Font.PLAIN, 16));
        reasonArea.setLineWrap(true);
        reasonArea.setWrapStyleWord(true);
        add(reasonArea);

        // Submit Button
        JButton submitButton = new JButton("Submit Request");
        submitButton.setBounds(220, 380, 200, 40);
        submitButton.setFont(new Font("Arial", Font.PLAIN, 16));
        add(submitButton);

        // Cancel Button
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(440, 380, 200, 40);
        cancelButton.setFont(new Font("Arial", Font.PLAIN, 16));
        add(cancelButton);

        // Footer Section
        JPanel footerPanel = new JPanel(null);
        footerPanel.setBounds(0, 500, 800, 50);
        footerPanel.setBackground(new Color(0, 102, 204));
        add(footerPanel);

        JLabel footerText = new JLabel("Employee Management System © 2024");
        footerText.setFont(new Font("Arial", Font.PLAIN, 14));
        footerText.setForeground(Color.WHITE);
        footerText.setBounds(250, 15, 300, 20);
        footerPanel.add(footerText);

        // Frame Settings
        setSize(800, 600);
        setLocation(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        // Button Actions
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle submission (e.g., save leave request to database, show confirmation)
                String startDate = startDateField.getText();
                String endDate = endDateField.getText();
                String reason = reasonArea.getText();

                if (startDate.isEmpty() || endDate.isEmpty() || reason.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill out all fields.");
                } else {
                    // Simulate submitting leave request (you can add actual logic here)
                    JOptionPane.showMessageDialog(null, "Leave Request Submitted.\nStart Date: " + startDate + "\nEnd Date: " + endDate + "\nReason: " + reason);
                    dispose(); // Close the leave request frame after submission
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();  // Close the Leave Request frame
            }
        });
    }

    public static void main(String[] args) {
        new LeaveRequestFrame("John Doe");
    }
}
