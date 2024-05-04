import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JPanel;

public class ActivityChat extends Chat {
    public ActivityChat(int capacity, int ID, String name){
        super(capacity, ID, name);
    }

    public void getChat(Object obj, JPanel panel){
        //Object refers to activity here
        //panel is where we will be displaying the messages
        Activity act = (Activity)obj; 
        panel.setLayout(new GridLayout(0, 1));

        try{
            Statement st = MainManager.db.getCon().createStatement();
            //rs will iterate through where receiverID is the activitiesId and type = true which indicates it being activityChat
            ResultSet rs = st.executeQuery("SELECT * FROM messages WHERE type AND receiverID = %d".formatted(act.getActivityID()));

            while(rs.next()){
                //For every iteration, we find the sender account according to senderID
                int senderID = rs.getInt("senderID");
                //Account is find below
                Account sender = null;
                for(Account acc : MainManager.allAccounts){
                    if(acc.getID() == senderID){
                        sender = acc;
                        break;
                    }
                }

                Message msg = new Message(rs.getInt("messageID"),
                                          rs.getString("message"),
                                          sender, 
                                          act.getActivityID(), 
                                          null, 
                                          true);

                //Preparing the displayPanel
                JPanel panelDisp = new JPanel();
                panelDisp.setLayout(new BorderLayout());
                panelDisp.setBackground(Color.WHITE);
                //If the below is true, the message is send by the user
                if(sender.equals(MainManager.user)){ panelDisp.add(new ChatMessages(msg, sender), BorderLayout.EAST); }
                else{ panelDisp.add(new ChatMessages(msg, sender), BorderLayout.WEST); }
                panel.add(panelDisp);//Add for displaying purpose to the panel (ChatPanel)
            }
        }
        catch(SQLException e){

        }

    }

    public void sendMessage(Message message){
        try{
            //Send message info to database
            String st = "INSERT INTO messages (messageID, receiverID, senderID, type, date, message) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = MainManager.db.getCon().prepareStatement(st.toString());

            //Placeholders (?) are assigned values
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
