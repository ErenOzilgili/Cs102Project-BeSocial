/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.awt.Panel;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Popup;
import javax.swing.PopupFactory;

/**
 *
 * @author ereno
 */
public class Pop{
    
    PopupFactory pf;
    Popup popup;
    MainPage page;
    NotificationPopUp panel;//NotificationPopUp panel
    
    //Add user
    public Pop(MainPage f){ 
        pf = new PopupFactory();
        panel = new NotificationPopUp();
        page = f;

    }
    
    public static void decideAction(){
        if(!page.isNotiDisplayed){
            createPopup();
            page.isNotiDisplayed = true;
        }
        else{
            closePopup();
            page.isNotiDisplayed = false;
        }
        
    }
    
    private void closePopup(){
        popup.hide();//Dispose the popup
        
    }
    
    private void createPopup(){
        
        //Panele p ye info ekle
        //---------------------
        //Databaseden gelen infoyu for loop ile ya activity notificationa Stringi koy ya da friend notificationa koy
        //Sonrasında bu panelleri ( activity notfication ve friend notification) this.panel (panel) in içine yerleştir)
        ArrayList<String> infoNoti = this.infoNoti();//Bilgiyi yukardaki gibi işle
        
        panel.getDisplayNotisP().removeAll();
        
        for(int i = 0; i < 10 ; i++){
            panel.getDisplayNotisP().add(new FriendNotification());
        }
        
        //Resolve the position issue;
        popup = pf.getPopup(page, panel, page.positionX_profileP() - 70, page.positionY_profileP() + 140 );
        
        popup.show();//Display the pop up
    }
    
    
    private ArrayList<String> infoNoti(){
        
        ArrayList<String> notiInfo = new ArrayList<String>();
        
        
        
        return notiInfo;
    }
    
}
