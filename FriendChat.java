import javax.swing.JPanel;

public class FriendChat extends Chat{

    public FriendChat(int ID, String name){
        super(2, ID, name);//Capacity is only 2 for the friend chat
    }

    public void getChat(Object obj, JPanel panel){
        Account acc = (Account)obj; //Object refers to account here


    }

    public void sendMessage(Message message){
        
    }

}
