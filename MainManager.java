public class MainManager {

    public static void main(String[] args){
        // TODO code application logic here
        
        // db = new Database1();        
        // db.crateConnection();
        DBConnection.createConnection();

        LogInFrame logIn = new LogInFrame();
        logIn.setVisible(true);
        logIn.pack();
        logIn.setLocationRelativeTo(null);
        
    }
    protected static Database1 db; 
}
