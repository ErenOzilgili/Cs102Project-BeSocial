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

    /* 
    public static void getNotification(){
        ArrayList<Notification> toAdd = new ArrayList<Notification>();

        try{
            Statement stat = MainManager.db.getCon().createStatement();
            ResultSet set = stat.executeQuery("SELECT * FROM notifications WHERE receiverID = %d".formatted(MainManager.user.getID()));
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
    */

    /* 
    public static void addNotifications(Account account, ArrayList<Notification> notis){
        account.getNotifications().clear();

        for(Notification noti : notis){
            account.getNotifications().add(noti);
        }
        
    }
    */

    //type column in notification table is boolean
    //if type = 1 this means it is true
    //if type = 0 this means it is false
    public static void sendNotiActivity(Activity activity){
        try{
            Statement st = MainManager.db.getCon().createStatement();
            //rs will return the row no in below way
            ResultSet rs = st.executeQuery("SELECT MAX(notiID) AS maxID FROM notifications");

            //If next is not entered, we have this as the first noti;
            int ID = 1;
            if(rs.next()){
                ID = rs.getInt("maxID") + 1; 
            }

            //Adding the notification of the enrolled activity to database;
            String stMain = "INSERT INTO notifications (notiID, type, description, senderID, receiverID) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = MainManager.db.getCon().prepareStatement(stMain.toString());

            ps.setInt(1, ID);
            ps.setBoolean(2, true);
            ps.setString(3, "Joined the activity: " + activity.getName());
            ps.setInt(4, MainManager.user.getID());
            ps.setInt(5, MainManager.user.getID());

            ps.executeUpdate();
        }
        catch(SQLException e){
            System.out.println("Couldn't send to database a noti for joined activity");
            System.out.println(e.getMessage());
        }
    }

    public static void leaveActivityNoti(Activity activity){
        try{
            Statement st = MainManager.db.getCon().createStatement();
            //rs will return the row no in below way
            ResultSet rs = st.executeQuery("SELECT MAX(notiID) AS maxID FROM notifications");

            //If next is not entered, we have this as the first noti;
            int ID = 1;
            if(rs.next()){
                ID = rs.getInt("maxID") + 1; 
            }

            //Adding the notification of the left activity to database;
            String stMain = "INSERT INTO notifications (notiID, type, description, senderID, receiverID) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = MainManager.db.getCon().prepareStatement(stMain.toString());

            ps.setInt(1, ID);
            ps.setBoolean(2, true);
            ps.setString(3, "Left the activity: " + activity.getName());
            ps.setInt(4, MainManager.user.getID());
            ps.setInt(5, MainManager.user.getID());

            ps.executeUpdate();
        }
        catch(SQLException e){
            System.out.println("Couldn't send to database a noti for joined activity");
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Notification> getNotiActivity(){
        ArrayList<Notification> notiActivity = new ArrayList<>();
        try{
            Statement st = MainManager.db.getCon().createStatement();
            //rs will iterate through where receiver is current user and will get notifications of type activity --> type = false = 0
            ResultSet rs = st.executeQuery("SELECT * FROM notifications WHERE type AND receiverID = %d".formatted(MainManager.user.getID()));

            while(rs.next()){
                int notiID = rs.getInt("notiID");
                Type type = rs.getBoolean("type") ? Type.ACTIVITY : Type.FRIEND;
                String description = rs.getString("description");

                Notification toDisplayAct = new Notification(notiID, type, description, MainManager.user, MainManager.user);
                notiActivity.add(toDisplayAct);
            }

            return notiActivity;
        }
        catch(SQLException e){
            System.out.println("Couldn't retrieve noti for joined activity");
            System.out.println(e.getMessage());
            //Return empty arrayList
            return new ArrayList<Notification>();
        }
    }

    public static void sendNotiFriend(Account friend){
        // TODO add your handling code here:
        try{
            Statement st = MainManager.db.getCon().createStatement();
            //rs will return the row no in below way
            ResultSet rs = st.executeQuery("SELECT MAX(notiID) AS maxID FROM notifications");

            //If next is not entered, we have this as the first noti;
            int ID = 1;
            if(rs.next()){
                ID = rs.getInt("maxID") + 1; 
            }

            //Adding the notification of the friend invitation
            String stMain = "INSERT INTO notifications (notiID, type, description, senderID, receiverID) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = MainManager.db.getCon().prepareStatement(stMain.toString());

            ps.setInt(1, ID);
            ps.setBoolean(2, false);
            ps.setString(3, MainManager.user.getUserName() + " wants to be your friend!");
            ps.setInt(4, MainManager.user.getID());
            ps.setInt(5, friend.getID());

            ps.executeUpdate();
        }
        catch(SQLException e){
            System.out.println("Couldn't send to database a friend noti");
            System.out.println(e.getMessage());
        }

    }

    public static ArrayList<Notification> getNotiFriend(){
        ArrayList<Notification> notiFriend = new ArrayList<>();
        try{
            Statement st = MainManager.db.getCon().createStatement();
            //rs will iterate through where receiver is current user and will get notifications of type activity --> type = true = 1
            ResultSet rs = st.executeQuery("SELECT * FROM notifications WHERE NOT type AND receiverID = %d".formatted(MainManager.user.getID()));

            while(rs.next()){
                int notiID = rs.getInt("notiID");
                Type type = rs.getBoolean("type") ? Type.ACTIVITY : Type.FRIEND;
                String description = rs.getString("description");
                Account getSender = Account.foundUser(rs.getInt("senderID"));
                
                Notification toDisplayFriend = new Notification(notiID, type, description, getSender, MainManager.user);
                notiFriend.add(toDisplayFriend);
            }

            return notiFriend;
        }
        catch(SQLException e){
            System.out.println("Couldn't retrieve noti for friend invitation");
            System.out.println(e.getMessage());
            //Return empty arrayList
            return new ArrayList<Notification>();
        }
    }

    public static void deleteNotification(Notification notification){
        try{
            //Delete the corresponding notification from database
            String st = "DELETE FROM notifications WHERE notiID = ?";
            PreparedStatement ps = MainManager.db.getCon().prepareStatement(st.toString());

            //Placeholders (?) are assigned values
            ps.setInt(1, notification.getNotiID());

            ps.executeUpdate();
        }
        catch(SQLException e){
            System.out.println("Couldn't delete the nofication");
            System.out.println(e.getMessage());
        }
    }

    public String getDescription(){ return this.description; }
    public int getNotiID(){ return this.notiID; }
    public Account getSenderAccount(){ return this.senderAccount; }
    public Account getReceiverAccount(){ return this.receiverAccount; }
    public Type getTyep(){ return this.type; }

}
