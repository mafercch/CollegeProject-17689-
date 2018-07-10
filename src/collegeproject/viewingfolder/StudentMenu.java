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
public class StudentMenu extends JFrame implements ActionListener {

    Container container = getContentPane();

    JLabel pageTitleLabel = new JLabel("Faculty Home page");

    JButton branchesViewButton = new JButton("Show Available Branches");
    JButton examsViewButton = new JButton("Show all Exams Details");

    StudentMenu() {
        container.setLayout(null);
        this.setBounds(10, 10, 810, 510);
        pageTitleLabel.setBounds(20, 10, 500, 50);

        branchesViewButton.addActionListener(this);
        examsViewButton.addActionListener(this);

        branchesViewButton.setBounds(75, 100, 250, 30);
        examsViewButton.setBounds(75, 150, 250, 30);

        container.add(pageTitleLabel);
        container.add(branchesViewButton);
        container.add(examsViewButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Show Available Branches")) {
            BranchesInfo branchesList = new BranchesInfo("All available Branches");
            branchesList.setVisible(true);
        } else if (e.getActionCommand().equals("Show all Exams Details")) {
            ExamsInfo testsList = new ExamsInfo("Show all Exams Details");
            testsList.setVisible(true);
        }
    }
}

