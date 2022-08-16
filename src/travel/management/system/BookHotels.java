
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookHotels extends JFrame implements ActionListener {
    Choice c1,c2,c3;  
    JTextField tfperson,tfdays;
    JLabel labelusername,labelid,labelnumber,labelphone,labelprice;
    JButton checkprice,bookhotel,back;
    String username;
    BookHotels(String username){
        this.username=username;
        setBounds(250,100,1100,700);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        
        JLabel l1=new JLabel("Username");
        l1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l1.setBounds(40,70,100,20);
        add(l1);
        
        JLabel text = new JLabel("BOOK HOTEL");
        text.setFont(new Font("Yu Mincho", Font.BOLD, 20));
        text.setBounds(100, 10, 200, 30);
        add(text);
                
        
        labelusername=new JLabel("");
        labelusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelusername.setBounds(250,70,200,20);
        add(labelusername);
        
        JLabel select=new JLabel("Select Hotel");
        select.setFont(new Font("Tahoma", Font.PLAIN, 16));
        select.setBounds(40,110,150,20);
        add(select);
        
        c1 = new Choice();     // drop down
        c1.setBounds(250, 110, 200, 20);
        add(c1);
        try{
                    Conn c=new Conn();
                    ResultSet rs = c.s.executeQuery("select * from hotel");
                    while(rs.next()){
                        c1.add(rs.getString("name"));
                    }

                    rs.close();
                }catch(SQLException e){}

        
        JLabel l2=new JLabel("Total persons");
        l2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l2.setBounds(40,150,150,25);
        add(l2);
        
        tfperson=new JTextField("1");
        tfperson.setBounds(250,150,200,25);
        add(tfperson);
        
        JLabel l7=new JLabel("No of days");
        l7.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l7.setBounds(40,190,150,25);
        add(l7);
        
        tfdays=new JTextField("1");
        tfdays.setBounds(250,190,200,25);
        add(tfdays);
        
        JLabel l8=new JLabel("AC/Non AC");
        l8.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l8.setBounds(40,230,150,25);
        add(l8);
        
        
        c2 = new Choice();     // drop down
        c2.add("AC");
        c2.add("Non-AC");
        c2.setBounds(250, 230, 200, 20);
        add(c2);
        
        JLabel l9=new JLabel("Food included");
        l9.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l9.setBounds(40,270,150,25);
        add(l9);
        
        
        c3 = new Choice();     // drop down
        c3.add("Yes");
        c3.add("No");
        c3.setBounds(250, 270, 200, 20);
        add(c3);
        
        JLabel l3=new JLabel("id");
        l3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l3.setBounds(40,310,150,20);
        add(l3);
        
        labelid=new JLabel("");
        labelid.setBounds(250,310,200,25);
        add(labelid);
        
        JLabel l4=new JLabel("Number");
        l4.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l4.setBounds(40,350,150,25);
        add(l4);
        
        labelnumber=new JLabel("");
        labelnumber.setBounds(250,350,150,25);
        add(labelnumber);
        
        JLabel l5=new JLabel("Phone");
        l5.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l5.setBounds(40,390,150,25);
        add(l5);
        
        labelphone=new JLabel("");
        labelphone.setBounds(250,390,200,25);
        add(labelphone);
        
        JLabel l6=new JLabel("Total Price");
        l6.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l6.setBounds(40,430,150,25);
        add(l6);
        
        labelprice=new JLabel("");
        labelprice.setBounds(250,430,150,25);
        add(labelprice);
        
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/bookhotel.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 400,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel la1 = new JLabel(i2);
        la1.setBounds(500,50,500,400);
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
        checkprice.setBounds(60,490,120,25);
        checkprice.addActionListener(this);
        add(checkprice);
        
        bookhotel=new JButton("Book Hotel");
        bookhotel.setBackground(Color.BLACK);
        bookhotel.setForeground(Color.WHITE);
        bookhotel.setBounds(200,490,120,25);
        bookhotel.addActionListener(this);
        add(bookhotel);
        
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(340,490,120,25);
        back.addActionListener(this);
        add(back);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==checkprice){
            try{
                Conn c=new Conn();
                String q1 = "select * from hotel where name = '"+c1.getSelectedItem()+"'";
                ResultSet rs = c.s.executeQuery(q1);
                while(rs.next()){
                                    
                                    int cost = Integer.parseInt(rs.getString("costperperson"));
                                    int food = Integer.parseInt(rs.getString("foodincluded"));
                                    int ac = Integer.parseInt(rs.getString("acroom"));
                                    
                                    int persons = Integer.parseInt(tfperson.getText());
                                    int days = Integer.parseInt(tfdays.getText());
                                    
                                    String acprice = c2.getSelectedItem();
                                    String foodprice = c3.getSelectedItem();
                                    if(persons * days > 0) {
                                        int total = 0;
                                        total += acprice.equals("AC") ? ac : 0;
                                        total += foodprice.equals("Yes") ? food : 0;
                                        total += cost;
                                        total = total * persons * days;
                                        labelprice.setText("Rs "+total);
                                    }else{
                                        JOptionPane.showMessageDialog(null,"Please enter a valid number");
                                    }
                }                
            }    
            catch(Exception e){
                    e.printStackTrace();
            }
        }else if(ae.getSource()==bookhotel){
            try{
                Conn c=new Conn();
	    	
                                
                String q1 = "insert into bookhotel values('"+labelusername.getText()+"', '"+c1.getSelectedItem()+"', '"+tfperson.getText()+"','"+tfdays.getText()+"','"+c2.getSelectedItem()+"','"+c3.getSelectedItem()+"', '"+labelid.getText()+"', '"+labelnumber.getText()+"', '"+labelphone.getText()+"', '"+labelprice.getText()+"')";
                c.s.executeUpdate(q1);
                                
	    	JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
                setVisible(false);
            }catch(Exception ee){
	        System.out.println(ee.getMessage());
            }
                            
            
        }else{
            setVisible(false);
        }
    }
    public static void main(String []args){
        new BookHotels("shreya").setVisible(true);
    }
}



