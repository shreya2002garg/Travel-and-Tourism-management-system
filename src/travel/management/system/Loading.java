
package travel.management.system;
import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable {
    Thread t;
    JProgressBar bar;
    String username;
    public void run(){
         try {
                for (int i = 1; i < 101; i++) {
                    int m = bar.getMaximum(); // tells max value in this case it is 100
                    int v = bar.getValue();  // tells current value
                    if (v < m) {
                        bar.setValue(bar.getValue() + 1);
                    }
                    else {
                        
//                        setVisible(false);
//                        Dashboard d = new Dashboard(username);
//                        d.setVisible(true);
                    }
                    Thread.sleep(50);
                }
                setVisible(false);
                        Dashboard d = new Dashboard(username);
                        d.setVisible(true);
            } catch (Exception e) {
		e.printStackTrace();
            }
	}
    
    Loading(String username){
        this.username=username;
        t=new Thread(this);
        setBounds(500,200,650,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel l1= new JLabel("Travel and Toursim Application");
        l1.setForeground(new Color(72, 209, 204));
        l1.setFont(new Font("Raleway", Font.BOLD, 35));
        l1.setBounds(50, 20, 600, 40);
        add(l1);
        
        bar = new JProgressBar();  // for displaying loading %
        bar.setFont(new Font("Tahoma", Font.BOLD, 12));
        bar.setStringPainted(true);   // will display 0% on bar
        bar.setBounds(150, 100, 300, 35);
        add(bar);
        
        JLabel l2= new JLabel("Loading, please wait...");
        l2.setForeground(Color.RED);
        l2.setFont(new Font("Raleway", Font.BOLD, 16));
        l2.setBounds(230, 130, 150, 30);
        add(l2);
        
        JLabel l3= new JLabel("Welcome "+username);
        l3.setForeground(Color.RED);
        l3.setFont(new Font("Raleway", Font.BOLD, 16));
        l3.setBounds(20, 310, 400, 40);
        add(l3);
        
        t.start();
        
        setVisible(true);
        
    }
    public static void main(String[]args){
        new Loading(" ");
    }
    
}
