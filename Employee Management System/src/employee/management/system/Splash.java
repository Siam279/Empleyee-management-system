package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Splash extends JFrame implements ActionListener {
    
    JLabel heading;
    JButton adminLogin, userLogin;
    
    // Constructor for Splash screen
    Splash() {
        
        // Set layout and background color
        setLayout(null);
        getContentPane().setBackground(new Color(245, 245, 245));  // Light gray background
        
        // Create a gradient background effect
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Gradient background
                Graphics2D g2d = (Graphics2D) g;
                Color color1 = new Color(0, 102, 204);  // Blue color
                Color color2 = new Color(0, 204, 204);  // Light teal color
                GradientPaint gradient = new GradientPaint(0, 0, color1, getWidth(), getHeight(), color2);
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panel.setLayout(null);
        panel.setBounds(0, 0, 1176, 650); // Full screen panel
        add(panel);

        // Add the heading label with a fade-in effect
        heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(80, 30, 1200, 50);
        heading.setFont(new Font("Serif", Font.PLAIN, 60));
        heading.setForeground(new Color(255, 255, 255));  // White color for text
        panel.add(heading);
        
        // Create a background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50, 100, 1050, 500);
        panel.add(image);

        // Admin Login button
        adminLogin = new JButton("ADMIN LOGIN");
        adminLogin.setBounds(300, 500, 200, 50);
        adminLogin.setBackground(new Color(0, 51, 102));  // Dark blue background
        adminLogin.setForeground(Color.WHITE);  // White text
        adminLogin.setFont(new Font("Arial", Font.BOLD, 18));
        adminLogin.setFocusPainted(false);
        adminLogin.setBorder(BorderFactory.createLineBorder(new Color(0, 51, 102), 2));
        adminLogin.addActionListener(this);
        panel.add(adminLogin);

        // User Login button
        userLogin = new JButton("USER LOGIN");
        userLogin.setBounds(650, 500, 200, 50);
        userLogin.setBackground(new Color(0, 51, 102));  // Dark blue background
        userLogin.setForeground(Color.WHITE);  // White text
        userLogin.setFont(new Font("Arial", Font.BOLD, 18));
        userLogin.setFocusPainted(false);
        userLogin.setBorder(BorderFactory.createLineBorder(new Color(0, 51, 102), 2));
        userLogin.addActionListener(this);
        panel.add(userLogin);

        // Set window size and position
        setSize(1170, 650);
        setLocation(200, 50);
        setUndecorated(true);  // Remove window borders for a cleaner look
        setVisible(true);
    }
    
    // Action listener for the buttons
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == adminLogin) {
            setVisible(false);
            new Login();  // Open the Admin Login screen
        } else if (ae.getSource() == userLogin) {
            setVisible(false);
            new UserLogin();  // Open the User Login screen
        }
    }
    
    // Main method to launch the Splash screen
    public static void main(String args[]) {
        new Splash();
    }
}
