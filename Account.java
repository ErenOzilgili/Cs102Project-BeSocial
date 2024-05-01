
import java.util.ArrayList;
import java.sql.*;

public class Account {
    public String userName;
    private String userPassword, aboutMe;
    public int userID;
    private ArrayList<Tag> tags;
    private ArrayList<Activity> likedActivities, dislikedActivities, enrolledActivities, myActivities;
    private ArrayList<Account> friends;
    private ArrayList<Notification> notifications;
    

    Account(String userName) 
    {
        this.userName = userName;
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
    }

    public void constructAccountRelations(Account acc){
        likedActivities = new ArrayList<Activity>();
        dislikedActivities = new ArrayList<Activity>();
        enrolledActivities = new ArrayList<Activity>();
        myActivities = new ArrayList<Activity>();
        friends = new ArrayList<Account>();
        notifications = new ArrayList<Notification>();
        try{
            Statement st = MainManager.db.getCon().createStatement();
            ResultSet rs = st.executeQuery("SELECT friendID FROM friends WHERE userID = %d;".formatted(this.userID));
            while(rs.next()){
                int friendID = rs.getInt(1);
                for(Account act: MainManager.allAccounts){
                    if(act.userID == friendID){
                        this.friends.add(act);
                        break;
                    }
                }
            }
        }
        catch (SQLException e) {
            System.out.println(e);
        }
        try{
            Statement st = MainManager.db.getCon().createStatement();
            ResultSet rs = st.executeQuery("SELECT actID FROM enrolledActivities WHERE userID = %d;".formatted(this.userID));
            while(rs.next()){
                int activityID = rs.getInt(1);
                for(Activity act: MainManager.allActivities){
                    if(act.getActivityNo() == activityID){
                        this.enrolledActivities.add(act);
                        break;
                    }
                }
            }    
        }
        catch (SQLException e) {
            System.out.println(e);
        }
        try{
            Statement st = MainManager.db.getCon().createStatement();
            ResultSet rs = st.executeQuery("SELECT actID FROM likedActivities WHERE userID = %d;".formatted(this.userID));
            while(rs.next()){
                int activityID = rs.getInt(1);
                for(Activity act: MainManager.allActivities){
                    if(act.getActivityNo() == activityID){
                        this.likedActivities.add(act);
                        break;
                    }
                }
            }    
        }
        catch (SQLException e) {
            System.out.println(e);
        }
        try{
            Statement st = MainManager.db.getCon().createStatement();
            ResultSet rs = st.executeQuery("SELECT actID FROM dislikedActivities WHERE userID = %d;".formatted(this.userID));
            while(rs.next()){
                int activityID = rs.getInt(1);
                for(Activity act: MainManager.allActivities){
                    if(act.getActivityNo() == activityID){
                        this.dislikedActivities.add(act);
                        break;
                    }
                }
            }    
        }
        catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static ArrayList<Account> getAllAccounts()
    {
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
        for(Account acc: MainManager.allAccounts){
            if(acc.userName.equals(MainManager.currUserName)){
                MainManager.user = acc;
                break;
            }
        }
        MainManager.user.constructAccountRelations(MainManager.user);
        return allAccounts;
    }

    public ArrayList<Notification> getNotifications()
    {
        return notifications;
    }

    public int getID()
    {
        return this.userID;
    }    

}
