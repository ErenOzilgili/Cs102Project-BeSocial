package Chat;
import java.util.Date;

import User.Account;

public class Message{

    private int messageID;
    private String message;
    private Account sender;
    private int receiverID;//Will be pointing to activity or account
    private Date date;
    private boolean type;//If true --> activityChat -------- if false --> friendChat

    //chatID is the receiverID in the messages table in the database
    //Use while sending messages
    public Message(int messageID, String message,
                   Account sender, int receiverID,
                   Date date, boolean type, Chat chat){
        this.messageID = messageID;
        this.message = message;
        this.sender = sender;
        this.receiverID = receiverID;
        this.date = date;// TODO add your handling code here:
        this.type = type;

        sendMessage(chat);//Send it to this chat
    }

    //Use while forming a message instance for displaying the message
     public Message(int messageID, String message,
                   Account sender, int receiverID,
                   Date date, boolean type){
        this.messageID = messageID;
        this.message = message;
        this.sender = sender;
        this.receiverID = receiverID;
        this.date = date;// TODO add your handling code here:
        this.type = type;
    }



    private void sendMessage(Chat chat){
        chat.sendMessage(this);
    }

    //Getters
    public int getMessageID(){
        return this.messageID;
    }
    public int getReceiverID(){
        return this.receiverID;
    }
    public String getMessage(){
        return this.message;
    }
    public Account getSender(){
        return this.sender;
    }
    public Date getDate(){
        return this.date;
    }
    public boolean getType(){
        return this.type;
    }
}
