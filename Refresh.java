import java.util.Timer;
import java.util.TimerTask;

public class Refresh{

    public static Timer t1, t2, t3, t4;
    public static TimerTask task1, task2, task3, task4;

    public static void adjustTimers(){
        int interval = 6000;

        t1 = new Timer();
        task1 = new TimerTask() {
            @Override
            public void run() {
                Refresh.renewNotis();
            } 
		};
        t1.scheduleAtFixedRate(task1, 0, interval);//Do the task1 after 0 seconds and in the time intervalvals of interval1 / 1000 seconds

        t2 = new Timer();
        task2 = new TimerTask() {
            @Override
            public void run() {
                //
            } 
		};
        t2.scheduleAtFixedRate(task2, 15, interval);//Do the task1 after 0 seconds and in the time intervalvals of interval1 / 1000 seconds

        t3 = new Timer();
        task3 = new TimerTask() {
            @Override
            public void run() {
                //
            } 
		};
        t3.scheduleAtFixedRate(task3, 30, interval);//Do the task1 after 0 seconds and in the time intervalvals of interval1 / 1000 seconds

        t4 = new Timer();
        task4 = new TimerTask() {
            @Override
            public void run() {
                //
            } 
		};
        t4.scheduleAtFixedRate(task4, 45, interval);//Do the task1 after 0 seconds and in the time intervalvals of interval1 / 1000 seconds

    }

    public static void renewNotis(){
        //We have getNotifications method in java
        //Just call the Notification.getNotification() method 
        //in a specified time interval.
        Notification.getNotification();
        System.out.println("Renew");
    }

    public static void renewChatP(){

    }

    public static void renewChatA(){

    }

    public static void renewActivities(){
        
    }

    
    
}