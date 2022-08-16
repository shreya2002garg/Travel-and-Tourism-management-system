package travel.management.system;
import java.awt.*;

import javax.swing.*;

public class Splash {
    public static void main(String[] args){
        SplashFrame f1 = new SplashFrame();
        f1.setVisible(true);
        int i;
        int x=1;
        for(i=1; i<=600; i+=12, x+=7){
            f1.setLocation(750 - ((i+x)/2), 400 - (i/2));
            f1.setSize(i+x,i-(x/3));
            try{
                Thread.sleep(10);
            }catch(Exception e){}
        }
        
    }
}
class SplashFrame extends JFrame implements Runnable{
    Thread t1;
    SplashFrame(){
        setLayout(new FlowLayout());
        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("icons/splash.jpg"));
        Image i1 = c1.getImage().getScaledInstance(1030, 500,Image.SCALE_DEFAULT);  //length,width,how to scale image
        ImageIcon i2 = new ImageIcon(i1);
        
        JLabel l1 = new JLabel(i2);
        add(l1);

        t1 = new Thread(this);
        t1.start();
    }
    public void run(){    //abstract method in runnable which we have to implement
        try{
            Thread.sleep(6000);      //after loading full image for what time it will remain on screen
            this.setVisible(false);    // after 6000 ms image will remove
            
            Login l = new Login();
            l.setVisible(true);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

