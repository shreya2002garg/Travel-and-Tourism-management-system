
package travel.management.system;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
        JButton b1,b2,b3;
	JTextField t1,t2;

	public Login() {
            setSize(900,450);   // for frame
            setLocation(350,200);
            setLayout(null);  // not using swing layout
            getContentPane().setBackground(Color.WHITE);  // changes all frame colour to white
            
            JPanel p1=new JPanel();  //in awt package
            p1.setBackground(new Color(131,193,233));    // makes panel blue colour
            p1.setBounds(0,0,400,450); 
            p1.setLayout(null);    // for picking set bound function
            add(p1);
            
            ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpg"));
            Image i1 = c1.getImage().getScaledInstance(250, 250,Image.SCALE_DEFAULT);
            ImageIcon i2 = new ImageIcon(i1);
        
        
            JLabel l6 = new JLabel(i2);
            l6.setBounds(100, 30, 250, 250);
            p1.add(l6);     // add on panel
            
            JPanel p2= new JPanel();   // add panel on right
            p2.setLayout(null);
            p2.setBounds(400,40,550,350);
            add(p2);
            
            JLabel l1 = new JLabel("Username");
	    l1.setBounds(60, 20, 100, 25);
            l1.setFont(new Font("SAN SERIF",Font.PLAIN,20));
	    p2.add(l1);
            
            t1= new JTextField();
	    t1.setBounds(60, 60,300,30);
            t1.setBorder(BorderFactory.createEmptyBorder());   // dont want border in box
	    p2.add(t1);
            
            JLabel l2 = new JLabel("Password");
	    l2.setBounds(60, 110, 100, 25);
            l2.setFont(new Font("SAN SERIF",Font.PLAIN,20));
	    p2.add(l2);
            
            t2= new JTextField();
	    t2.setBounds(60, 150,300,30);
            t2.setBorder(BorderFactory.createEmptyBorder());   // dont want border in box
	    p2.add(t2);
            
            b1= new JButton("Login");
            b1.setBounds(60,200,130,30);
            b1.setBackground(new Color(133,193,233));
            b1.setForeground(Color.WHITE);
            b1.setBorder(BorderFactory.createEmptyBorder()); 
            b1.addActionListener(this);
            p2.add(b1);
            
            b2= new JButton("Signup");
            b2.setBounds(230,200,130,30);
            b2.setBackground(new Color(133,193,233));
            b2.setForeground(Color.WHITE);
            b2.setBorder(BorderFactory.createEmptyBorder()); 
            b2.addActionListener(this);
            p2.add(b2);
            
            JLabel l7 = new JLabel("New User Signup...");
	    l7.setBounds(280, 180, 150, 25);
            l7.setForeground(Color.BLUE);
	    p2.add(l7);
            
            b3= new JButton("Forget Password");
            b3.setBounds(130,250,130,30);
            b3.setBackground(new Color(133,193,233));
            b3.setForeground(Color.WHITE);
            b3.setBorder(BorderFactory.createEmptyBorder()); 
            b3.addActionListener(this);
            p2.add(b3);
            
            JLabel l3 = new JLabel("Trouble in Login....");
	    l3.setBounds(300, 250, 150, 20);
            l3.setForeground(Color.RED);
	    p2.add(l3);
        
            
            setVisible(true);
            
        }
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==b1){
                try{
                    String username =t1.getText();
                    String password =t2.getText();
                    
                    String query="select * from account where username='"+username+"' AND password='"+password+"'";
                    Conn c =new Conn();
                    ResultSet rs = c.s.executeQuery(query);
                    if(rs.next()){
                        setVisible(false);
                        new Loading(username);
                    }else {
                        JOptionPane.showMessageDialog(null,"incorrect username or password");
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
             
            }else if(ae.getSource()==b2){
                setVisible(false);
                new Signup();
            }else{
                setVisible(false);
                new ForgotPassword();
            }
        }
            
            
	
  	public static void main(String[] args) {
                new Login().setVisible(true);
	}

}