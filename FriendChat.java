import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class FriendChat extends Chat{
    public FriendChat(int ID, String name){
        super(2, ID, name);//Capacity is only 2 for the friend chat
    }

    public void getChat(Object obj, JPanel panel){
        final int NEEDED = 4;
        int count = 0;
        Account acc = (Account)obj; //Object refers to account here
        panel.removeAll();//Remove old contents before getting the newest messages;
        panel.setLayout(new GridLayout(0, 1));

        try{
            Statement st = MainManager.db.getCon().createStatement();
            //rs will iterate through where receiverID is the activitiesId and type = true which indicates it being activityChat
            ResultSet rs = st.executeQuery("SELECT * FROM messages WHERE (NOT type) AND ((receiverID = %d AND senderID = %d) OR (senderID = %d AND receiverID = %d))".formatted(acc.getID(), MainManager.user.getID(), acc.getID(), MainManager.user.getID()));

            while(rs.next()){
                //For every iteration, we find the sender account according to senderID
                int senderID = rs.getInt("senderID");
                //Account is find below
                Account sender = null;
                for(Account account : MainManager.allAccounts){
                    if(account.getID() == senderID){
                        sender = account;
                        break;
                    }
                }

                Message msg = new Message(rs.getInt("messageID"),
                                          rs.getString("message"),
                                          sender, 
                                          acc.getID(), 
                                          null, 
                                          false);

                //Preparing the displayPanel
                JPanel panelDisp = new JPanel();
                panelDisp.setLayout(new BorderLayout());
                panelDisp.setBackground(Color.WHITE);
                //If the below is true, the message is send by the user
                if(sender.equals(MainManager.user)){ panelDisp.add(new ChatMessages(msg, sender), BorderLayout.EAST); }
                else{ panelDisp.add(new ChatMessages(msg, sender), BorderLayout.WEST); }
                panel.add(panelDisp);//Add for displaying purpose to the panel (ChatPanel)
                ++count;
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
