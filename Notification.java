import java.sql.*;
import java.util.ArrayList;

public class Notification {
    
    private static enum Type{
        ACTIVITY, FRIEND;
    }
    private int notiID;
    private Type type;
    private String description;
    private Account senderAccount;
    private Account receiverAccount;

    public Notification(int notiId, Type type, String description, Account senderAccount, Account receiverAccount){
        this.notiID = notiId;
        this.type = type;
        this.description = description;
        this.senderAccount = senderAccount;
        this.receiverAccount = receiverAccount;
    }

    public static void getNotification(){
        ArrayList<Notification> toAdd = new ArrayList<Notification>();

        try{
            Statement stat = MainManager.db.getCon().createStatement();
            ResultSet set = stat.executeQuery("SELECT * FROM notifications WHERE receiverID=%d".formatted(MainManager.user.getID()));
            while(set.next()){
                //Assigning values to instance variables for ne notifcation object
                int nID = set.getInt("notiID");
                Type ty = Type.valueOf(set.getString("type").toUpperCase());
                String description = set.getString("description");
                Account accS = new Account("1");
                Account accR = new Account("2");

                toAdd.add(new Notification(nID, ty, description, accS, accR));
            }
        }
        catch(SQLException ex){
            ex.getMessage();
        }

        addNotifications(MainManager.user, toAdd);
    }

    public static void deleteNotification(){
        /*
         *  try{

            }
            catch(SQLException ex){
                ex.getMessage();
            }
         */

    }

    public static void addNotifications(Account account, ArrayList<Notification> notis){
        account.getNotifications().clear();

        for(Notification noti : notis){
            account.getNotifications().add(noti);
        }
        
    }

    
}
