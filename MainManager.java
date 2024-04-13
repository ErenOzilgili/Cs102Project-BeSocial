public class MainManager {

    public static void main(String[] args){
        // TODO code application logic here
        
        db = new Database1();        
        db.crateConnection();
        
        javax.swing.JFrame login = new LogInFrame(); // Creating frame that I implement in LogInFrame class
        login.setVisible(true);
        login.pack();
        login.setLocationRelativeTo(null); //center
        
        // I try to connect the database with our java program
        
        
        
    }
    protected static Database1 db; 
}
