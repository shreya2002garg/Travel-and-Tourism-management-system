
package travel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {
    String username;
    JButton b1,b3,b2,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b4;
    public static void main(String[] args) {
        new Dashboard("").setVisible(true);
    }
    
    public Dashboard(String username) {
//        super("Travel and Tourism Management System");
	this.username = username;
//        setForeground(Color.CYAN);
        setExtendedState(JFrame.MAXIMIZED_BOTH);  // makes frame equal to length of screen
        setLayout(null); 
        
        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0,0,102));
        p1.setBounds(0,0,1600,65);
        add(p1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(70, 70,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2); 
	JLabel NewLabel = new JLabel(i3);
	NewLabel.setBounds(5, 0, 70, 70); 
        p1.add(NewLabel);
        
        JLabel heading = new JLabel("Dasboard");
        heading.setBounds(80,10,300,40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        p1.add(heading);
        
        JPanel p2=new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0,0,102));
        p2.setBounds(0,65,300,700);
        add(p2);
        
        b1=new JButton("Add Personal Details");
        b1.setBounds(0,0,300,40);
        b1.setBackground(new Color(0,0,102));
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Tahoma",Font.PLAIN,20));
        b1.addActionListener(this);
        p2.add(b1);
        
        
        
        b2=new JButton("Update Personal Details");
        b2.setBounds(0,40,300,40);
        b2.setBackground(new Color(0,0,102));
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("Tahoma",Font.PLAIN,20));
        b2.addActionListener(this);
        p2.add(b2);
        
        
        b3=new JButton("View Personal Details");
        b3.setBounds(0,80,300,40);
        b3.setBackground(new Color(0,0,102));
        b3.setForeground(Color.WHITE);
        b3.setFont(new Font("Tahoma",Font.PLAIN,20));
        b3.addActionListener(this);
        p2.add(b3);
        
        
        b4=new JButton("Delete Personal Details");
        b4.setBounds(0,120,300,40);
        b4.setBackground(new Color(0,0,102));
        b4.setForeground(Color.WHITE);
        b4.setFont(new Font("Tahoma",Font.PLAIN,20));
        b4.addActionListener(this);
        p2.add(b4);
        
        
        b5=new JButton("Check Packages");
        b5.setBounds(0,160,300,40);
        b5.setBackground(new Color(0,0,102));
        b5.setForeground(Color.WHITE);
        b5.setFont(new Font("Tahoma",Font.PLAIN,20));
        b5.addActionListener(this);
        p2.add(b5);
        
        
        b6=new JButton("Book Package");
        b6.setBounds(0,200,300,40);
        b6.setBackground(new Color(0,0,102));
        b6.setForeground(Color.WHITE);
        b6.setFont(new Font("Tahoma",Font.PLAIN,20));
        b6.addActionListener(this);
        p2.add(b6);
        
        
        b7=new JButton("View Booked Package");
        b7.setBounds(0,240,300,40);
        b7.setBackground(new Color(0,0,102));
        b7.setForeground(Color.WHITE);
        b7.addActionListener(this);
        b7.setFont(new Font("Tahoma",Font.PLAIN,20));
        p2.add(b7);
        
        
        b8=new JButton("View Hotels");
        b8.setBounds(0,280,300,40);
        b8.setBackground(new Color(0,0,102));
        b8.setForeground(Color.WHITE);
        b8.addActionListener(this);
        b8.setFont(new Font("Tahoma",Font.PLAIN,20));
        p2.add(b8);
        
        
        b9=new JButton("Book Hotel");
        b9.setBounds(0,320,300,40);
        b9.setBackground(new Color(0,0,102));
        b9.setForeground(Color.WHITE);
        b9.setFont(new Font("Tahoma",Font.PLAIN,20));
        b9.addActionListener(this);
        p2.add(b9);
        
        
        b10=new JButton("View Booked Hotel");
        b10.setBounds(0,360,300,40);
        b10.setBackground(new Color(0,0,102));
        b10.setForeground(Color.WHITE);
        b10.setFont(new Font("Tahoma",Font.PLAIN,20));
        b10.addActionListener(this);
        p2.add(b10);
        
        
        b11=new JButton("Destinations");
        b11.setBounds(0,400,300,40);
        b11.setBackground(new Color(0,0,102));
        b11.setForeground(Color.WHITE);
        b11.setFont(new Font("Tahoma",Font.PLAIN,20));
        b11.addActionListener(this);
        p2.add(b11);
        
        
        b12=new JButton("Payments");
        b12.setBounds(0,440,300,40);
        b12.setBackground(new Color(0,0,102));
        b12.setForeground(Color.WHITE);
        b12.setFont(new Font("Tahoma",Font.PLAIN,20));
        b12.addActionListener(this);
        p2.add(b12);
        
        
        b13=new JButton("Calculator");
        b13.setBounds(0,480,300,40);
        b13.setBackground(new Color(0,0,102));
        b13.setForeground(Color.WHITE);
        b13.setFont(new Font("Tahoma",Font.PLAIN,20));
        b13.addActionListener(this);
        p2.add(b13);
        
        
        b14=new JButton("Notepad");
        b14.setBounds(0,520,300,40);
        b14.setBackground(new Color(0,0,102));
        b14.setForeground(Color.WHITE);
        b14.setFont(new Font("Tahoma",Font.PLAIN,20));
        b14.addActionListener(this);
        p2.add(b14);
        
        
        b15=new JButton("About");
        b15.setBounds(0,560,300,40);
        b15.setBackground(new Color(0,0,102));
        b15.setForeground(Color.WHITE);
        b15.setFont(new Font("Tahoma",Font.PLAIN,20));
        b15.addActionListener(this);
        p2.add(b15);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1650, 1000,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5); 
	JLabel image = new JLabel(i6);
	image.setBounds(0, 0, 1650, 1000); 
        add(image);
        
        JLabel l1 = new JLabel("Travel and Tourism Management System");
	l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Raleway", Font.PLAIN, 55));
	l1.setBounds(350, 70, 1200, 70);
	image.add(l1);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            new AddCustomer(username).setVisible(true);
        }else if(ae.getSource()==b3){
            new ViewCustomer(username);
       }else if(ae.getSource()==b2){
           new UpdateCustomer(username).setVisible(true);
       }else if(ae.getSource()==b5){
           new CheckPackage();
       }else if(ae.getSource()==b6){
           new BookPackage(username).setVisible(true);
       }else if(ae.getSource()==b7){
           new ViewPackage(username).setVisible(true);
       }else if(ae.getSource()==b8){
           new CheckHotels().setVisible(true);
       }else if(ae.getSource()==b11){
           new Destinations().setVisible(true);
       }else if(ae.getSource()==b9){
           new BookHotels(username).setVisible(true);
       }else if(ae.getSource()==b10){
           new ViewBookedHotel(username).setVisible(true);
       }else if(ae.getSource()==b12){
           new Payment().setVisible(true);
       }else if(ae.getSource()==b13){
           try{
               Runtime.getRuntime().exec("calc.exe");
           }catch(Exception e){
               e.printStackTrace();
           }
        }else if(ae.getSource()==b14){
             try{
               Runtime.getRuntime().exec("notepad.exe");
            }catch(Exception e){
               e.printStackTrace();
            }
        }else if(ae.getSource()==b15){
            new About().setVisible(true);
        }else{
            new DeleteDetails(username).setVisible(true);
        }
    }
}
		
		
     
		

