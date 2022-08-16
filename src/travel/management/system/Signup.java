
package travel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;  // contain action listener

public class Signup extends JFrame implements ActionListener{
    JButton b1,b2;
    JTextField t1,t2,t3,t4;
    Choice security;

    
    public Signup(){
        
        setBounds(350, 200, 900, 400);
        getContentPane().setBackground(Color.WHITE);
	setLayout(null);
        
        JPanel p1=new JPanel();  //in awt package
        p1.setBackground(new Color(131,193,233));    // makes panel blue colour
        p1.setBounds(0,0,500,400); // add panel on left
        p1.setLayout(null);    // for picking set bound function
        add(p1);
        
        JLabel l1 = new JLabel("Username");
	l1.setBounds(50, 20, 125, 25);
        l1.setFont(new Font("Tahoma",Font.BOLD,14));
	p1.add(l1);
        
        t1= new JTextField();
	t1.setBounds(190, 20,180,25);
        t1.setBorder(BorderFactory.createEmptyBorder());   // dont want border in box
	p1.add(t1);
        
        JLabel l2 = new JLabel("Name");
	l2.setBounds(50, 60, 125, 25);
        l2.setFont(new Font("Tahoma",Font.BOLD,14));
	p1.add(l2);
        
        t2= new JTextField();
	t2.setBounds(190, 60,180,25);
        t2.setBorder(BorderFactory.createEmptyBorder());   // dont want border in box
	p1.add(t2);
        
        
        JLabel l3 = new JLabel("Password");
	l3.setBounds(50, 100, 125, 25);
        l3.setFont(new Font("Tahoma",Font.BOLD,14));
	p1.add(l3);
        
        t3= new JTextField();
	t3.setBounds(190, 100,180,25);
        t3.setBorder(BorderFactory.createEmptyBorder());   // dont want border in box
	p1.add(t3);
        
        JLabel l4 = new JLabel("Security Question");
	l4.setBounds(50, 140, 125, 25);
        l4.setFont(new Font("Tahoma",Font.BOLD,14));
	p1.add(l4);
        
        security= new Choice();
        security.add("Fav Harry Potter series character");
        security.add("Your lucky number");
        security.add("Your childhood superhero");
        security.add("fav fast food");
        security.setBounds(190,140,180,25);
        p1.add(security);
        
        JLabel l5 = new JLabel("Answer");
	l5.setBounds(50, 180, 125, 25);
        l5.setFont(new Font("Tahoma",Font.BOLD,14));
	p1.add(l5);
        
        t4= new JTextField();
	t4.setBounds(190, 180,180,25);
        t4.setBorder(BorderFactory.createEmptyBorder());   // dont want border in box
	p1.add(t4);
        
        b1 = new JButton("Create");
	b1.addActionListener(this);
	b1.setFont(new Font("Tahoma", Font.BOLD, 14));
	b1.setBounds(80, 250, 100, 30);
        b1.setBackground(Color.WHITE);
        b1.setForeground(new Color(133,193,233));
	p1.add(b1);
        
        b2 = new JButton("Back");
	b2.addActionListener(this);
	b2.setFont(new Font("Tahoma", Font.BOLD, 14));
	b2.setBounds(250, 250, 100, 30);
        b2.setBackground(Color.WHITE);
        b2.setForeground(new Color(133,193,233));
	p1.add(b2);
        
        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.jpg"));
        Image i1 = c1.getImage().getScaledInstance(250, 250,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel l6 = new JLabel(i2);
        l6.setBounds(600, 50, 250, 250);
        add(l6);  

        
        
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){  // Action event tell source of event that which button is pressed
        if(ae.getSource()==b1){
            String username= t1.getText();
            String name= t2.getText();
            String password= t3.getText();
            String question= security.getSelectedItem();  // it is drpdown 
            String answer= t4.getText();
            
            String query = "insert into account values('"+username+"','"+name+"','"+password+"','"+question+"','"+answer+"')";
            try{
                Conn c=new Conn();  // making connection with mysql
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null,"Account Created Successfully");  // if create pressed after entering all details then this message will be displayed
                
                setVisible(false);
                new Login();
            }catch(Exception e){
                e.printStackTrace();
            }
        } else if(ae.getSource()== b2){
            setVisible(false);
            new Login(); // open login page
        }
            
       
    }

    public static void main(String [] args){
        new Signup().setVisible(true);
    }
}
