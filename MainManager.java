import java.sql.*;

public class MainManager {

    public static void main(String[] args){
        // TODO code application logic here
        
        // db = new Database1();        
        // db.crateConnection();
        Connection con = DBConnection.createConnection();
        try (con;
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT VERSION()")) {
            
            if (rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        LogInFrame logIn = new LogInFrame();
        logIn.setVisible(true);
        logIn.pack();
        logIn.setLocationRelativeTo(null);
        
    }
    protected static Database1 db; 
}
