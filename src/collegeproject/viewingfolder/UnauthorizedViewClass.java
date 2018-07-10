/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collegeproject.viewingfolder;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author mariacontreras / 17689
 */
public class UnauthorizedViewClass extends JFrame implements ActionListener {

    Container container = getContentPane();
    JLabel errorMessageLabel = null;

    UnauthorizedViewClass (String errorMessage) {
        errorMessageLabel = new JLabel(errorMessage);
        this.setBounds(10, 10, 810, 510);
        container.setLayout(null);

        errorMessageLabel.setBounds(100, 100, 500, 50);
        JButton loginAgain = new JButton("Login again");
        loginAgain.addActionListener(this);

        loginAgain.setBounds(250, 250, 150, 50);

        container.add(errorMessageLabel);
        container.add(loginAgain);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }

}

