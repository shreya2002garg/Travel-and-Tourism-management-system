
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookPackage extends JFrame implements ActionListener {
    Choice c1;  // drop down for package
    JTextField tfperson;
    JLabel labelusername,labelid,labelnumber,labelphone,labelprice;
    JButton checkprice,bookpackage,back;
    String username;
    BookPackage(String username){
        this.username=username;
        setBounds(250,200,1100,500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        
        JLabel l1=new JLabel("Username");
        l1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l1.setBounds(40,70,100,20);
        add(l1);
        
        JLabel text = new JLabel("BOOK PACKAGE");
        text.setFont(new Font("Yu Mincho", Font.BOLD, 20));
        text.setBounds(100, 10, 200, 30);
        add(text);
                
        
        labelusername=new JLabel("");
        labelusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelusername.setBounds(250,70,200,20);
        add(labelusername);
        
        JLabel select=new JLabel("Select Pckage");
        select.setFont(new Font("Tahoma", Font.PLAIN, 16));
        select.setBounds(40,110,150,20);
        add(select);
        
        c1 = new Choice();     // drop down
        c1.add("Gold Package");
        c1.add("Silver Package");
        c1.add("Bronze Package");
        c1.setBounds(250, 110, 200, 20);
        add(c1);
        
        JLabel l2=new JLabel("Total persons");
        l2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l2.setBounds(40,150,150,25);
        add(l2);
        
       tfperson=new JTextField("1");
       tfperson.setBounds(250,150,200,25);
       add(tfperson);
        
        JLabel l3=new JLabel("id");
        l3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l3.setBounds(40,190,150,20);
        add(l3);
        
        labelid=new JLabel("");
        labelid.setBounds(250,190,200,25);
        add(labelid);
        
        JLabel l4=new JLabel("Number");
        l4.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l4.setBounds(40,230,150,25);
        add(l4);
        
        labelnumber=new JLabel("");
        labelnumber.setBounds(250,230,150,25);
        add(labelnumber);
        
        JLabel l5=new JLabel("Phone");
        l5.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l5.setBounds(40,270,150,25);
        add(l5);
        
        labelphone=new JLabel("");
        labelphone.setBounds(250,270,200,25);
        add(labelphone);
        
        JLabel l6=new JLabel("Total Price");
        l6.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l6.setBounds(40,310,150,25);
        add(l6);
        
        labelprice=new JLabel("");
        labelprice.setBounds(250,310,150,25);
        add(labelprice);
        
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel la1 = new JLabel(i2);
        la1.setBounds(500,50,500,300);
        add(la1);
		
        
        try{
            Conn c= new Conn();
            String query= "select * from customer where username='"+username+"'";
            ResultSet rs= c.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
                
            }
        
        }catch(Exception ae){
            ae.printStackTrace();
        }
        checkprice=new JButton("Check Price");
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.setBounds(60,380,120,25);
        checkprice.addActionListener(this);
        add(checkprice);
        
        bookpackage=new JButton("Book Package");
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBounds(200,380,120,25);
        bookpackage.addActionListener(this);
        add(bookpackage);
        
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(340,380,120,25);
        back.addActionListener(this);
        add(back);
        
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==checkprice){
            String p = c1.getSelectedItem();
            int cost = 0;
            if(p.equals("Gold Package")) {
                
                cost += 14000;
            }else if(p.equals("Silver Package")){
                cost += 25000;
            }else {
                cost += 33000;
            }
                            
            cost *= Integer.parseInt(tfperson.getText());
            labelprice.setText("Rs "+cost);
                            
            
        }else if(ae.getSource()==bookpackage){
            try{
                Conn c=new Conn();
	    	
                                
                String q1 = "insert into bookpackage values('"+labelusername.getText()+"', '"+c1.getSelectedItem()+"', '"+tfperson.getText()+"', '"+labelid.getText()+"', '"+labelnumber.getText()+"', '"+labelphone.getText()+"', '"+labelprice.getText()+"')";
                c.s.executeUpdate(q1);
                                
	    	JOptionPane.showMessageDialog(null, "Package Booked Successfully");
                setVisible(false);
            }catch(Exception ee){
	        System.out.println(ee.getMessage());
            }
                            
            
        }else{
            setVisible(false);
        }
    }
    public static void main(String []args){
        new BookPackage("shreya").setVisible(true);
    }
}
