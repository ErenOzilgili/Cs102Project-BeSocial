import java.sql.*;

public class DBConnection {

    public static void main(String[] args) {
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
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}