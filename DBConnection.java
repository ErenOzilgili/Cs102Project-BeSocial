import java.sql.*;

public class DBConnection {

    public static Connection createConnection() 
    {
        // jdbc:mysql://34.88.41.65:3306/BeSocial?useSSL=false
        String url = "jdbc:mysql://34.88.41.65:3306/BeSocial?connectTimeout=5000";
        String user = "BeSocial";
        String password = "SeKa";
        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT VERSION()")) {
            
            if (rs.next()) {
                System.out.println(rs.getString(1));
            }
            //addUser(con);
<<<<<<< Updated upstream
            return con;
=======
>>>>>>> Stashed changes
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;

    }

    public static void addUser(Connection con)
    {
        try (Statement st = con.createStatement()) 
        {
            st.executeUpdate("INSERT INTO account (userID,username,userPassword,aboutMe,tags) VALUES (1,'aEren123','SeKa132', 'Hi! I am great.','<football><chess>');");
        } 
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}