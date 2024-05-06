import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

public class Refresh{

    public static Timer t1, t2, t3, t4;
    public static TimerTask task1, task2, task3, task4;

    public static void adjustTimers(){
        int interval = 6000;

        //Will call the method renewNotis() repeatedly
        t1 = new Timer();
        task1 = new TimerTask() {
            @Override
            public void run() {
                Refresh.renewNotis();
            } 
		};
        t1.scheduleAtFixedRate(task1, 0, interval);//Do the task1 after 0 seconds and in the time intervalvals of interval1 / 1000 seconds

        //Will call the method renewChatP() repeatedly
        /* 
        t2 = new Timer();
        task2 = new TimerTask() {
            @Override
            public void run() {
                //
            } 
		};
        t2.scheduleAtFixedRate(task2, 15, interval);//Do the task1 after 0 seconds and in the time intervalvals of interval1 / 1000 seconds
        */

        //Will call the method renewChatA() repeatedly
        /* 
        t3 = new Timer();
        task3 = new TimerTask() {
            @Override
            public void run() {
                Refresh.renewChatA();
            } 
		};
        t3.scheduleAtFixedRate(task3, 30, interval);//Do the task1 after 0 seconds and in the time intervalvals of interval1 / 1000 seconds
        */

        //Will call the method renewActivities() repeatedly
        t4 = new Timer();
        task4 = new TimerTask() {
            @Override
            public void run() {
                //
            } 
		};
        t4.scheduleAtFixedRate(task4, 45, interval);//Do the task1 after 0 seconds and in the time intervalvals of interval1 / 1000 seconds

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

    public static void renewNotis(){
        //We have getNotifications method in java
        //Just call the Notification.getNotification() method 
        //in a specified time interval.
        //Notification.getNotification();
        System.out.println("Renew");
    }

    public static void renewChatP(FriendChat chat, Account account, JPanel panel){
        System.out.println("RenewP");

        chat.getChat(account, panel);
    }

    public static void renewChatA(ActivityChat chat, Activity activity, JPanel panel){
        System.out.println("RenewA");
    
        chat.getChat(activity, panel);
    }

    public static void renewActivities(){
        
    }

    
    
}
