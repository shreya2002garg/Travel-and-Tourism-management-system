
package travel.management.system;

import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
    Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");  // register driver class
            c =DriverManager.getConnection("jdbc:mysql://localhost:3306/travelmanagementsystem","root","lagan123garg");  // creating connection string
            s = c.createStatement();   // creating statement
        } catch(Exception e){
            e.printStackTrace();
            
        
    }
    }  
}
