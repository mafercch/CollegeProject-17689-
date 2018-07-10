/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collegeproject.viewingfolder;

import BussinesFolder.Branch;
import BussinesFolder.Implementor;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 *
 * @author mariacontreras / 17689
 */
public class BranchesInfo extends JFrame implements ActionListener {

    Container container = getContentPane();
    JLabel pageTitleLabel = null;
    DefaultListModel<String> list = new DefaultListModel<String>();
    Implementor manager = new Implementor();

    BranchesInfo(String title) {
        this.setBounds(10, 10, 810, 510);
        container.setLayout(null);
        List<Branch> branches = manager.getAllBranches();
        for (Branch b : branches) {
            list.addElement(b.toString());
        }
        JList<String> testsList = new JList<String>(list);
        pageTitleLabel = new JLabel(title);
        pageTitleLabel.setBounds(20, 10, 500, 50);
        testsList.setBounds(20, 50, 600, 300);
        container.add(pageTitleLabel);
        container.add(testsList);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
