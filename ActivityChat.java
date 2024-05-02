import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ActivityChat extends Chat {
    public ActivityChat(int capacity, int ID, String name){
        super(capacity, ID, name);
    }

    public void getChat(Object obj){
        Activity act = (Activity)obj;
        try{
            Statement st = MainManager.db.getCon().createStatement();
            ResultSet rs = st.executeQuery("SELECT  FROM activities;");
            while(rs.next()){
                
            }
        }
        catch(SQLException e){

        }

    }

    public void sendMessage(Message message){
        try{
            String st = "INSERT INTO messages (messageID, receiverID, senderID, type, date, message) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = MainManager.db.getCon().prepareStatement(st.toString());

            ps.setInt(1, message.getMessageID());
            ps.setInt(2, message.getReceiverID());
            ps.setInt(3, MainManager.user.getID());
            ps.setBoolean(4, message.getType());
            ps.setDate(5, null); // TODO add your handling code here: //message.getDate();         
            ps.setString(6, message.getMessage());

            ps.executeUpdate();
        }
        catch(SQLException e){

        }

    }
    
}
