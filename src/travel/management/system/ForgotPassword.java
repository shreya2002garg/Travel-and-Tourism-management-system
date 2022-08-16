
package travel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class ForgotPassword extends JFrame implements ActionListener{
    JTextField t1,t2,t3,t4,t5;
    JButton b1,b2,b3;
    ForgotPassword(){
        setBounds(350, 200, 850, 380);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setLayout(null);
	p1.setBounds(30, 30, 500, 300);
        p1.setBackground(Color.PINK);
	add(p1);
        
        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.png"));
        Image i1 = c1.getImage().getScaledInstance(230, 230,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel l6 = new JLabel(i2);
        l6.setBounds(580, 70, 230, 230);
        add(l6);
        
        JLabel l1 = new JLabel("Username");
	l1.setFont(new Font("Tahoma", Font.BOLD, 14));
	l1.setBounds(40, 20, 100, 25);
	p1.add(l1);
        
        t1 = new JTextField();
	t1.setBorder(BorderFactory.createEmptyBorder());
	t1.setBounds(220, 20, 150, 25);
	p1.add(t1);
        
        b1 = new JButton("Search");
	b1.setFont(new Font("Tahoma", Font.BOLD, 13));
	b1.setBounds(380, 20, 100, 25);
	b1.setBackground(Color.GRAY);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        p1.add(b1);
        
        JLabel l2 = new JLabel("Name");
	l2.setFont(new Font("Tahoma", Font.BOLD, 14));
	l2.setBounds(40, 60, 100, 25);
	p1.add(l2);
        
        t2 = new JTextField();
	t2.setBorder(BorderFactory.createEmptyBorder());
	t2.setBounds(220, 60, 150, 25);
	p1.add(t2);
        
        JLabel l3 = new JLabel("security question ");
	l3.setFont(new Font("Tahoma", Font.BOLD, 14));
	l3.setBounds(40, 100, 150, 25);
	p1.add(l3);
        
        t3 = new JTextField();
	t3.setBorder(BorderFactory.createEmptyBorder());
	t3.setBounds(220, 100, 150, 25);
	p1.add(t3);
        
        JLabel l4 = new JLabel("Answer");
	l4.setFont(new Font("Tahoma", Font.BOLD, 14));
	l4.setBounds(40, 140, 150, 25);
	p1.add(l4);
        
        t4 = new JTextField();
	t4.setBorder(BorderFactory.createEmptyBorder());
	t4.setBounds(220, 140, 150, 25);
	p1.add(t4);
        
        b2 = new JButton("Retrieve");
	b2.setFont(new Font("Tahoma", Font.BOLD, 13));
	b2.setBounds(380, 140, 100, 25);
	b2.setBackground(Color.GRAY);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        p1.add(b2);
        
        JLabel l5 = new JLabel("Password");
	l5.setFont(new Font("Tahoma", Font.BOLD, 14));
	l5.setBounds(40, 180, 150, 25);
	p1.add(l5);
	
        t5 = new JTextField();
	t5.setBorder(BorderFactory.createEmptyBorder());
	t5.setBounds(220, 180, 150, 25);
	p1.add(t5);
        
        b3 = new JButton("Back");
	b3.setFont(new Font("Tahoma", Font.BOLD, 13));
	b3.setBounds(150, 230, 100, 25);
	b3.setBackground(Color.GRAY);
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        p1.add(b3);

        
        setVisible(true);
	
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
        
        
            
            try{
                String query = "select * from account where username='"+t1.getText()+"'";  //checking whether username in table is same as username entered
                Conn c=new Conn();
		ResultSet rs=c.s.executeQuery(query); // we will get row which is stored in rs
                while(rs.next()){
                    t2.setText(rs.getString("name"));
                    t3.setText(rs.getString("security"));
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==b2){
            try{
                String query = "select * from account where username='"+t1.getText()+"' AND answer='"+t4.getText()+"'";  //checking whether username in table is same as username entered
                Conn c=new Conn();
		ResultSet rs=c.s.executeQuery(query); // we will get row which is stored in rs
                while(rs.next()){
                    t5.setText(rs.getString("password"));
                    
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }    
                    
        else{
            setVisible(false);
            new Login();
        }
    }
        
    public static void main(String[]args){
        new ForgotPassword();
    }
}
