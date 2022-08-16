
package travel.management.system;
import java.sql.*;	
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener{
    JLabel labelusername,labelname;
    JComboBox comboid;
    JTextField t1,t3,t5,t6,t8,t2,t7;
    JRadioButton r1,r2,r3;
    JButton add,back;
    public static void main(String[]args){
        new AddCustomer("shreya").setVisible(true);
    
    }
    public AddCustomer(String username) {
//		System.out.println(username);
                setBounds(350, 200, 850, 550);
                setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
                Image i3 = i1.getImage().getScaledInstance(400, 500,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l1 = new JLabel(i2);
                l1.setBounds(400,40,450,420);
                add(l1);
		
//		JLabel lblName = new JLabel("NEW CUSTOMER FORM");
//		lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
//		lblName.setBounds(118, 11, 260, 53);
//		add(lblName);
                
                JLabel l3 = new JLabel("Username :");
		l3.setBounds(30, 50, 150, 25);
		add(l3);
                
                labelusername = new JLabel("");
		labelusername.setBounds(220, 50, 150, 25);
		add(labelusername);
                
               
                JLabel lblId = new JLabel("ID");
		lblId.setBounds(30, 90, 150, 25);
		add(lblId);
                
                comboid = new JComboBox(new String[] {"Passport", "Aadhar Card", "Voter Id", "Driving license","Pan card"});   //drop down option
		comboid.setBounds(220, 90, 150, 25);
                comboid.setBackground(Color.WHITE);
		add(comboid);
                
                JLabel l2 = new JLabel("Number");
		l2.setBounds(30, 130, 150, 25);
		add(l2);
                
                t1 = new JTextField();
		t1.setBounds(220, 130, 150, 25);
		add(t1);
		
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(30, 170, 150, 25);
		add(lblName);
                
                labelname = new JLabel("");
		labelname.setBounds(220, 170, 150, 25);
		add(labelname);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(30, 210, 150, 25);
		add(lblGender);
                
                r1 = new JRadioButton("Male");
                r1.setFont(new Font("Raleway", Font.BOLD, 14));
                r1.setBackground(Color.WHITE);
                r1.setBounds(220, 210, 70, 25);
                add(r1);
                
                r2 = new JRadioButton("Female");
                r2.setFont(new Font("Raleway", Font.BOLD, 14));
                r2.setBackground(Color.WHITE);
                r2.setBounds(300, 210, 100, 25);
		add(r2);
                
                r3 = new JRadioButton("Other");
                r3.setFont(new Font("Raleway", Font.BOLD, 14));
                r3.setBackground(Color.WHITE);
                r3.setBounds(260, 230, 70, 25);
		add(r3);
                
                ButtonGroup bg=new ButtonGroup();   // makes radio button working depemdent on each other
                bg.add(r1);
                bg.add(r2);
                bg.add(r3);
                
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setBounds(30, 270, 150, 25);
		add(lblCountry);
                
                t3 = new JTextField();
		t3.setBounds(220, 270, 150, 25);
		add(t3);
		
		
		JLabel lbladdress = new JLabel("Permanent Address");
		lbladdress.setBounds(30, 310, 150, 25);
		add(lbladdress);
                
                t5 = new JTextField();
		t5.setBounds(220, 310, 150, 25);
		add(t5);
		
           	
		JLabel lblphone = new JLabel("Phone");
		lblphone.setBounds(30, 350, 150, 25);
		add(lblphone);
                
                t6 = new JTextField();
		t6.setBounds(220, 350, 150, 25);
		add(t6);
		
		
		JLabel lblemail = new JLabel("Email");
		lblemail.setBounds(30, 390, 150, 25);
		add(lblemail);
		
		t8 = new JTextField();
		t8.setBounds(220, 390, 150, 25);
		add(t8);
		
		
		
                try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from account where username ='"+username+"'");
                    while(rs.next()){
                        labelusername.setText(rs.getString("username"));  
                        labelname.setText(rs.getString("name"));
                    }
                }catch(Exception e){ }
		
		

		add = new JButton("Add");
		 
		add.setBounds(70, 430, 100, 25);
                add.setBackground(Color.BLACK);
                add.setForeground(Color.WHITE);
                add.addActionListener(this);
		add(add);
		
		back = new JButton("Back");
		back.setBounds(220, 430, 100, 25);
                back.setBackground(Color.BLACK);
                back.setForeground(Color.WHITE);
                back.addActionListener(this);
		add(back);
            }
                public void actionPerformed(ActionEvent ae){
                    if(ae.getSource()==add){
                        String username=labelusername.getText();
                        String id=(String)comboid.getSelectedItem();
                        String number=t1.getText();
                        String name=labelname.getText();
                        String gender=null;
                        if(r1.isSelected()){ 
                                gender = "Male";
                            }
                        else if(r2.isSelected()){ 
                                gender = "Female";
                            }
                        else{
                            gender="Other";
                        }
                        String country=t3.getText();
                        String address=t5.getText();
                        String phone=t6.getText();
                        String email=t8.getText();
                        
                        try{
                            Conn c=new Conn();
                            String query= "insert into customer values('"+username+"','"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+address+"','"+phone+"','"+email+"')";
                            c.s.executeUpdate(query);
                            JOptionPane.showMessageDialog(null,"Customer details added successfully");
                            setVisible(false);
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                        
                    }else{
                        setVisible(false);
                    }
                }
                
	
}
