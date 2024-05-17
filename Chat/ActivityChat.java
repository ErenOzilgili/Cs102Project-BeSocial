package Chat;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JPanel;
import Panels.ChatMessages;
import Activity.Activity;
import Core.MainManager;
import User.Account;

public class ActivityChat extends Chat {
    public ActivityChat(int capacity, int ID, String name){
        super(capacity, ID, name);
    }

    public void getChat(Object obj, JPanel panel){
        final int NEEDED = 3;
        int count = 0;
        //Object refers to activity here
        //panel is where we will be displaying the messages
        Activity act = (Activity)obj; 
        panel.removeAll();//Remove old contents before getting the newest messages;
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
                panelDisp.setPreferredSize(new Dimension(200, 120));
                //If the below is true, the message is send by the user
                if(sender.equals(MainManager.user)){ panelDisp.add(new ChatMessages(msg, sender), BorderLayout.EAST); }
                else{ panelDisp.add(new ChatMessages(msg, sender), BorderLayout.WEST); }
                panel.add(panelDisp);//Add for displaying purpose to the panel (ChatPanel)
                count++;
            }
            for(int i = NEEDED - count; i > 0; i--){
                JPanel panelDisp = new JPanel();
                panelDisp.setLayout(new BorderLayout());
                panelDisp.setBackground(Color.WHITE);
                panelDisp.setPreferredSize(new Dimension(200, 120));
                panel.add(panelDisp);
            }
            //Lastly repaint and revalidete the panel;
            panel.revalidate();
            panel.repaint();
        }
        catch(SQLException e){

        }

    }

    public void sendMessage(Message message){
        super.sendMessage(message);
    }
    
}
