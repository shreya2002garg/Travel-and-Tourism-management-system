
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class ViewCustomer extends JFrame implements ActionListener{
    JButton back;
    ViewCustomer(String username){
        setBounds(350,80,870,625);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel l1=new JLabel("Username");
        l1.setBounds(30,50,150,25);
        add(l1);
        
        JLabel labelusername=new JLabel("");
        labelusername.setBounds(220,50,150,25);
        add(labelusername);
        
        JLabel l2=new JLabel("id");
        l2.setBounds(30,110,150,25);
        add(l2);
        
        JLabel labelid=new JLabel("");
        labelid.setBounds(220,110,150,25);
        add(labelid);
        
        JLabel l3=new JLabel("Number");
        l3.setBounds(30,170,150,25);
        add(l3);
        
        JLabel labelnumber=new JLabel("");
        labelnumber.setBounds(220,170,150,25);
        add(labelnumber);
        
        JLabel l4=new JLabel("Name");
        l4.setBounds(30,230,150,25);
        add(l4);
        
        JLabel labelname=new JLabel("");
        labelname.setBounds(220,230,150,25);
        add(labelname);
        
        JLabel l5=new JLabel("Gender");
        l5.setBounds(30,290,150,25);
        add(l5);
        
        JLabel labelgender=new JLabel("");
        labelgender.setBounds(220,290,150,25);
        add(labelgender);
        
        JLabel l6=new JLabel("Country");
        l6.setBounds(500,50,150,25);
        add(l6);
        
        JLabel labelcountry=new JLabel("");
        labelcountry.setBounds(690,50,150,25);
        add(labelcountry);
        
        JLabel l7=new JLabel("Address");
        l7.setBounds(500,110,150,25);
        add(l7);
        
        JLabel labeladdress=new JLabel("");
        labeladdress.setBounds(690,110,150,25);
        add(labeladdress);
        
        JLabel l8=new JLabel("Phone number");
        l8.setBounds(500,170,150,25);
        add(l8);
        
        JLabel labelphone=new JLabel("");
        labelphone.setBounds(690,170,150,25);
        add(labelphone);
        
        JLabel l9=new JLabel("Email");
        l9.setBounds(500,230,150,25);
        add(l9);
        
        JLabel labelmail=new JLabel("");
        labelmail.setBounds(690,230,170,25);
        add(labelmail);
        
        back=new JButton("Back");
        back.setBounds(390, 310, 100, 25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/viewcustomer.png"));
        Image i3 = i1.getImage().getScaledInstance(800, 350,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l10 = new JLabel(i2);
        l10.setBounds(20,350,800,350);
        add(l10);
        
        try{
            Conn c= new Conn();
            String query= "select * from customer where username='"+username+"'";
            ResultSet rs= c.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelname.setText(rs.getString("name"));
                labelgender.setText(rs.getString("gender"));
                labelcountry.setText(rs.getString("country"));
                labeladdress.setText(rs.getString("address"));
                labelphone.setText(rs.getString("phone"));
                labelmail.setText(rs.getString("email"));
            }
        
        }catch(Exception ae){
            ae.printStackTrace();
        }
        
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }

    public static void main(String[]args){
        new ViewCustomer("shreya");
    }
}   

