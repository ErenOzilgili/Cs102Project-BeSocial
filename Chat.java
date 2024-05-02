import java.util.ArrayList;

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

    public abstract void getChat(Object obj);
    public abstract void sendMessage(Message message);

}
