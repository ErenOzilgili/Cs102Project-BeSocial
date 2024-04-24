
//package loginandsignup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Database1 {
    
    // lets write the doce of the database
    
    // I will pass this code to sign in and sign up page this is just a try in this class
    
    private Connection con;
    
   public Database1(){


}
   public  void crateConnection()  {

    try
        {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/databaselogin", "root", "03g8lal24");       
        System.out.println(con);       
        
        }
        catch(ClassNotFoundException ex)
        {
            Logger.getLogger(LoginAndSignUp.class.getName()).log(Level.SEVERE, null, ex);                
        }
        catch(SQLException ex)
        {
            Logger.getLogger(LoginAndSignUp.class.getName()).log(Level.SEVERE, null, ex); 
        }
}
   public Connection getCon()
   {
       return con;
   }
    
}
