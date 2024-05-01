import java.util.ArrayList;
import javax.swing.JFrame;

public class MainManager {

    public static Database db;
    public static Account user;
    public static ArrayList<Account> allAccounts;
    public static ArrayList<Activity>allActivities;
    public static void main(String[] args){
        // TODO code application logic here
        
        db = new Database();        
        db.crateConnection();
        
        LogIn login = new LogIn(); // Creating frame that I implement in NewJFrame class
        login.setVisible(true);
        login.pack();
        login.setLocationRelativeTo(null); //center

        //Adjusting the timers for retreiving new information from database
        Refresh.adjustTimers();
    
    }

    //When user logs in or signs up, all commands that will be done once are here.   
    public static void appStarter(JFrame frame)
    {
        MainPage mainPage = new MainPage();
        mainPage.setVisible(true);
        mainPage.pack();
        mainPage.setLocationRelativeTo(null); //center
        frame.dispose();
    }

}
