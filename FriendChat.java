public class FriendChat extends Chat{

    public FriendChat(int ID, String name){
        super(2, ID, name);//Capacity is only 2 for the friend chat
    }

    public void getChat(Object obj){
        Account acc = (Account)obj;


    }

    public void sendMessage(Message message){
        
    }

}
