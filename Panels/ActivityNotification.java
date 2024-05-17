package Panels;
import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;

import Frames.Page;
import Notifications.Notification;

public class ActivityNotification extends javax.swing.JPanel {
    private Notification notification;
    private Page page;

    public ActivityNotification(Notification notification, Page page) {
        initComponents();

        //Set the notification belonging to this little panel
        this.page = page;
        this.notification = notification;
        addInfo(notification.getDescription());

        ImageIcon eraseIcon = new ImageIcon("photos/erase.png");
        Image eraseImage = eraseIcon.getImage(); // transform it 
        Image newEraseImage = eraseImage.getScaledInstance(15, 15,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        eraseIcon = new ImageIcon(newEraseImage);  // transform it back
        accepNotification.setIcon(eraseIcon);
    }
    
    private void addInfo(String Text){
        activityDesc.setText(Text);
    }
                      
    private void initComponents() {
        this.setBackground(new Color(215, 235, 215));

        //Set the line border
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        activityDesc = new javax.swing.JTextField();
        accepNotification = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        //accepNotification.setText("I");
        accepNotification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accepNotificationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(activityDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(accepNotification)
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(activityDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(accepNotification))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        activityDesc.setBackground(new Color(255, 224, 202));
    }// </editor-fold>                        

    private void accepNotificationActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        Notification.deleteNotification(this.notification);
        
        //First close the popup then reopen it
        page.getNoti().decideAction();
        page.getNoti().decideAction();
    }                                                 


    // Variables declaration - do not modify                     
    private javax.swing.JButton accepNotification;
    private javax.swing.JTextField activityDesc;
    // End of variables declaration                               
}

