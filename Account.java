
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import java.sql.*;

public class Account{
    public String userName;
    public String userPassword, aboutMe;
    public int userID;
    public ArrayList<Tag> tags;
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
        activity.changeCurrQuota(-1);
        for(Activity act : enrolledActivities)
        {
            System.out.println(act.getName());
        }
        try
        {
            Statement st = MainManager.db.getCon().createStatement();
            st.execute("DELETE FROM enrolledActivities WHERE userID = " + this.userID + " and actID = " + activity.getActivityID());
            st.execute("UPDATE activities SET current_quota = " + activity.getCurrQuota() + " where activityID = " + activity.getActivityID());
            System.out.println("flkhflgkjfklghl");
        }
        catch(SQLException e){

        }
    }

    public boolean checkAlreadyInActivity(Activity activity){
        if(this.enrolledActivities.contains(activity))
        return true;
        //Else
        return false;
    }

    public void joinActivity(Activity activity)
    {
        if(checkAlreadyInActivity(activity))
        {
            JOptionPane.showMessageDialog(MainManager.mainPage, "You are already in this activity.", "Can not join!", JOptionPane.WARNING_MESSAGE);
        }
        else if(activity.getCurrQuota() >= activity.getQuota())
        {
            JOptionPane.showMessageDialog(MainManager.mainPage, "This activity's quota is full. Try another options:)", "Can not join!", JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            this.enrolledActivities.add(activity);
            activity.changeCurrQuota(1);
            try
            {
                Statement st1 = MainManager.db.getCon().createStatement();
                st1.execute("INSERT INTO enrolledActivities (userID , actID) VALUES ("+ this.getID() +","+activity.getActivityID() +")");
                Statement st2 = MainManager.db.getCon().createStatement();
                st2.execute("UPDATE activities SET current_quota = " + activity.getCurrQuota() + " where activityID = " + activity.getActivityID());
                System.out.println("flkhflgkjfklghl");
                MainManager.mainPage.updateEnrolledPanel(activity);
            }
            catch(SQLException e){

            }
        }
    }

    public ArrayList<Activity> getRecommendedActivities()
    {
       ArrayList<Activity> temp = new ArrayList<Activity>();
       for(Activity act: MainManager.allActivities)
       {
           temp.add(act);
       } 
       for(Activity act: enrolledActivities)
       {
           temp.remove(act);
       }
        for(Activity act: dislikedActivities)
        {
            temp.remove(act);
        }
       HashMap <Tag.TagType,Double> tagWeights = new HashMap<Tag.TagType,Double>();
       int total = likedActivities.size() + dislikedActivities.size();
       for(Tag.TagType tag: Tag.TagType.values())
       {
           tagWeights.put(tag, 1.0);
       }

       for(Activity act: likedActivities)
       {
           tagWeights.put(act.getTag().getType(), tagWeights.get(act.getTag().getType()) + 1.0/(total+0.001));
       }

        for(Activity act: dislikedActivities)
        {
            tagWeights.put(act.getTag().getType(), tagWeights.get(act.getTag().getType()) - 1.0/(total+0.001));
        }

        for(Tag tag: tags)
        {
            tagWeights.put(tag.getType(), tagWeights.get(tag.getType()) + 1.0);
        }

        temp.sort((a1,a2) -> {
            double score1 = a1.getPoints(tagWeights);
            double score2 = a2.getPoints(tagWeights);
            return Double.compare(score2, score1);
        });
        return temp;
    }   
}
