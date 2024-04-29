
import java.util.ArrayList;
import java.sql.*;

public class Account {
    public String userName;
    private String userPassword, aboutMe;
    private int userID;
    private ArrayList<Tag> tags;
    private ArrayList<Activity> likedActivities, dislikedActivities, enrolledActivities, myActivities;
    private ArrayList<Account> friends;
    private ArrayList<Notification> notifications;
    

    Account(String userName) {
        this.userName = userName;
        likedActivities = new ArrayList<Activity>();
        dislikedActivities = new ArrayList<Activity>();
        enrolledActivities = new ArrayList<Activity>();
        myActivities = new ArrayList<Activity>();
        friends = new ArrayList<Account>();
        notifications = new ArrayList<Notification>();
        try{
            Statement st = MainManager.db.getCon().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM account WHERE username = '%s';".formatted(userName));
            this.userID = rs.getInt(1);
            this.userPassword = rs.getString(3);
            this.aboutMe = rs.getString(4);
            this.tags = Tag.detectTags(this);
        }
        catch (SQLException e) {
            System.out.println(e);
        }
        finally {
            
        }
        
    }

    public static ArrayList<Account> getAllAccounts(){
        ArrayList<Account> allAccounts = new ArrayList<Account>();
        try{
            Statement st = MainManager.db.getCon().createStatement();
            ResultSet rs = st.executeQuery("SELECT username FROM account;");
            while(rs.next()){
                allAccounts.add(new Account(rs.getString(1)));
            }
        }
        catch(SQLException e){

        }
        return allAccounts;
    }

    public ArrayList<Notification> getNotifications(){
        return notifications;
    }

    public static void login(String name){
        MainManager.allAccounts = Account.getAllAccounts();
        for(Account acc: MainManager.allAccounts){
            if(acc.userName.equals(NewJFrame.get_current_user())){
                MainManager.user = acc;
                break;
            }
        }
        MainManager.allActivities = Activity.getAllActivities();
    }

    

}
