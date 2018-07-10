/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collegeproject.viewingfolder;

import BussinesFolder.Implementor;
import BussinesFolder.User;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author mariacontreras / 17689
 */
public class Authentication extends JFrame implements ActionListener {

    Container container = getContentPane();
    JLabel pageTitle = new JLabel("AuthenticationView");
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton registerButton = new JButton("New Student ? Register now !");
    Implementor manager = new Implementor();

    Authentication() {
        loginButton.addActionListener(this);
        registerButton.addActionListener(this);
        container.setLayout(null);
        pageTitle.setBounds(20, 10, 150, 50);

        userLabel.setBounds(50, 150, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);

        passwordLabel.setBounds(50, 220, 100, 30);
        passwordField.setBounds(150, 220, 150, 30);

        loginButton.setBounds(50, 300, 100, 30);
        registerButton.setBounds(50, 350, 400, 30);

        container.add(pageTitle);
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(loginButton);
        container.add(registerButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // login
        if (e.getActionCommand().equals("LOGIN")) {
            String un = userTextField.getText();
            String pw = passwordField.getText();
            System.out.println("User Name : " + un);
            System.out.println("Password : " + pw);
            User user = manager.getUser(un, pw);
            if (user == null) {
                UnauthorizedViewClass errorPage = new UnauthorizedViewClass("No User found with the given credentials.");
                errorPage.setVisible(true);
                //this.setVisible(false);
            } else {
                if (user.isSuperAdmin()) {
                    System.out.println("Logged in as super admin.");
                    AdminMenu adminPage = new AdminMenu();
                    adminPage.setVisible(true);
                    this.setVisible(false);
                } else if (user.isFaculty()) {
                    System.out.println("Logged in as faculty.");
                    FacultyMenu facultyPage = new FacultyMenu();
                    facultyPage.setVisible(true);
                    this.setVisible(false);
                } else if (user.isStudent()) {
                    System.out.println("Logged in as student.");
                    StudentMenu studentPage = new StudentMenu();
                    studentPage.setVisible(true);
                    this.setVisible(false);
                }
            }
        } // register
        else if (e.getActionCommand().equals("New Student ? Register now !")) {
            Register registrationPage = new Register("Student Registration", "student");
            registrationPage.setVisible(true);
        }
    }
}

