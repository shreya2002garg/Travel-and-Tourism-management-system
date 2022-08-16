
package travel.management.system;
import java.sql.*;	
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class UpdateCustomer extends JFrame implements ActionListener{
    JLabel labelusername,labelname;
    
    JTextField t1,t3,t5,t6,t8,tfid,tfgender;
    
    JButton add,back;
    public static void main(String[]args){
        new UpdateCustomer("shreya").setVisible(true);
    
    }
    public UpdateCustomer(String username) {
//		System.out.println(username);
                setBounds(450, 100, 850, 550);
                setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/updatecustomer.png"));
                Image i3 = i1.getImage().getScaledInstance(400, 520,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l1 = new JLabel(i2);
                l1.setBounds(400,100,450,520);
                add(l1);
		
		JLabel text = new JLabel("UPDATE CUSTOMER DETAILS");
		text.setFont(new Font("Tahoma", Font.BOLD, 25));
		text.setBounds(50, 0, 400, 25);
		add(text);
                
                JLabel l3 = new JLabel("Username");
		l3.setBounds(30, 50, 150, 25);
		add(l3);
                
                labelusername = new JLabel("");
		labelusername.setBounds(220, 50, 150, 25);
		add(labelusername);
                
               
                JLabel lblId = new JLabel("ID");
		lblId.setBounds(30, 90, 150, 25);
		add(lblId);
                
                tfid = new JTextField();
		tfid.setBounds(220, 90, 150, 25);
		add(tfid);
                
                
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
                
                tfgender = new JTextField();
		tfgender.setBounds(220, 210, 150, 25);
		add(tfgender);
                
                
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
                    ResultSet rs = c.s.executeQuery("select * from customer where username ='"+username+"'");
                    while(rs.next()){
                        labelusername.setText(rs.getString("username"));  
                        labelname.setText(rs.getString("name"));
                        tfid.setText(rs.getString("id"));
                        t1.setText(rs.getString("number"));
                        tfgender.setText(rs.getString("gender"));
                        t3.setText(rs.getString("country"));
                        t5.setText(rs.getString("address"));
                        t6.setText(rs.getString("phone"));
                        t8.setText(rs.getString("email"));
                        
                    }
                }catch(Exception e){ }
		
		

		add = new JButton("Update");
		 
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
                        String id= tfid.getText();
                        String number=t1.getText();
                        String name=labelname.getText();
                        String gender= tfgender.getText();
                        String country=t3.getText();
                        String address=t5.getText();
                        String phone=t6.getText();
                        String email=t8.getText();
                        
                        try{
                            Conn c=new Conn();
                            String query= "update  customer set username='"+username+"',id='"+id+"',number='"+number+"',name='"+name+"',gender='"+gender+"',country='"+country+"',address='"+address+"',phone='"+phone+"',email='"+email+"'";
                            c.s.executeUpdate(query);
                            JOptionPane.showMessageDialog(null,"Customer details updated successfully");
                            setVisible(false);
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                        
                    }else{
                        setVisible(false);
                    }
                }
                
}
