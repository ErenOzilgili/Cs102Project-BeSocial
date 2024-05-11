/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.awt.Dimension;
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
    Page page;
    NotificationPopUp panel;//NotificationPopUp panel
    
    //Add user
    public Pop(Page f){ 
        pf = new PopupFactory();
        panel = new NotificationPopUp();
        page = f;

    }
    
    public void decideAction(){
        if(!page.isNotiDisplayed){
            //Get the recent notis from database
            ArrayList<Notification> actNotis = Notification.getNotiActivity();
            ArrayList<Notification> friendNotis = Notification.getNotiFriend();

            createPopup(actNotis, friendNotis);
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

    public void determineCoordinate(){
        popup = pf.getPopup(page, panel, page.getX() + page.getWidth() + page.positionX_profileP() - 390, page.getY() + page.positionY_profileP() + 130 );
    }
    
    private void createPopup(ArrayList<Notification> actNotis, ArrayList<Notification> friendNotis){  
        final int Needed = 4;
        int count = 0;
        
        panel.getDisplayNotisP().removeAll();
        
        for(Notification toDisp : actNotis){
            panel.getDisplayNotisP().add(new ActivityNotification(toDisp));
            ++count;
        }
        for(Notification toDisp : friendNotis){
            panel.getDisplayNotisP().add(new FriendNotification(toDisp));
            ++count;
        }

        for(int i = Needed - count; i > 0; i--){
            JPanel toDisplay = new JPanel();
            toDisplay.setPreferredSize(new Dimension(300, 60));
            panel.getDisplayNotisP().add(toDisplay);
        }
        
        //Resolve the position issue;
        this.determineCoordinate();
        
        popup.show();//Display the pop up
    }

    
}
