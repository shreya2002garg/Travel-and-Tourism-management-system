
package travel.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Paytm extends JFrame{
    Paytm(){
        setBounds(300,100,1000,600);
        JEditorPane j = new JEditorPane();
        j.setEditable(false);   

        try {
            j.setPage("https://paytm.com/rent-payment");
        }catch (Exception e) {
            j.setContentType("text/html");
            j.setText("<html>Could not load,Error 404</html>");
        } 

        JScrollPane scrollPane = new JScrollPane(j);     
        
        getContentPane().add(scrollPane);

        
        JButton back=new JButton("Back");
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        back.setBounds(610, 20, 80, 40);
        j.add(back);
        
        
        
    }
    public static void main(String[] args){
        new Paytm().setVisible(true);
    }
}


