package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {

    JButton view, add, update, remove, announcement, dashboard, stats, searchEmployee, settings, reports, logout, help;

    Home() {
        setLayout(null);

        // Background image setup
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);

        // Heading for Home page
        JLabel heading = new JLabel("ISO TECHDEAL");
        heading.setBounds(620, 20, 400, 40);
        heading.setFont(new Font("Poppins", Font.BOLD, 32));
        heading.setForeground(Color.WHITE);  // White color for text
        image.add(heading);

        // Adding buttons
        add = createStyledButton("Add Employee", 650, 80);
        view = createStyledButton("View Employees", 820, 80);
        update = createStyledButton("Update Employee", 650, 140);
        remove = createStyledButton("Remove Employee", 820, 140);
        announcement = createStyledButton("Announcement", 650, 200); 
        dashboard = createStyledButton("Dashboard", 650, 260);
        stats = createStyledButton("Employee Stats", 820, 260);
        searchEmployee = createStyledButton("Search Employee", 650, 320);
        settings = createStyledButton("Settings", 820, 320);
        reports = createStyledButton("Reports", 650, 380);
        logout = createStyledButton("Logout", 820, 380);
        help = createStyledButton("Help/Support", 650, 440);

        // Adding buttons to the image background
        image.add(add);
        image.add(view);
        image.add(update);
        image.add(remove);
        image.add(announcement);
        image.add(dashboard);
        image.add(stats);
        image.add(searchEmployee);
        image.add(settings);
        image.add(reports);
        image.add(logout);
        image.add(help);

        // Set the frame properties
        setSize(1120, 630);
        setLocation(250, 100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Ensure the app closes when the window is closed
    }

    // ActionListener for buttons
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            setVisible(false);
            new AddEmployee();
        } else if (ae.getSource() == view) {
            setVisible(false);
            new ViewEmployee();
        } else if (ae.getSource() == update) {
            setVisible(false);
            new UpdateEmployee();  // Assuming you have a UpdateEmployee class
        } else if (ae.getSource() == remove) {
            setVisible(false);
            new RemoveEmployee();
        } else if (ae.getSource() == announcement) {
            setVisible(false);
            new AnnouncementPage();  // Page to send announcements
        } else if (ae.getSource() == dashboard) {
            setVisible(false);
            new DashboardPage();  // New page for dashboard overview
        } else if (ae.getSource() == stats) {
            setVisible(false);
            new EmployeeStatsPage();  // Page for employee statistics
        } else if (ae.getSource() == searchEmployee) {
            setVisible(false);
            new SearchEmployeePage();  // Page for searching employees
        } else if (ae.getSource() == settings) {
            setVisible(false);
            new SettingsPage();  // Settings page
        } else if (ae.getSource() == reports) {
            setVisible(false);
            new ReportsPage();  // Page to generate reports
        } else if (ae.getSource() == logout) {
            setVisible(false);
            new Login();  // Redirect to login page
        } else if (ae.getSource() == help) {
            setVisible(false);
            new HelpPage();  // Help and support page
        }
    }

    // Method to create styled buttons with hover effect
    private JButton createStyledButton(String text, int x, int y) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 150, 40);
        button.setFont(new Font("Arial", Font.PLAIN, 16));
        button.setBackground(new Color(0, 123, 255));  // Premium blue color
        button.setForeground(Color.WHITE);  // White text
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(new Color(0, 123, 255), 2));  // Border color
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));  // Hand cursor on hover

        // Hover effect for the buttons
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(0, 150, 255));  // Lighter blue on hover
            }
            public void mouseExited(MouseEvent e) {
                button.setBackground(new Color(0, 123, 255));  // Default color
            }
        });

        button.addActionListener(this);
        return button;
    }

    public static void main(String[] args) {
        new Home();
    }
}
