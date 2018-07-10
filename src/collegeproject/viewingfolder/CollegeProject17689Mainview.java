/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collegeproject.viewingfolder;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author mariacontreras / 17689
 */
public class CollegeProject17689Mainview {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Authentication frame = new Authentication();
            frame.setVisible(true);
            frame.setBounds(10, 10, 1000, 750);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
