package Core;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Database {
    
    // lets write the doce of the database
    
    // I will pass this code to sign in and sign up page this is just a try in this class
    private Connection con;
    
    public void crateConnection()  {

    try
        {      
        String url = "jdbc:mysql://34.88.41.65:3306/BeSocial?connectTimeout=5000";
        String user = "BeSocial";
        String password = "SeKa";
        con = DriverManager.getConnection(url, user, password);
        System.out.println(con);       
        
        }
        /*catch(ClassNotFoundException ex)
        {
            Logger.getLogger(LoginAndSignUp.class.getName()).log(Level.SEVERE, null, ex);                
        }*/
        catch(SQLException ex)
        {
            Logger.getLogger(MainManager.class.getName()).log(Level.SEVERE, null, ex); 
        }
}
   public Connection getCon()
   {
       return con;
   }
    
}
