
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Payment extends JFrame implements ActionListener{
    JButton pay,back;
    public Payment(){
        
        setLayout(null);
        setBounds(500, 100, 800, 600);
        
        JLabel label=new JLabel("Pay using Paytm");
        label.setFont(new Font("Raleway", Font.BOLD, 40));
        label.setBounds(50, 20, 350, 45);
        add(label);
        
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/payment.jpg"));
        Image i8 = i7.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel l4 = new JLabel(i9);
        l4.setBounds(0,0, 800, 600);
        add(l4);
        
        pay = new JButton("Pay");
        pay.addActionListener(this);
        pay.setBounds(420, 0, 80, 40);
        add(pay);
    
        back=new JButton("Back");
        back.addActionListener(this);
        back.setBounds(510, 0, 80, 40);
        add(back);
        
        getContentPane().setBackground(Color.WHITE);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==pay){
            setVisible(false);
            new Paytm().setVisible(true);
            
        }else{
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new Payment().setVisible(true);
    }
}
