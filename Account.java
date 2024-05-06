
import java.util.ArrayList;
import java.sql.*;

public class Account{
    public String userName;
    private String userPassword, aboutMe;
    public int userID;
    private ArrayList<Tag> tags;
    public ArrayList<Activity> likedActivities, dislikedActivities, enrolledActivities, myActivities;
    private ArrayList<Account> friends;
    private ArrayList<Notification> notifications;
    
    Account(String userName) 
    {
        this.userName = userName;
        try{
            Statement st = MainManager.db.getCon().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM account WHERE username = '%s';".formatted(userName));
            rs.next();
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
                    if(act.getActivityID() == activityID){
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
                    if(act.getActivityID() == activityID){
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
            ResultSet rs = st.executeQuery("SELECT activityID FROM dislikedActivities WHERE userID = %d;".formatted(this.userID));
            while(rs.next()){
                int activityID = rs.getInt(1);
                for(Activity act: MainManager.allActivities){
                    if(act.getActivityID() == activityID){
                        this.dislikedActivities.add(act);
                        break;
                    }
                }
            }    
        }
        catch (SQLException e) {
            System.out.println(e);
        }
        /* 
        try{
            Statement st = MainManager.db.getCon().createStatement();
            ResultSet rs = st.executeQuery("SELECT activityID FROM dislikedActivities WHERE userID = %d;".formatted(this.userID));
            while(rs.next()){
                int activityID = rs.getInt(1);
                for(Activity act: MainManager.allActivities){
                    if(act.getActivityID() == activityID){
                        this.dislikedActivities.add(act);
                        break;
                    }
                }
            }    
        }
        catch (SQLException e) {
            System.out.println(e);
        }
        */
    }

    public static ArrayList<Account> getAllAccounts()
    {
        MainManager.allAccounts = new ArrayList<Account>();
        try{
            Statement st = MainManager.db.getCon().createStatement();
            ResultSet rs = st.executeQuery("SELECT username FROM account;");
            while(rs.next()){
                MainManager.allAccounts.add(new Account(rs.getString(1)));
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
        return MainManager.allAccounts;
    }

    public ArrayList<Notification> getNotifications()
    {
        return notifications;
    }

    public int getID()
    {
        return this.userID;
    }    

    public String getUserName()
    {
        return this.userName;
    }

    public boolean equals(Object obj){
        Account accToCheck = (Account)obj;
        if(accToCheck.getID() == this.getID()){ return true; }
        return false;
    }

    public void leaveActivity(Activity activity)
    {
        this.enrolledActivities.remove(activity);
        for(Activity act : enrolledActivities)
        {
            System.out.println(act.getName());
        }
        try
        {
            Statement st = MainManager.db.getCon().createStatement();
            st.executeUpdate("DELETE FROM enrolledActivities WHERE userID = " + this.userID + " and actID = " + activity.getActivityID());
            System.out.println("flkhflgkjfklghl");
        }
        catch(SQLException e){

        }
    }
}
