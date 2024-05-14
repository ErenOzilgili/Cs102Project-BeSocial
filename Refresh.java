import java.sql.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

public class Refresh{

    public static Timer t1, t2, t3, t4, t5;
    public static TimerTask task1, task2, task3, task4, task5;

    public static void adjustTimers(){
        int interval = 10000;

        //Will call the method renewNotis() repeatedly
        /* 
        t1 = new Timer();
        task1 = new TimerTask() {
            @Override
            public void run() {
                Refresh.renewNotis();
            } 
		};
        t1.scheduleAtFixedRate(task1, 0, interval);//Do the task1 after 0 seconds and in the time intervalvals of interval1 / 1000 seconds
        */

        //Will call the method renewActivities() repeatedly
        t4 = new Timer();
        task4 = new TimerTask() {
            @Override
            public void run() {
                renewActivities();
            } 
		};
        t4.scheduleAtFixedRate(task4, 20, interval);//Do the task1 after 0 seconds and in the time intervalvals of interval1 / 1000 seconds

        //Will call the method renewAccounts() and renewFriends() repeatedly
        t5 = new Timer();
        task5 = new TimerTask() {
            @Override
            public void run() {
                renewAccounts();
                renewFriends();
                MainManager.mainPage.refreshFriendsPanel();
            } 
		};
        t5.scheduleAtFixedRate(task5, 30, 10000);//Do the task1 after 0 seconds and in the time intervalvals of interval1 / 1000 seconds
    }

    public static void adjustTimerForActChat(boolean isOn, ActivityChat chat, Activity activity, JPanel panel){
        if(isOn){
            t3.cancel();
            return;
        }
        //If is not on;
        t3 = new Timer();
        task3 = new TimerTask() {
            @Override
            public void run() {
                Refresh.renewChatA(chat, activity, panel);
            } 
		};
        t3.scheduleAtFixedRate(task3, 0, 10000);//Do the task1 after 0 seconds and in the time intervalvals of interval1 / 1000 seconds

    }

    public static void adjustTimerForFriendChat(boolean isOn, FriendChat chat, Account account, JPanel panel){
        if(isOn){
            t2.cancel();
            return;
        }
        //If is not on;
        t2 = new Timer();
        task2 = new TimerTask() {
            @Override
            public void run() {
                Refresh.renewChatP(chat, account, panel);
            } 
		};
        t2.scheduleAtFixedRate(task2, 0, 10000);//Do the task1 after 0 seconds and in the time intervalvals of interval1 / 1000 seconds

    }

    /* 
    public static void renewNotis(){
        //We have getNotifications method in java
        //Just call the Notification.getNotification() method 
        //in a specified time interval.
        //Notification.getNotification();
        System.out.println("RenewNotis");
    }
    */

    public static void renewChatP(FriendChat chat, Account account, JPanel panel){
        System.out.println("RenewP");

        chat.getChat(account, panel);
    }

    public static void renewChatA(ActivityChat chat, Activity activity, JPanel panel){
        System.out.println("RenewA");
    
        chat.getChat(activity, panel);
    }

    public static void renewActivities(){
        int queue = 0;
        System.out.println("RenewActivities");

        try{
            Statement st = MainManager.db.getCon().createStatement();
            //rs will iterate through where receiverID is the activitiesId and type = true which indicates it being activityChat
            ResultSet rs = st.executeQuery("SELECT current_quota, likeCount, dislikeCount FROM activities"); 

            while(rs.next()){
                int current_quota = rs.getInt("current_quota");
                int likeCount = rs.getInt("likeCount");
                int dislikeCount = rs.getInt("dislikeCount");

                MainManager.allActivities.get(queue).setCurrentQuota(current_quota);
                MainManager.allActivities.get(queue).setLikeNum(likeCount);
                MainManager.allActivities.get(queue).setDislikeNum(dislikeCount);
                queue++;
            }
        }
        catch(Exception e){}
 
        ArrayList<Activity> newestForm = Activity.getAllActivities();
        int toBeAddedFrom = MainManager.allActivities.size();
        //Add the missing newest activities
        for(int i = toBeAddedFrom; i < newestForm.size(); i++){
            Activity toAdd = newestForm.get(i);
            MainManager.allActivities.add(toAdd);
        }
    }

    public static void renewAccounts(){
        System.out.println("RenewAccounts");

        ArrayList<Account> newestForm = Account.getAllAccounts();
        int toBeAddedFrom = MainManager.allAccounts.size();
        //Add the missing newest accounts
        for(int i = toBeAddedFrom; i < newestForm.size(); i++){
            Account toAdd = newestForm.get(i);
            MainManager.allAccounts.add(toAdd);
        }
    }

    public static void renewFriends(){
        MainManager.user.getFriends().clear();
        try{
            Statement st = MainManager.db.getCon().createStatement();
            ResultSet rs = st.executeQuery("SELECT friendID FROM friends WHERE userID = %d;".formatted(MainManager.user.getID()));
            while(rs.next()){
                int friendID = rs.getInt(1);
                for(Account act: MainManager.allAccounts){
                    if(act.userID == friendID){
                        MainManager.user.getFriends().add(act);
                        break;
                    }
                }
            }
        }
        catch (SQLException e) {
            System.out.println(e);
        }

    }
    
}
