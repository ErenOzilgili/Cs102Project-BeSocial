/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;

public class FriendNotification extends javax.swing.JPanel {

    private Notification notification;
    private Account sender;

    public FriendNotification(Notification notification) {
        this.notification = notification;
        sender = notification.getSenderAccount();

        initComponents();
        addToInitComponents();
    }
    
    private void addToInitComponents(){
        this.setPreferredSize(new Dimension(300, 60));
       
        //Get the description of notification
        this.jTextField1.setText(notification.getDescription());
    }
                      
    private void initComponents() {
        //Set the line border
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        deny = new javax.swing.JButton();
        accept = new javax.swing.JButton();

        jTextField1.setEditable(false);

        //jLabel1.setText("I");
        ImageIcon profilePhoto = new ImageIcon("photos/PP" +sender.getID()%5 +".jpeg");
        Image ppImage = profilePhoto.getImage();
        Image newPPImg = ppImage.getScaledInstance(20,20 , Image.SCALE_SMOOTH);
        ImageIcon scaledProfileIcon = new ImageIcon(newPPImg);
        jLabel1.setIcon(scaledProfileIcon);

        //jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        deny.setText("I");
        deny.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                denyButtonActionPerformed(evt);
            }
        });

        accept.setText("I");
        accept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(accept, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deny, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deny, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(accept, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>                        

    private void denyButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
        //Don't do anything for friend connections
        //Delete the notification;
        Notification.deleteNotification(notification);
        //Renew notification popUp instantly 
        MainManager.mainPage.getNoti().decideAction();
        MainManager.mainPage.getNoti().decideAction();
    }                                        

    private void acceptButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
        //Call the method for acceptingFriendReq
        Account.acceptFriendReq(notification);
        //Delete the notification;
        Notification.deleteNotification(notification);
        //Renew notification popUp instantly 
        MainManager.mainPage.getNoti().decideAction();
        MainManager.mainPage.getNoti().decideAction();
    }                                        


    // Variables declaration - do not modify                     
    private javax.swing.JButton deny;
    private javax.swing.JButton accept;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration                   
}
