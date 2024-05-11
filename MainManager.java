import java.util.ArrayList;
import javax.swing.JFrame;

public class MainManager {

    public static Database db;
    public static Account user;
    public static String currUserName;
    public static ArrayList<Account> allAccounts;
    public static ArrayList<Activity>allActivities;
    public static Page mainPage;
    public static void main(String[] args){
        
        db = new Database();        
        db.crateConnection();
        
        LogIn login = new LogIn(); // Creating frame that I implement in NewJFrame class
        login.setVisible(true);
        login.pack();
        login.setLocationRelativeTo(null); //center  
        
        /* 
        user = new Account("a");
        ActivityPage actPage = new ActivityPage(new Activity(1));
        actPage.setVisible(true);  
        */
    }

    //When user logs in or signs up, all commands that will be done once are here.   
    public static void appStarter(JFrame frame)
    {
        MainManager.allActivities = Activity.getAllActivities();
        MainManager.allAccounts = Account.getAllAccounts();
        
        openMainPage(frame);
        //Adjusting the timers for retreiving new information from database
        Refresh.adjustTimers();
    }

    public static void openMainPage(JFrame frame)
    {
        Page mainPage = new Page();
        mainPage.setVisible(true);
        mainPage.pack();
        mainPage.setLocationRelativeTo(null); //center
        mainPage.setExtendedState(JFrame.MAXIMIZED_BOTH);
        MainManager.mainPage = mainPage;
        frame.dispose();

        for(Activity ac : MainManager.user.likedActivities)
        {
            System.out.println( "---------" + ac.getName());
        }

        for(Activity ac : MainManager.user.dislikedActivities)
        {
            System.out.println( "---------" + ac.getName());
        }
    }
}
