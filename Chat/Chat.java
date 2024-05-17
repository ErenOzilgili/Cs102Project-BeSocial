package Chat;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JPanel;

import Core.MainManager;
import User.Account;

public abstract class Chat{
    
    private ArrayList<Account> users;
    private ArrayList<Message> messages;
    private int capacity;
    private int ID; //Points to either activity or account ID
    private String name;

    public Chat(int capacity, int ID, String name){
        this.capacity = capacity;
        this.ID = ID;
        this.name = name;
        users = new ArrayList<Account>();
        messages = new ArrayList<Message>();
    }

    public abstract void getChat(Object obj, JPanel panel);
    
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
