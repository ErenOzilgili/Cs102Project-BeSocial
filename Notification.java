import java.sql.*;

public class Notification {
    
    private static enum Type{
        ACTIVITY, FRIEND;
    }
    private int notiID;
    private Type type;
    private String description;
    private Account senderAccount;
    private Account receiverAccount;

    public Notification(){
    }

    public static void getNotification(){
        try{
            Statement stat = MainManager.db.getCon().createStatement();
            ResultSet set = stat.executeQuery("SELECT * FROM notifications WHERE receiverID=%d".formatted(MainManager.user.getID()));
            while(set.next()){
                Notification noti = new Notification();
                noti.setNotiID(set.);
                
            }
        }
        catch(SQLException ex){
            ex.getMessage();
        }
    }

    public static void deleteNotification(){
        try{

        }
    }

    public static void addNotifications(Account account, Notification noti){
        account.getNotifications().clear();
        account.getNotifications().add(noti);
    }

}
