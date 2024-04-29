import java.sql.*;

public class Notification {
    
    private static enum Type{
        ACTIVITY, FRIEND;
    }
    private int notID;
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

}
