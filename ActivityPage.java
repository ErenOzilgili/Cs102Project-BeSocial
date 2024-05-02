import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Date;

import javax.swing.JPanel;

public class ActivityPage extends javax.swing.JFrame {
    
    private Activity activity;
    private ActivityChat actChat;
    private final boolean type = true;
    
    /**
     * Creates new form ActivityPage
     */
    public ActivityPage(Activity activity){
        this.activity = activity;
        actChat = new ActivityChat(activity.getQuota(), activity.getActivityID(), activity.getName());
        initComponents();
        addToInitComponents();
        this.setVisible(true);
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
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        menuPanel = new javax.swing.JPanel();
        infoPanel = new javax.swing.JPanel();
        topPanel = new javax.swing.JPanel();
        activityNameL = new javax.swing.JLabel();
        dislikeB = new javax.swing.JButton();
        likeB = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jTextField3 = new javax.swing.JTextField();
        tagL = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        quotaL = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        placeL = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        timeL = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        dateL = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        descriptionL = new javax.swing.JLabel();
        chatPanelOuter = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        activityChatPanel = new javax.swing.JPanel();
        chatInput = new javax.swing.JTextField();
        sendMessageB = new javax.swing.JButton();
        chatPane = new javax.swing.JScrollPane();
        chatPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 204));

        menuPanel.setBackground(new java.awt.Color(0, 204, 204));
        menuPanel.setPreferredSize(new java.awt.Dimension(100, 600));

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 612, Short.MAX_VALUE)
        );

        getContentPane().add(menuPanel, java.awt.BorderLayout.WEST);

        infoPanel.setBackground(new java.awt.Color(0, 204, 153));
        infoPanel.setLayout(new java.awt.BorderLayout());

        topPanel.setOpaque(false);

        activityNameL.setBackground(new java.awt.Color(255, 255, 255));
        activityNameL.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        activityNameL.setText("Activity's Name");

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topPanelLayout.createSequentialGroup()
                .addContainerGap(500, Short.MAX_VALUE)
                .addComponent(likeB, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dislikeB, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(topPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(activityNameL)
                    .addContainerGap(291, Short.MAX_VALUE)))
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dislikeB, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(likeB, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
            .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(topPanelLayout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addComponent(activityNameL, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        infoPanel.add(topPanel, java.awt.BorderLayout.NORTH);

        jPanel1.setOpaque(false);

        jTextField3.setText("jTextField3");

        tagL.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        tagL.setText("Tag:");
        tagL.setPreferredSize(new java.awt.Dimension(120, 60));

        jTextField1.setText("jTextField1");
        jTextField1.setPreferredSize(new java.awt.Dimension(150, 50));

        quotaL.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        quotaL.setText("Quota:");
        quotaL.setPreferredSize(new java.awt.Dimension(120, 60));

        jTextField2.setText("jTextField2");
        jTextField2.setPreferredSize(new java.awt.Dimension(150, 50));

        placeL.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        placeL.setText("Place:");
        placeL.setPreferredSize(new java.awt.Dimension(120, 60));

        jTextField4.setText("jTextField4");
        jTextField4.setMinimumSize(new java.awt.Dimension(90, 30));
        jTextField4.setPreferredSize(new java.awt.Dimension(150, 50));

        timeL.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        timeL.setText("Time:");
        timeL.setPreferredSize(new java.awt.Dimension(120, 60));

        jTextField5.setText("jTextField5");
        jTextField5.setPreferredSize(new java.awt.Dimension(150, 50));

        dateL.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        dateL.setText("Date:");
        dateL.setPreferredSize(new java.awt.Dimension(120, 60));

        jTextField6.setText("jTextField6");

        jButton4.setText("Join");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tagL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(timeL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(placeL, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(quotaL, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addContainerGap(130, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timeL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(placeL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(quotaL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tagL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        infoPanel.add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setOpaque(false);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        descriptionL.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        descriptionL.setText("Description:");
        descriptionL.setPreferredSize(new java.awt.Dimension(150, 50));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(descriptionL, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(descriptionL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        infoPanel.add(jPanel2, java.awt.BorderLayout.SOUTH);

        getContentPane().add(infoPanel, java.awt.BorderLayout.CENTER);

        activityChatPanel.setBackground(new java.awt.Color(51, 255, 51));

        sendMessageB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendMessageBActionPerformed(evt);
            }
        });

        chatPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        chatPane.setPreferredSize(new java.awt.Dimension(300, 100));

        chatPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout chatPanelLayout = new javax.swing.GroupLayout(chatPanel);
        chatPanel.setLayout(chatPanelLayout);
        chatPanelLayout.setHorizontalGroup(
            chatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );
        chatPanelLayout.setVerticalGroup(
            chatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 523, Short.MAX_VALUE)
        );

        chatPane.setViewportView(chatPanel);

        javax.swing.GroupLayout activityChatPanelLayout = new javax.swing.GroupLayout(activityChatPanel);
        activityChatPanel.setLayout(activityChatPanelLayout);
        activityChatPanelLayout.setHorizontalGroup(
            activityChatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(activityChatPanelLayout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(activityChatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chatPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(activityChatPanelLayout.createSequentialGroup()
                        .addComponent(chatInput, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sendMessageB, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29))
        );
        activityChatPanelLayout.setVerticalGroup(
            activityChatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, activityChatPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(chatPane, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(activityChatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(activityChatPanelLayout.createSequentialGroup()
                        .addComponent(sendMessageB, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, activityChatPanelLayout.createSequentialGroup()
                        .addComponent(chatInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))))
        );

        javax.swing.GroupLayout chatPanelOuterLayout = new javax.swing.GroupLayout(chatPanelOuter);
        chatPanelOuter.setLayout(chatPanelOuterLayout);
        chatPanelOuterLayout.setHorizontalGroup(
            chatPanelOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chatPanelOuterLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(chatPanelOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chatPanelOuterLayout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(chatPanelOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chatPanelOuterLayout.createSequentialGroup()
                        .addComponent(activityChatPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        chatPanelOuterLayout.setVerticalGroup(
            chatPanelOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chatPanelOuterLayout.createSequentialGroup()
                .addGroup(chatPanelOuterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(chatPanelOuterLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(chatPanelOuterLayout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(activityChatPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(chatPanelOuter, java.awt.BorderLayout.EAST);

        pack();
    }// </editor-fold>                        

    private void sendMessageBActionPerformed(java.awt.event.ActionEvent evt) {                                             
        if(chatInput.getText().length() > 0){
            Message msg = new Message(0, chatInput.getText(),
                                      MainManager.user, activity.getActivityID(),
                                      null, type, actChat);
            // TODO add your handling code here:
            // Date should not be null;
        }
    }                                            
                                         
    // Variables declaration                   
    private javax.swing.JPanel activityChatPanel;
    private javax.swing.JLabel activityNameL;
    private javax.swing.JTextField chatInput;
    private javax.swing.JScrollPane chatPane;
    private javax.swing.JPanel chatPanel;
    private javax.swing.JPanel chatPanelOuter;
    private javax.swing.JLabel dateL;
    private javax.swing.JLabel descriptionL;
    private javax.swing.JButton dislikeB;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JButton likeB;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JLabel placeL;
    private javax.swing.JLabel quotaL;
    private javax.swing.JButton sendMessageB;
    private javax.swing.JLabel tagL;
    private javax.swing.JLabel timeL;
    private javax.swing.JPanel topPanel;
    // End of variables declaration                   
}

