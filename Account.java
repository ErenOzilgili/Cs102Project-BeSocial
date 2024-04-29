
import java.util.ArrayList;
import java.sql.*;

public class Account {
    private String userName, userPassword, aboutMe;
    private int userID;
    private ArrayList<Tag> tags;
    private ArrayList<Activity> likedActivities, dislikedActivities, enrolledActivities, myActivities;
    private ArrayList<Account> friends;
    private ArrayList<Notification> notifications;
    static private Database1 db1 = new Database1();

    Account(String userName) {
        this.userName = userName;
        likedActivities = new ArrayList<Activity>();
        dislikedActivities = new ArrayList<Activity>();
        enrolledActivities = new ArrayList<Activity>();
        myActivities = new ArrayList<Activity>();
        friends = new ArrayList<Account>();
        notifications = new ArrayList<Notification>();
        try{
            Statement st = db1.getCon().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Account WHERE userName = " + this.userName);
            this.userID = rs.getInt(1);
            this.userPassword = rs.getString(3);
            this.aboutMe = rs.getString(4);
            //this.tags = Tag.detectTags(rs.getString(5));
        }
        catch (SQLException e) {
            
        }
        finally {
            
        }
        
    }

    public static void main(String[] args) {
        db1.crateConnection();
        Account a = new Account("erenOzilgili");
    }


}
