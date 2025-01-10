package test;


import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {
    private JTextField emailText = new JTextField();
    private JPasswordField passwordText = new JPasswordField();
    private JButton loginButton = new JButton("Login");

    public LoginFrame() {
        setTitle("Login");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Email:"));
        panel.add(emailText);
        panel.add(new JLabel("Password:"));
        panel.add(passwordText);
        panel.add(new JPanel());
        panel.add(loginButton);

        add(panel, BorderLayout.CENTER);
    }
}

