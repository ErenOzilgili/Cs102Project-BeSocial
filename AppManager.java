import javax.swing.JFrame;

public class AppManager {
    
    public static void main(String[] args) {
        
        /*
         * Create the main page, this will be disposed whenever
         * we want to get into another part of the app. 
         */
        JFrame mainPageFrame = new MainPageFrame();
        mainPageFrame.setVisible(true);

    }

}
