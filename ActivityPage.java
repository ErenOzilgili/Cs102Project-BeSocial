import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Date;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;

public class ActivityPage extends javax.swing.JFrame {
    
    private Activity activity;
    private ActivityChat actChat;
    private final boolean type = true;
    
    /**
     * Creates new form ActivityPage
     */
    public ActivityPage(Activity activity){

        //Do assign the activity and activityChat
        this.activity = activity;
        actChat = new ActivityChat(activity.getQuota(), activity.getActivityID(), activity.getName());

        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Clear the text in the chatInput
        chatInput.setText("");

        //Set the acitivities informations
        this.activityNameL.setText(activity.getName());
        this.descriptionDesc.setText(activity.getDescription());
        this.tagDesc.setText(activity.getTag().getName());
        this.timeDesc.setText(activity.getTime().toString());
        this.dateDesc.setText(activity.getDate().toString());
        this.placeDesc.setText(activity.getPlace());

        //After everything is set
        //Adjust the aditional GUI
        addToInitComponents();

        //Refreshing
        //adjusts Timer whenever this page is on --> done below;
        //To this actChat, put the chats related to activity --> messages are displayed on chatPanel;
        Refresh.adjustTimerForActChat(false, actChat, activity, chatPanel);

        // TODO add your handling code here:
        //Whenever you exit this frame, call
        //Refresh.adjustTimerForActChat(true, actChat, activity, chatPanel);
        //in order to stop the timer for renewing activities;
    }
    
    private void addToInitComponents(){
        //Way to add the chats
        /* 
         * 
        chatPanel.setLayout(new GridLayout(5, 1));
        
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.add(new ChatMessages(), BorderLayout.WEST);
        chatPanel.add(panel);
        
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        panel2.setBackground(Color.WHITE);
        panel2.add(new ChatMessages(), BorderLayout.EAST);
        chatPanel.add(panel2);
         * 
         * 
        */
        
        //2 samples added 1 left aligned 1 right aligned
        //-----------------------------

        //home button
        ImageIcon icon = new ImageIcon("photos/25694.png");
        Image image = icon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        icon = new ImageIcon(newimg);  // transform it back
        jButton3.setIcon(icon);

        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainPageButtonActionPerformed();
            }
        });

        //profile photo
        ImageIcon ppicon = new ImageIcon("photos/PP" +MainManager.user.getID()%5 +".jpeg");
        Image ppimage = ppicon.getImage(); // transform it 
        Image newppimg = ppimage.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        ppicon = new ImageIcon(newppimg);  // transform it back
        jButton1.setIcon(ppicon);

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActivityPage.this.dispose();
                new ProfilePage(MainManager.user , false);
            }
        });

        //join button
        ImageIcon joinIcon = new ImageIcon("photos/join.png");
        Image joinImage = joinIcon.getImage(); // transform it 
        Image newJoinImg = joinImage.getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        joinIcon = new ImageIcon(newJoinImg);  // transform it back
        jButton2.setIcon(joinIcon);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MainManager.user.joinActivity(activity);
                quotaDesc.setText(activity.getCurrQuota() + " / " + activity.getQuota());
            }
        });

         //send button icon
         ImageIcon sendIcon = new ImageIcon("photos/send.png");
         Image sendImage = sendIcon.getImage(); // transform it 
         Image newSendImage = sendImage.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
         sendIcon = new ImageIcon(newSendImage);  // transform it back
         sendMessageB.setIcon(sendIcon);

        //like dislike buttons
        ImageIcon likePhoto = new ImageIcon("photos/indir.jpeg");
        Image likeImage = likePhoto.getImage();
        Image newlikeImage = likeImage.getScaledInstance(30,30, Image.SCALE_SMOOTH);
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

        likeB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                likeBActionPerformed(evt);
            }
        });

        ImageIcon dislikePhoto = new ImageIcon("photos/dislike.jpg");
        Image dislikeImage = dislikePhoto.getImage();
        Image newdislikeImage = dislikeImage.getScaledInstance(30,30, Image.SCALE_SMOOTH);
        ImageIcon scaleddisIcon = new ImageIcon(newdislikeImage);
        dislikeB.setIcon(scaleddisIcon);

        if(MainManager.user.dislikedActivities.contains(ActivityPage.this.activity))
        {
            dislikeB.setBackground(Color.RED);
        }
        else
        {
            dislikeB.setBackground(Color.WHITE);
        }

        dislikeB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dislikeBActionPerformed(evt);
            }
        });

        actChat.getChat(activity, chatPanel);

        //ScrollBar
        chatPane.getVerticalScrollBar().setUI(new NewScrollBarUI());
    }
                         
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        infoPanel = new javax.swing.JPanel();
        topPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        dateL = new javax.swing.JLabel();
        timeL = new javax.swing.JLabel();
        tagL = new javax.swing.JLabel();
        quotaL = new javax.swing.JLabel();
        placeL = new javax.swing.JLabel();
        descriptionL = new javax.swing.JLabel();
        descriptionDesc = new javax.swing.JLabel();
        timeDesc = new javax.swing.JLabel();
        tagDesc = new javax.swing.JLabel();
        quotaDesc = new javax.swing.JLabel();
        dateDesc = new javax.swing.JLabel();
        placeDesc = new javax.swing.JLabel();
        activityNameL = new javax.swing.JLabel();
        chatPanelOuter = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        activityChatPanel = new javax.swing.JPanel();
        chatInput = new javax.swing.JTextField();
        sendMessageB = new javax.swing.JButton();
        chatPane = new javax.swing.JScrollPane();
        chatPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        dislikeB = new javax.swing.JButton();
        likeB = new javax.swing.JButton();
        menuPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 204));

        jPanel1.setLayout(new java.awt.BorderLayout());

        infoPanel.setBackground(new java.awt.Color(215, 235, 215));
        infoPanel.setLayout(new java.awt.BorderLayout());

        topPanel.setOpaque(false);

        jPanel2.setOpaque(false);

        dateL.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        dateL.setText("Date:");
        dateL.setPreferredSize(new java.awt.Dimension(120, 60));

        timeL.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        timeL.setText("Time:");
        timeL.setPreferredSize(new java.awt.Dimension(120, 60));

        tagL.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        tagL.setText("Tag:");
        tagL.setPreferredSize(new java.awt.Dimension(120, 60));

        quotaL.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        quotaL.setText("Quota:");
        quotaL.setPreferredSize(new java.awt.Dimension(120, 60));

        placeL.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        placeL.setText("Place:");
        placeL.setPreferredSize(new java.awt.Dimension(120, 60));

        descriptionL.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        descriptionL.setText("Description:");

        descriptionDesc.setBackground(new java.awt.Color(204, 204, 255));
        descriptionDesc.setText(activity.getDescription());
        descriptionDesc.setOpaque(true);

        timeDesc.setBackground(new java.awt.Color(204, 204, 255));
        timeDesc.setText("timeDesc");
        timeDesc.setMaximumSize(new java.awt.Dimension(60, 30));
        timeDesc.setMinimumSize(new java.awt.Dimension(40, 20));
        timeDesc.setOpaque(true);
        timeDesc.setPreferredSize(new java.awt.Dimension(40, 20));

        tagDesc.setBackground(new java.awt.Color(204, 204, 255));
        tagDesc.setText("jLabel4");
        tagDesc.setMaximumSize(new java.awt.Dimension(60, 30));
        tagDesc.setMinimumSize(new java.awt.Dimension(40, 20));
        tagDesc.setOpaque(true);
        tagDesc.setPreferredSize(new java.awt.Dimension(40, 20));

        quotaDesc.setBackground(new java.awt.Color(204, 204, 255));
        quotaDesc.setText(activity.getCurrQuota() + " / " + activity.getQuota());
        quotaDesc.setMaximumSize(new java.awt.Dimension(60, 30));
        quotaDesc.setMinimumSize(new java.awt.Dimension(40, 20));
        quotaDesc.setName(""); // NOI18N
        quotaDesc.setOpaque(true);
        quotaDesc.setPreferredSize(new java.awt.Dimension(40, 20));

        dateDesc.setBackground(new java.awt.Color(204, 204, 255));
        dateDesc.setText("jLabel4");
        dateDesc.setMaximumSize(new java.awt.Dimension(60, 30));
        dateDesc.setMinimumSize(new java.awt.Dimension(40, 20));
        dateDesc.setOpaque(true);
        dateDesc.setPreferredSize(new java.awt.Dimension(40, 20));

        placeDesc.setBackground(new java.awt.Color(204, 204, 255));
        placeDesc.setText("jLabel4");
        placeDesc.setMaximumSize(new java.awt.Dimension(60, 30));
        placeDesc.setMinimumSize(new java.awt.Dimension(40, 20));
        placeDesc.setOpaque(true);
        placeDesc.setPreferredSize(new java.awt.Dimension(40, 20));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(placeL, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(184, 184, 184)
                        .addComponent(placeDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(descriptionDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(quotaL, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tagL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tagDesc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(quotaDesc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(timeL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(dateL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(132, 132, 132))
                                    .addComponent(descriptionL)))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(68, 68, 68)
                                    .addComponent(dateDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(timeDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dateDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(timeDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timeL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tagDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tagL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(quotaL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quotaDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(placeL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(placeDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(descriptionL, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(descriptionDesc, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addGap(26, 26, 26))
        );

        activityNameL.setBackground(new java.awt.Color(255, 255, 255));
        activityNameL.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        activityNameL.setText("Activity's Name");

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
            .addGroup(topPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(activityNameL)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(activityNameL, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        infoPanel.add(topPanel, java.awt.BorderLayout.CENTER);

        jPanel1.add(infoPanel, java.awt.BorderLayout.CENTER);

        chatPanelOuter.setBackground(new java.awt.Color(215, 235, 215));

        activityChatPanel.setBackground(new java.awt.Color(255, 255, 255));
        activityChatPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)));

        chatInput.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        sendMessageB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        sendMessageB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendMessageBActionPerformed(evt);
            }
        });

        chatPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        chatPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        chatPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        chatPane.setPreferredSize(new java.awt.Dimension(300, 100));

        chatPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout chatPanelLayout = new javax.swing.GroupLayout(chatPanel);
        chatPanel.setLayout(chatPanelLayout);
        chatPanelLayout.setHorizontalGroup(
            chatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );
        chatPanelLayout.setVerticalGroup(
            chatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 521, Short.MAX_VALUE)
        );

        chatPane.setViewportView(chatPanel);

        javax.swing.GroupLayout activityChatPanelLayout = new javax.swing.GroupLayout(activityChatPanel);
        activityChatPanel.setLayout(activityChatPanelLayout);
        activityChatPanelLayout.setHorizontalGroup(
            activityChatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(activityChatPanelLayout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(chatInput, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sendMessageB, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, activityChatPanelLayout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(chatPane, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        activityChatPanelLayout.setVerticalGroup(
            activityChatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, activityChatPanelLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(chatPane, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(activityChatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chatInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sendMessageB, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        jLabel1.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        jLabel1.setText("Chat:");

        javax.swing.GroupLayout chatPanelOuterLayout = new javax.swing.GroupLayout(chatPanelOuter);
        chatPanelOuter.setLayout(chatPanelOuterLayout);
        chatPanelOuterLayout.setHorizontalGroup(
            chatPanelOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chatPanelOuterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(chatPanelOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(activityChatPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(chatPanelOuterLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(chatPanelOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(chatPanelOuterLayout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(chatPanelOuterLayout.createSequentialGroup()
                                .addComponent(likeB, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dislikeB, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(312, 312, 312)))
                        .addGroup(chatPanelOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        chatPanelOuterLayout.setVerticalGroup(
            chatPanelOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chatPanelOuterLayout.createSequentialGroup()
                .addGroup(chatPanelOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(chatPanelOuterLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(chatPanelOuterLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(chatPanelOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dislikeB, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(likeB, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(activityChatPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jPanel1.add(chatPanelOuter, java.awt.BorderLayout.EAST);

        menuPanel.setBackground(new java.awt.Color(153, 153, 153));
        menuPanel.setPreferredSize(new java.awt.Dimension(100, 600));

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 736, Short.MAX_VALUE)
        );

        SideMenu sideMenu = new SideMenu();
        sideMenu.setActionPerformers(this);
        jPanel1.add(sideMenu, java.awt.BorderLayout.WEST);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>                        

    private void sendMessageBActionPerformed(java.awt.event.ActionEvent evt) {                                             
        if(chatInput.getText().length() > 0){
            Message msg = new Message(0, chatInput.getText(),
                                      MainManager.user, activity.getActivityID(),
                                      null, type, actChat);
            
            //Clear the text in the chatInput
            chatInput.setText("");
            //Refresh messages after sending one;
            actChat.getChat(activity, chatPanel);
            //Adjust scrollbar's position to bottom after sending message;
            // TODO add your handling code here:
            chatPane.getVerticalScrollBar().setValue(chatPane.getVerticalScrollBar().getMaximum());
            // TODO add your handling code here:
            // Get Messages
            // Date should not be null;
        }
    }      
    
    private void mainPageButtonActionPerformed()
    {
        MainManager.openMainPage(this);
        Refresh.adjustTimerForActChat(true, actChat, activity, chatPanel);
    }

    private void likeBActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:

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
            st.execute("UPDATE activities SET likeCount = " + activity.getLikeCount() + " where activityID = " + activity.getActivityID());
        }
        catch(SQLException e){
    }   
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
            st.execute("UPDATE activities SET likeCount = " + activity.getLikeCount() + " where activityID = " + activity.getActivityID());
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
            st.execute("UPDATE activities SET dislikeCount = " + activity.getDislikeCount() + " where activityID = " + activity.getActivityID());
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
            st.execute("UPDATE activities SET dislikeCount = " + activity.getDislikeCount() + " where activityID = " + activity.getActivityID());
        }
        catch(SQLException e){

        }
    }
                                                             
    // Variables declaration - do not modify                     
    private javax.swing.JPanel activityChatPanel;
    private javax.swing.JLabel activityNameL;
    private javax.swing.JTextField chatInput;
    private javax.swing.JScrollPane chatPane;
    private javax.swing.JPanel chatPanel;
    private javax.swing.JPanel chatPanelOuter;
    private javax.swing.JLabel dateDesc;
    private javax.swing.JLabel dateL;
    private javax.swing.JLabel descriptionDesc;
    private javax.swing.JLabel descriptionL;
    private javax.swing.JButton dislikeB;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton likeB;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JLabel placeDesc;
    private javax.swing.JLabel placeL;
    private javax.swing.JLabel quotaDesc;
    private javax.swing.JLabel quotaL;
    private javax.swing.JButton sendMessageB;
    private javax.swing.JLabel tagDesc;
    private javax.swing.JLabel tagL;
    private javax.swing.JLabel timeDesc;
    private javax.swing.JLabel timeL;
    private javax.swing.JPanel topPanel;
    // End of variables declaration                   
}

