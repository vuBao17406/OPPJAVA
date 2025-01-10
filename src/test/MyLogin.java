package test;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MyLogin {
    private JFrame frm = new JFrame("Login");
    private JLabel titelJLabel = new JLabel("Sign In", JLabel.CENTER);
    private JPanelCus wrapper = new JPanelCus(new GridLayout(1, 2));
    private JPanelCus container_login_form = new JPanelCus(new BorderLayout());
    private JPanelCus wrapper_login_form = new JPanelCus(new GridLayout(13, 1)); // Tăng số hàng lên 13

    private JLabel nameLabel = new JLabel("Full Name");
    private JLabel emailLabel = new JLabel("Email");
    private JLabel passWord = new JLabel("PassWord");
    private JLabel confirmPasswordLabel = new JLabel("Confirm Password"); // Thêm nhãn "Confirm Password"
    private List<JLabel> jLabelList = Arrays.asList(nameLabel, emailLabel, passWord, confirmPasswordLabel);

    private JTextField nameText = new JTextField();
    private JTextField emailText = new JTextField();
    private JTextField passWordText = new JPasswordField();
    private JTextField confirmPasswordText = new JPasswordField(); // Thêm trường "Confirm Password"
    private List<JTextField> jTextFieldList = Arrays.asList(nameText, emailText, passWordText, confirmPasswordText);

    private JButton signUp = new JButton("Sign Up");
    private JLabel exitAcc = new JLabel("Already have an account");
    private JButton loginButton = new JButton("Login");

    public JPanelCus createPanelWithPadding(JComponent component, int chieuDai, int chieuCao, Color color) {
        JPanelCus panel = new JPanelCus(new BorderLayout());
        panel.add(component, BorderLayout.CENTER);
        panel.add(Createblank(1, chieuCao, color), BorderLayout.SOUTH);
        panel.add(Createblank(1, chieuCao, color), BorderLayout.NORTH);
        panel.add(Createblank(chieuDai, 1, color), BorderLayout.WEST);
        panel.add(Createblank(chieuDai, 1, color), BorderLayout.EAST);
        return panel;
    }

    public JPanelCus createPanelWithPadding(JComponent component, int chieuDai, int chieuCao) {
        JPanelCus panel = new JPanelCus(new BorderLayout());
        panel.add(component, BorderLayout.CENTER);
        panel.add(Createblank(1, chieuCao), BorderLayout.SOUTH);
        panel.add(Createblank(1, chieuCao), BorderLayout.NORTH);
        panel.add(Createblank(chieuDai, 1), BorderLayout.WEST);
        panel.add(Createblank(chieuDai, 1), BorderLayout.EAST);
        return panel;
    }

    public JLabel createImage() {
        BufferedImage bufferImg = null;
        try {
            bufferImg = ImageIO.read(new File("src/test/OIP.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new JLabel(new ImageIcon(bufferImg));
    }

    public JPanelCus createFormFooter() {
        JPanelCus containerFormFooter = new JPanelCus(new BorderLayout());
        JPanelCus wrapperFormFooter = new JPanelCus(new GridLayout(1, 2));
        wrapperFormFooter.add(exitAcc);
        wrapperFormFooter.add(loginButton);
        containerFormFooter.add(wrapperFormFooter, BorderLayout.CENTER);
        containerFormFooter.add(Createblank(50, 1), BorderLayout.EAST);
        return containerFormFooter;
    }

    public JPanelCus createFormWithImage() {
        titelJLabel.setFont(new Font("Time New Roman", Font.BOLD, 30));
        container_login_form.add(createPanelWithPadding(wrapper_login_form, 50, 59), BorderLayout.CENTER);
        JPanelCus signinTitle = createPanelWithPadding(titelJLabel, 50, 1);
        wrapper_login_form.add(signinTitle);
        for (int i = 0; i < this.jLabelList.size(); i++) {
            wrapper_login_form.add(this.jLabelList.get(i));
            wrapper_login_form.add(this.jTextFieldList.get(i));
        }
        JPanelCus SignUpWrapper = new JPanelCus(new GridLayout(1, 3));
        SignUpWrapper.add(signUp);
        SignUpWrapper.add(Createblank());
        SignUpWrapper.add(Createblank());
        wrapper_login_form.add(Createblank());
        wrapper_login_form.add(SignUpWrapper);
        wrapper_login_form.add(Createblank());
        wrapper_login_form.add(createFormFooter());

        // Thêm panel đăng nhập vào cột bên phải của wrapper
        wrapper.add(container_login_form);

        // Thêm hình ảnh vào cột bên trái của wrapper
        JLabel imageLabel = createImage();
        wrapper.add(imageLabel);

        return wrapper;
    }

    public JPanel Createblank() {
        JPanel jpanelBlank = new JPanel();
        return jpanelBlank;
    }

    public JPanel Createblank(int chieuDai, int chieuCao) {
        JPanel jpanelBlank = new JPanel();
        jpanelBlank.setPreferredSize(new Dimension(chieuDai, chieuCao));
        return jpanelBlank;
    }

    public JPanel Createblank(int chieuDai, int chieuCao, Color color) {
        JPanel jpanelBlank = new JPanel();
        jpanelBlank.setPreferredSize(new Dimension(chieuDai, chieuCao));
        jpanelBlank.setBackground(color);
        return jpanelBlank;
    }

    public void Run() {
        frm.setLayout(new BorderLayout());
        frm.setSize(new Dimension(1000, 600));
        frm.setLocationRelativeTo(null);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.add(createFormWithImage(), BorderLayout.CENTER);
        frm.setVisible(true);
        loginButton.addActionListener(e -> {
            LoginFrame loginFrame=new LoginFrame();
            loginFrame.setVisible(true);
        });
    }

    public static void main(String[] args) {
        MyLogin myLogin = new MyLogin();
        myLogin.Run();
    }
}
