package employee.management.system;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class OverviewFrame extends JFrame {
    
    OverviewFrame() {
        setTitle("Overview");
        setLayout(null);
        getContentPane().setBackground(new Color(245, 245, 245));  // Light gray background

        // Header Section
        JPanel headerPanel = new JPanel();
        headerPanel.setBounds(0, 0, 800, 100);
        headerPanel.setBackground(new Color(0, 102, 204));  // Dark blue background
        add(headerPanel);
        
        JLabel headerLabel = new JLabel("User Overview");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerLabel.setForeground(Color.WHITE);
        headerPanel.add(headerLabel);

        // User Overview Section - Card Layout
        JPanel overviewPanel = new JPanel();
        overviewPanel.setBounds(20, 120, 760, 400);
        overviewPanel.setLayout(new GridLayout(2, 2, 20, 20));  // 2x2 grid for cards
        overviewPanel.setBackground(Color.WHITE);
        overviewPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        add(overviewPanel);

        // Card 1 - Performance Metrics
        JPanel performanceCard = new JPanel();
        performanceCard.setLayout(null);
        performanceCard.setBackground(new Color(255, 255, 255));
        performanceCard.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 204), 2));
        performanceCard.setPreferredSize(new Dimension(350, 180));
        
        JLabel performanceTitle = new JLabel("Performance Metrics");
        performanceTitle.setFont(new Font("Arial", Font.BOLD, 18));
        performanceTitle.setBounds(10, 10, 200, 30);
        performanceCard.add(performanceTitle);

        // Example performance metric: Completed Tasks (Bar Chart / Progress)
        JProgressBar taskCompletionBar = new JProgressBar(0, 100);
        taskCompletionBar.setValue(75);
        taskCompletionBar.setStringPainted(true);
        taskCompletionBar.setBounds(10, 60, 300, 30);
        performanceCard.add(taskCompletionBar);

        JLabel taskCompletionLabel = new JLabel("75% Tasks Completed");
        taskCompletionLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        taskCompletionLabel.setBounds(10, 100, 300, 30);
        performanceCard.add(taskCompletionLabel);
        
        overviewPanel.add(performanceCard);

        // Card 2 - Upcoming Deadlines
        JPanel deadlineCard = new JPanel();
        deadlineCard.setLayout(null);
        deadlineCard.setBackground(new Color(255, 255, 255));
        deadlineCard.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 204), 2));
        deadlineCard.setPreferredSize(new Dimension(350, 180));
        
        JLabel deadlineTitle = new JLabel("Upcoming Deadlines");
        deadlineTitle.setFont(new Font("Arial", Font.BOLD, 18));
        deadlineTitle.setBounds(10, 10, 200, 30);
        deadlineCard.add(deadlineTitle);
        
        // Example upcoming deadlines
        JTextArea deadlineList = new JTextArea("1. Report Submission - 2nd Jan\n2. Code Review - 5th Jan\n3. Client Meeting - 10th Jan");
        deadlineList.setEditable(false);
        deadlineList.setFont(new Font("Arial", Font.PLAIN, 16));
        deadlineList.setBackground(new Color(255, 255, 255));
        deadlineList.setBounds(10, 60, 300, 100);
        deadlineCard.add(deadlineList);
        
        overviewPanel.add(deadlineCard);

        // Card 3 - Recent Activities
        JPanel activityCard = new JPanel();
        activityCard.setLayout(null);
        activityCard.setBackground(new Color(255, 255, 255));
        activityCard.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 204), 2));
        activityCard.setPreferredSize(new Dimension(350, 180));
        
        JLabel activityTitle = new JLabel("Recent Activities");
        activityTitle.setFont(new Font("Arial", Font.BOLD, 18));
        activityTitle.setBounds(10, 10, 200, 30);
        activityCard.add(activityTitle);
        
        // Example recent activities
        JTextArea activityList = new JTextArea("1. Logged in - 30th Dec\n2. Task completed - 29th Dec\n3. Code committed - 28th Dec");
        activityList.setEditable(false);
        activityList.setFont(new Font("Arial", Font.PLAIN, 16));
        activityList.setBackground(new Color(255, 255, 255));
        activityList.setBounds(10, 60, 300, 100);
        activityCard.add(activityList);

        overviewPanel.add(activityCard);

        // Card 4 - Notifications
        JPanel notificationCard = new JPanel();
        notificationCard.setLayout(null);
        notificationCard.setBackground(new Color(255, 255, 255));
        notificationCard.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 204), 2));
        notificationCard.setPreferredSize(new Dimension(350, 180));
        
        JLabel notificationTitle = new JLabel("Notifications");
        notificationTitle.setFont(new Font("Arial", Font.BOLD, 18));
        notificationTitle.setBounds(10, 10, 200, 30);
        notificationCard.add(notificationTitle);
        
        // Example notifications
        JTextArea notificationList = new JTextArea("1. New Software Update Available\n2. Meeting at 2 PM\n3. Time-off request approved");
        notificationList.setEditable(false);
        notificationList.setFont(new Font("Arial", Font.PLAIN, 16));
        notificationList.setBackground(new Color(255, 255, 255));
        notificationList.setBounds(10, 60, 300, 100);
        notificationCard.add(notificationList);

        overviewPanel.add(notificationCard);

        // Back Button
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.PLAIN, 16));
        backButton.setBounds(680, 530, 100, 40);
        backButton.setBackground(new Color(0, 102, 204));
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(e -> {
            dispose();  // Close the current frame
            new UserProfile("Elon Mask");  // Open the UserProfile frame
        });
        add(backButton);

        // Frame Settings
        setSize(800, 600);  // Set size of the frame
        setLocation(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new OverviewFrame();
    }
}
