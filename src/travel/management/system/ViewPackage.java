
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;


public class ViewPackage extends JFrame implements ActionListener{
    JButton back;
    ViewPackage(String username){
        setBounds(450,200,900,450);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text =new JLabel("VIEW PACKAGE DETAILS");
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        text.setBounds(60,0,300,30);
        add(text);
        
        JLabel l1=new JLabel("Username");
        l1.setBounds(30,50,150,25);
        add(l1);
        
        JLabel labelusername=new JLabel("");
        labelusername.setBounds(220,50,150,25);
        add(labelusername);
        
        JLabel l2=new JLabel("Package");
        l2.setBounds(30,90,150,25);
        add(l2);
        
        JLabel labelpack=new JLabel("");
        labelpack.setBounds(220,90,150,25);
        add(labelpack);
        
        JLabel l3=new JLabel("Total persons");
        l3.setBounds(30,130,150,25);
        add(l3);
        
        JLabel labelpersons=new JLabel("");
        labelpersons.setBounds(220,130,150,25);
        add(labelpersons);
        
        JLabel l4=new JLabel("id");
        l4.setBounds(30,170,150,25);
        add(l4);
        
        JLabel labelid=new JLabel("");
        labelid.setBounds(220,170,150,25);
        add(labelid);
        
        JLabel l5=new JLabel("Number");
        l5.setBounds(30,210,150,25);
        add(l5);
        
        JLabel labelnumber=new JLabel("");
        labelnumber.setBounds(220,210,150,25);
        add(labelnumber);
        
        JLabel l6=new JLabel("Phone");
        l6.setBounds(30,250,150,25);
        add(l6);
        
        JLabel labelphone=new JLabel("");
        labelphone.setBounds(220,250,150,25);
        add(labelphone);
        
        JLabel l7=new JLabel("Price");
        l7.setBounds(30,290,150,25);
        add(l7);
        
        JLabel labelprice=new JLabel("");
        labelprice.setBounds(220,290,150,25);
        add(labelprice);
        
        
        back=new JButton("Back");
        back.setBounds(130, 360, 100, 25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/viewpackage.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 325,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l10 = new JLabel(i2);
        l10.setBounds(350,20,500,325);
        add(l10);
        
        try{
            Conn c= new Conn();
            String query= "select * from bookpackage where username='"+username+"'";
            ResultSet rs= c.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelpack.setText(rs.getString("package"));
                labelpersons.setText(rs.getString("persons"));
                labelprice.setText(rs.getString("price"));
                labelphone.setText(rs.getString("phone"));
                
            }
        
        }catch(Exception ae){
            ae.printStackTrace();
        }
        
        
        
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }

    public static void main(String[]args){
        new ViewPackage("shreya").setVisible(true);
    }
}   

    

