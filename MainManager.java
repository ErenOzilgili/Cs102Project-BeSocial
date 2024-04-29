import java.util.ArrayList;

public class MainManager {

    public static Database1 db; 
    public static Account user;
    public static ArrayList<Account> allUsers;
    public static ArrayList<Activity>allActivities;
    public static void main(String[] args){
        // TODO code application logic here
        
        db = new Database1();        
        db.crateConnection();
        
        NewJFrame login = new NewJFrame(); // Creating frame that I implement in NewJFrame class
        login.setVisible(true);
        login.pack();
        login.setLocationRelativeTo(null); //center
        
        // I try to connect the databse with our java program
    }


}
