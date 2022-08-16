
package travel.management.system;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class About extends JFrame implements ActionListener{
    About(){
        setBounds(600,200,500,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel l1 = new JLabel("About ");
        
        l1.setBounds(200, 10, 100, 40);
        l1.setForeground(Color.red);
        l1.setFont(new Font("RALEWAY", Font.BOLD, 30));
        add(l1);
        
        String s = " About Projects               \n  "
                + "\nThe objective of the Travel and Tourism Management System"
                + " project is to develop a system that automates the processes "
                + "and activities of a travel and the purpose is to design a "
                + "system using which one can perform all operations related to "
                + "traveling.\n\n"
                + "This application will help in accessing the information related "
                + "to the travel to the particular destination with great ease. "
                + "The users can track the information related to their tours with "
                + "great ease through this application. The travel agency information "
                + "can also be obtained through this application.\n\n"
                + "Advantages of Project:"
                + "\nGives accurate information"
                + "\nSimplifies the manual work"
                + "\nIt minimizes the documentation related work"
                + "\nProvides up to date information"
                + "\nUser Friendly Environment by providing warning messages."
                + "\ntravellers details can be provided"
                + "\nbooking confirmation notification"
                ;
        
        TextArea t1 = new TextArea(s, 10, 40, Scrollbar.VERTICAL);
        t1.setEditable(false);
        t1.setBounds(20, 100, 450, 300);
        add(t1);
        
        
        JButton b1 = new JButton("Back");
        add(b1);
        b1.setBounds(200, 420, 100, 25);
        b1.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }
    public static void main(String[]args){
        new About().setVisible(true);
    }
}
