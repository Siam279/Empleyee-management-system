package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
import java.sql.*;

public class AnnouncementPage extends JFrame implements ActionListener {
    
    JTextArea announcementText;
    JButton sendAnnouncement;
    
    AnnouncementPage() {
        setLayout(null);
        
        // Heading for Announcement page
        JLabel heading = new JLabel("Send Announcement");
        heading.setBounds(450, 20, 300, 40);
        heading.setFont(new Font("Poppins", Font.BOLD, 24));
        heading.setForeground(Color.BLACK);
        add(heading);
        
        // TextArea for the announcement
        announcementText = new JTextArea();
        announcementText.setBounds(150, 80, 800, 300);
        announcementText.setFont(new Font("Arial", Font.PLAIN, 16));
        announcementText.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(announcementText);
        
        // Button to send the announcement
        sendAnnouncement = new JButton("Send Announcement");
        sendAnnouncement.setBounds(400, 400, 200, 40);
        sendAnnouncement.setBackground(new Color(0, 123, 255));
        sendAnnouncement.setForeground(Color.WHITE);
        sendAnnouncement.setFont(new Font("Arial", Font.BOLD, 16));
        sendAnnouncement.addActionListener(this);
        add(sendAnnouncement);
        
        setSize(1100, 600);
        setLocation(150, 100);
        setVisible(true);
    }
    
    // ActionListener for sending the announcement
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == sendAnnouncement) {
            String announcement = announcementText.getText();
            if (!announcement.isEmpty()) {
                sendEmailToAllEmployees(announcement);
            } else {
                JOptionPane.showMessageDialog(this, "Announcement text cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    // Method to send emails to all employees
    public void sendEmailToAllEmployees(String announcement) {
        try {
            // Connect to the database to get all employee emails
            Conn c = new Conn();
            String query = "SELECT email FROM employees"; // Assuming you have an 'employees' table with an 'email' column
            ResultSet rs = c.s.executeQuery(query);
            
            // Sending email to each employee
            while (rs.next()) {
                String recipientEmail = rs.getString("email");
                sendEmail(recipientEmail, announcement);
            }
            JOptionPane.showMessageDialog(this, "Announcement sent successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error sending announcement", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Method to send email using JavaMail API
    private void sendEmail(String recipientEmail, String announcement) {
        String senderEmail = "your-email@gmail.com"; // Your email address
        String senderPassword = "your-email-password"; // Your email password
        
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });
        
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
            message.setSubject("Employee Announcement");
            message.setText(announcement);
            
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new AnnouncementPage();
    }
}
