
 
package loginandsignup;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;


public class LoginAndSignUp {

    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        NewJFrame login = new NewJFrame(); // Creating frame that I implement in NewJFrame class
        login.setVisible(true);
        login.pack();
        login.setLocationRelativeTo(null); //center
        
        // I try to connect the databse with our java program
        
        try
        {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "03g8lal24");       
                
        }
        catch(ClassNotFoundException ex)
        {
            Logger.getLogger(LoginAndSignUp.class.getName()).log(Level.SEVERE, null, ex);                
        }
        
    }
    
}
