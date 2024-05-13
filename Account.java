
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.sql.*;

public class Account implements Comparable<Account>{
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

    public static Account foundUser(int search){
        int start = 0;
        int end = MainManager.allAccounts.size() - 1;

        while(start <= end){
            int mid = (start + end) / 2;

            if(MainManager.allAccounts.get(mid).getID() == search){
                return MainManager.allAccounts.get(mid);
            }
            else if(MainManager.allAccounts.get(mid).getID() > search){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return null;
    }

    Account(int userID, String userName, String userPassword, String aboutMe, String tags, String email)
    {
        this.userID = userID;
        this.userName = userName;
        this.userPassword = userPassword;
        this.aboutMe = aboutMe;
        this.tags = Tag.detectTags(this);
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
        ArrayList<Account> allAccounts = new ArrayList<Account>();
        try{
            Statement st = MainManager.db.getCon().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM account;");
            while(rs.next()){
                allAccounts.add(new Account(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
            }
        }
        
        catch(SQLException e){

        }
        for(Account acc: allAccounts){
            if(acc.userName.equals(MainManager.currUserName)){
                MainManager.user = acc;
                break;
            }
        }
        MainManager.allAccounts = allAccounts;
        MainManager.user.constructAccountRelations(MainManager.user);      
        return allAccounts;
    }

    //Use in friends pages
    public static boolean isFriend(Account isFriend){
        if(MainManager.user.getFriends().contains(isFriend)){ return true; }
        return false;
    }

    public static void addFriend(Account toAdd){
        //Send notification to toAdd --> meaning send it to database
        //From there, toAdd will be able to see this notification
        Notification.sendNotiFriend(toAdd);

        //Note:
        //Actual adding will be done whenever notification has been excepted by user toAdd
    }

    public static void removeFriend(Account toRemove){
        //We are not sending notification for removing;
        //Delete two way frienship from database, afterwards delete friend from local
        try{
            //(1)
            String st = "DELETE FROM friends WHERE userID = ? AND friendID = ?";
            PreparedStatement ps = MainManager.db.getCon().prepareStatement(st.toString());

            //Placeholders (?) are assigned values
            ps.setInt(1, toRemove.getID());
            ps.setInt(2, MainManager.user.getID());

            ps.executeUpdate();

            //(2)
            PreparedStatement ps1 = MainManager.db.getCon().prepareStatement(st.toString());

            //Placeholders (?) are assigned values
            ps1.setInt(1, MainManager.user.getID());
            ps1.setInt(2, toRemove.getID());

            ps1.executeUpdate();

            //Delete friend from local
            for(Account acc : MainManager.user.getFriends()){
                if(acc.compareTo(toRemove) == 0){
                    MainManager.user.getFriends().remove(toRemove);
                    break;
                }
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("Couldn't add the friend");
        }
    }

    public static void acceptFriendReq(Notification notification){
        try{
            //Connect the friends two way
            //(1)
            String st = "INSERT INTO friends (userID, friendID) VALUES (?, ?)";
            PreparedStatement ps = MainManager.db.getCon().prepareStatement(st.toString());

            //Placeholders (?) are assigned values
            ps.setInt(1, notification.getSenderAccount().getID());
            ps.setInt(2, notification.getReceiverAccount().getID());

            ps.executeUpdate();

            //(2)
            String st1 = "INSERT INTO friends (userID, friendID) VALUES (?, ?)";
            PreparedStatement ps1 = MainManager.db.getCon().prepareStatement(st1.toString());

            //Placeholders (?) are assigned values
            ps1.setInt(1, notification.getReceiverAccount().getID());
            ps1.setInt(2, notification.getSenderAccount().getID());

            ps1.executeUpdate();

            //Now add to local friends
            MainManager.user.getFriends().add(notification.getSenderAccount());
            MainManager.mainPage.refreshFriendsPanel();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("Couldn't add the friend");
        }

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

    public ArrayList<Account> getFriends()
    {
        return this.friends;
    }

    public void setUserName(String name)
    {
        this.userName = name;
    }
    
    public void setAboutMe(String aboutme)
    {
        this.aboutMe = aboutme;
    }
    public String getName()
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

                ActivityChat actChat = new ActivityChat(2, activity.getActivityID(), activity.getName());

                new Message(0, "AUTO: " + MainManager.user.getName() + " joined the activity", MainManager.user, activity.getActivityID(), null, true, actChat);
    
                Notification.sendNotiActivity(activity);
                //When joining, show instanteniously
                if(MainManager.mainPage.isNotiDisplayed){
                    MainManager.mainPage.getNoti().decideAction();
                    MainManager.mainPage.getNoti().decideAction();
                }
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

    //Will be used in AddRemove Friends page --> AR_Friends page
    //Will be used in YourFriends page --> Your_Friends
    public static void insertAccounts(boolean type, JPanel panelToDisplay, ArrayList<Account> accounts ,JFrame frame){
        boolean passedUser = false;//For efficiency, and also, to not add user to add remove page
        final int NEEDED = 10;

        //Remove old contents before getting the newest friends;
        panelToDisplay.removeAll();
        panelToDisplay.setLayout(new GridLayout(0, 1));

        for(Account account : accounts){
            //Set the individual panels

            JPanel panelDisp = new JPanel();
            panelDisp.setLayout(new BorderLayout());
            panelDisp.setBackground(Color.WHITE);
            if(!passedUser){
                if(account.compareTo(MainManager.user) == 0){ passedUser = true; }
                else{
                    //Fill those individual panels with single activity
                    panelDisp.add(new SearchResult(account, type, Account.isFriend(account) , frame));     
                    //Put individual panels into the main panel for display
                    panelToDisplay.add(panelDisp);
                }
            }
            else{
                //Fill those individual panels with single activity
                panelDisp.add(new SearchResult(account, type, Account.isFriend(account) , frame));      
                //Put individual panels into the main panel for display
                panelToDisplay.add(panelDisp);
            }
              
        }

        if(MainManager.user.getFriends().size() < NEEDED)
        {
            for(int i = 0 ; i < NEEDED - accounts.size() ; i++)
            {
                JPanel empty = new JPanel();
                empty.setBackground(new java.awt.Color(255, 255, 255));
                panelToDisplay.add(empty);
            }
        }

        //Lastly repaint and revalidete the panel;
        panelToDisplay.revalidate();
        panelToDisplay.repaint();

    }

    public int compareTo(Account acc){
        if(this.userID < acc.getID()){ return -1; }
        else if(this.userID == acc.getID()){ return 0; }
        return 1;
    }
}
