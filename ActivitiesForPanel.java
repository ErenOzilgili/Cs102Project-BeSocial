import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.sql.SQLException;
import java.sql.Statement;

import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;

public class ActivitiesForPanel extends javax.swing.JPanel {
    private Activity activity;

    public ActivitiesForPanel(Activity activity) {
        this.activity = activity; 
        initComponents();
        addToInitComponents();

        
        //Set the information specific to activity for this panel

        //Name of the activity
        nameL.setText(this.activity.getName());
        Font font = nameL.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        nameL.setFont(font.deriveFont(attributes));

        // TODO add your handling code here:
        //quotaTextField text should be in the from of 10/20; Need currentQuota
        quotaTF.setText(this.activity.getCurrQuota() + " / " + this.activity.getQuota());//Quota of the activity

        this.setVisible(true);
        this.setPreferredSize(new Dimension(275, 200));

        /*
         * 
         * 
         * JLabel label = new JLabel("Underlined Label");
            Font font = label.getFont();
            Map attributes = font.getAttributes();
            attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            label.setFont(font.deriveFont(attributes));
         */
    }

    private void addToInitComponents(){
        //Buttons
        //-------
        
        //likeB.setBackground(new java.awt.Color(255, 255,255));
        ImageIcon likePhoto = new ImageIcon("photos/indir.jpeg");
        Image likeImage = likePhoto.getImage();
        Image newlikeImage = likeImage.getScaledInstance(25,25, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(newlikeImage);
        likeB.setIcon(scaledIcon);
    
        if(MainManager.user.likedActivities.contains(this.activity))
        {
            likeB.setBackground(Color.BLUE);
        }
        else
        {
            likeB.setBackground(Color.WHITE);
        }

        ImageIcon dislikePhoto = new ImageIcon("photos/dislike.jpg");
        Image dislikeImage = dislikePhoto.getImage();
        Image newdislikeImage = dislikeImage.getScaledInstance(23,23, Image.SCALE_SMOOTH);
        ImageIcon scaleddisIcon = new ImageIcon(newdislikeImage);
        dislikeB.setIcon(scaleddisIcon);

        if(MainManager.user.dislikedActivities.contains(this.activity))
        {
            dislikeB.setBackground(Color.RED);
        }
        else
        {
            dislikeB.setBackground(Color.WHITE);
        }

        //ScrollBarUI
        descriptionSP.getVerticalScrollBar().setUI(new NewScrollBarUI());

        
    }
                          
    private void initComponents() {

        nameL = new javax.swing.JLabel();
        descriptionL = new javax.swing.JLabel();
        descriptionSP = new javax.swing.JScrollPane();
        descriptionP = new javax.swing.JPanel();
        quotaL = new javax.swing.JLabel();
        quotaTF = new javax.swing.JTextField();
        joinB = new javax.swing.JButton();
        likeB = new javax.swing.JButton();
        dislikeB = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 224, 202));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        nameL.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        nameL.setText("");
        nameL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nameLMouseClicked(evt);
            }
        });

        descriptionL.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        descriptionL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        descriptionL.setText("Description:");

        descriptionSP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        descriptionSP.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        descriptionSP.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        descriptionP.setBackground(new java.awt.Color(255,240,219));

        javax.swing.GroupLayout descriptionPLayout = new javax.swing.GroupLayout(descriptionP);
        descriptionP.setLayout(descriptionPLayout);
        descriptionPLayout.setHorizontalGroup(
            descriptionPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );
        descriptionPLayout.setVerticalGroup(
            descriptionPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 363, Short.MAX_VALUE)
        );

        descriptionSP.setViewportView(descriptionP);

        quotaL.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        quotaL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        quotaL.setText("Quota:");

        quotaTF.setEditable(false);
        quotaTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        quotaTF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        quotaTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quotaTFActionPerformed(evt);
            }
        });

        joinB.setBackground(new java.awt.Color(255,240,219));
        joinB.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        joinB.setText("Join");
        joinB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        joinB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joinBActionPerformed(evt);
            }
        });

        likeB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        likeB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                likeBActionPerformed(evt);
            }
        });

        dislikeB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        dislikeB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dislikeBActionPerformed(evt);
            }
        });

        jPanel1.setOpaque(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 78, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.setOpaque(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 78, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(joinB, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(descriptionSP, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nameL, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                                .addGap(2, 2, 2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(descriptionL, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                                .addGap(50, 50, 50)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(likeB, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dislikeB, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(quotaL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(quotaTF, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(quotaL)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(quotaTF)
                            .addComponent(descriptionL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descriptionSP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(joinB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(likeB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dislikeB, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                        .addGap(0, 5, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>                        

    private void quotaTFActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void joinBActionPerformed(java.awt.event.ActionEvent evt) {   
        //Below is added to send notification to database;
        //If not already enrolled to activity
        //send a notification
        if(!(MainManager.user.checkAlreadyInActivity(activity))){ Notification.sendNotiActivity(activity); }
        //Join the activity
        //Different situations are dealt within the method                                   
        MainManager.user.joinActivity(activity);
       
    }                                     

    private void likeBActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
        for(Activity ac : MainManager.user.likedActivities)
        {
            System.out.println(ac.getName());
        }
        if(MainManager.user.likedActivities.contains(this.activity))
        {
            likeRemove();
        }
        else
        {
            likeAdd();
            if(MainManager.user.dislikedActivities.contains(this.activity))
            {
                dislikeRemove();
            }
        }
    }                                     

    private void dislikeBActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        if(MainManager.user.dislikedActivities.contains(this.activity))
        {
            dislikeRemove();
        }
        else
        {
            dislikeAdd();
            if(MainManager.user.likedActivities.contains(this.activity))
            {
                likeRemove();
            }
        }
    }
    
    private void likeAdd()
    {
        likeB.setBackground(Color.BLUE);
        //likeB.setBorder(new EtchedBorder());
        MainManager.user.likedActivities.add(activity);
        activity.changeLikeNum(1);
        try
        {
            Statement st = MainManager.db.getCon().createStatement();
            st.execute("INSERT INTO likedActivities ( userID , actID ) VALUES ( " + MainManager.user.userID + " , " + activity.getActivityID() + " )");
            System.out.println("yoktu var oldu");
        }
        catch(SQLException e){
    }   
    }
    
    private void nameLMouseClicked(java.awt.event.MouseEvent evt) {                                   
        ActivityPage frame = new ActivityPage(activity);
        frame.setVisible(true);
    }    

    private void likeRemove()
    {
        likeB.setBackground(Color.WHITE);
        //likeB.setBorderPainted(false);
        MainManager.user.likedActivities.remove(activity);
        activity.changeLikeNum(-1);
        try
        {
            Statement st = MainManager.db.getCon().createStatement();
            st.execute("DELETE FROM likedActivities WHERE userID = " + MainManager.user.userID + " and actID = " + activity.getActivityID());
            System.out.println("vardı yok oldu");
        }
        catch(SQLException e){

        }
    }

    private void dislikeAdd()
    {
        dislikeB.setBackground(Color.RED);
        //dislikeB.setBorder(new EtchedBorder());
        MainManager.user.dislikedActivities.add(activity);
        activity.changeDislikeNum(1);
        try
        {
            Statement st = MainManager.db.getCon().createStatement();
            st.execute("INSERT INTO dislikedActivities ( activityID , userID ) VALUES ( " + activity.getActivityID() + " , " + MainManager.user.userID + " )");
            System.out.println("yoktu var oldu dis");
        }
        catch(SQLException e){

        }
    }

    private void dislikeRemove()
    {
        dislikeB.setBackground(Color.WHITE);
        //dislikeB.setBorderPainted(false);
        MainManager.user.dislikedActivities.remove(activity);
        activity.changeDislikeNum(-1);
        try
        {
            Statement st = MainManager.db.getCon().createStatement();
            st.execute("DELETE FROM dislikedActivities WHERE userID = " + MainManager.user.userID + " and activityID = " + activity.getActivityID());
            System.out.println("vardı yok oldu dis");
        }
        catch(SQLException e){

        }
    }


    // Variables declaration - do not modify                     
    private javax.swing.JLabel descriptionL;
    private javax.swing.JPanel descriptionP;
    private javax.swing.JScrollPane descriptionSP;
    private javax.swing.JButton dislikeB;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton joinB;
    private javax.swing.JButton likeB;
    private javax.swing.JLabel nameL;
    private javax.swing.JLabel quotaL;
    private javax.swing.JTextField quotaTF;
    // End of variables declaration                   
}
