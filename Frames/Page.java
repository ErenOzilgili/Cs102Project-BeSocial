package Frames;
import javax.swing.Popup;
import javax.swing.PopupFactory;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Activity.Activity;
import Core.MainManager;
import Core.Refresh;
import Notifications.Pop;
import Panels.CalendarPanel;
import Panels.EnrolledActivityMiniPanel;
import Panels.FriendMiniPanel;
import Panels.NewScrollBarUI;
import Panels.RecommendeForYouMiniPanel;
import Panels.SideMenu;
import User.Account;
import Panels.RecommendeForYouMiniPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class Page extends javax.swing.JFrame {

    //Variables for notification purposes
    public boolean isNotiDisplayed;
    private Pop noti;
    private SideMenu menuPanel;

    public Page() {
        this.isNotiDisplayed = false;

        initComponents();
        addToInitComponents();

        //Load all the activities;
        Activity.insertActivities(panelToDisplay , MainManager.allActivities);
    }
    
    private void addToInitComponents(){
        //ScrollBar UI
        scrollPane.getVerticalScrollBar().setUI(new NewScrollBarUI());      
        
        //profile picture adding part
        profileButton.setBackground(new java.awt.Color(255, 102, 102));
        ImageIcon profilePhoto = new ImageIcon("photos/PP" +MainManager.user.getID()%5 +".jpeg");
        Image ppImage = profilePhoto.getImage();
        Image newPPImg = ppImage.getScaledInstance(76, 76, Image.SCALE_SMOOTH);
        ImageIcon scaledProfileIcon = new ImageIcon(newPPImg);
        profileButton.setIcon(scaledProfileIcon);

        //noti picture adding part
        //notiButton.setBackground(new java.awt.Color(255, 102, 102));
        ImageIcon notiPhoto = new ImageIcon("photos/noti2.png");
        Image notiImage = notiPhoto.getImage();
        Image newnotiImg = notiImage.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon scaledNotiIcon = new ImageIcon(newnotiImg);
        notiButton.setIcon(scaledNotiIcon);

        ImageIcon setIcon = new ImageIcon("photos/renew.png");
        Image setImage = setIcon.getImage(); // transform it 
        Image newSetImage = setImage.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        setIcon = new ImageIcon(newSetImage);  // transform it back
        renewButton.setIcon(setIcon);

        //Notifications
        noti = new Pop(this);

        //ComponenetListener to keep track of if frame has been resized or not
        this.addComponentListener(new java.awt.event.ComponentListener() {

            @Override
            public void componentResized(ComponentEvent e) {
                if(isNotiDisplayed){
                    noti.decideAction();
                    noti.decideAction();
                }
            }

            @Override
            public void componentMoved(ComponentEvent e) {
                if(isNotiDisplayed){
                    noti.decideAction();
                    noti.decideAction();
                }
            }

            @Override
            public void componentShown(ComponentEvent e) {}

            @Override
            public void componentHidden(ComponentEvent e) {}
            
        });

        //Action performed button fro settings button
        renewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                renewButtonActionPerformed(evt);
            }
        });
    }
                       
    private void initComponents() {

        wholePanel = new javax.swing.JPanel();
        mainPanel = new javax.swing.JPanel();
        leftPanel = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        calendarPanel = new javax.swing.JPanel();
        calendarLabel = new javax.swing.JLabel();
        enrolledActivityPanel = new javax.swing.JPanel();
        enrolledActivityLabel = new javax.swing.JLabel();
        middlePanel = new javax.swing.JPanel();
        searchPanel = new javax.swing.JPanel();
        createActivityButton = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        scrollPane = new javax.swing.JScrollPane();
        panelToDisplay = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        rightPanel = new javax.swing.JPanel();
        profileSettingsPanel = new javax.swing.JPanel();
        notiButton = new javax.swing.JButton();
        renewButton = new javax.swing.JButton();
        profileButton = new javax.swing.JButton();
        rightPanelBottomP = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        menuPanel = new SideMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        wholePanel.setBackground(new java.awt.Color(235, 235, 235));
        wholePanel.setLayout(new java.awt.BorderLayout());

        mainPanel.setPreferredSize(new java.awt.Dimension(1000, 600));
        mainPanel.setLayout(new java.awt.BorderLayout());

        leftPanel.setBackground(new java.awt.Color(204, 204, 255));
        leftPanel.setMaximumSize(new java.awt.Dimension(508, 1200));
        leftPanel.setMinimumSize(new java.awt.Dimension(254, 600));
        leftPanel.setPreferredSize(new java.awt.Dimension(254, 600));
        leftPanel.setRequestFocusEnabled(false);
        leftPanel.setLayout(new java.awt.BorderLayout());

        calendarPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        calendarPanel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e)
            {
                calendarFrameActionPerformed(e);
            }
        });
        calendarLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        calendarLabel.setText("Calendar");
        calendarMini = new CalendarPanel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(calendarPanel);
        calendarPanel.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(calendarLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(calendarMini , 220, 220, 220)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(calendarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(calendarMini, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addContainerGap(15, javax.swing.GroupLayout.PREFERRED_SIZE)
                )
        );

        //add enrolled activites to a new panel
        enActivityWithScroll = new JPanel();
        JScrollPane jScrollPane2 = new JScrollPane();
        enActivityWithScroll.setLayout(new GridLayout(0,1));
        enActivityWithScroll.setBorder(new LineBorder(Color.CYAN));
        for(Activity act : MainManager.user.enrolledActivities)
        {
            for(int i = 0 ; i < 1 ; i++)
            {
                enActivityWithScroll.add(new EnrolledActivityMiniPanel(act , enActivityWithScroll , this));
            }
            
        }
        jScrollPane2.setViewportView(enActivityWithScroll);

        enrolledActivityPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        enrolledActivityPanel.setPreferredSize(new java.awt.Dimension(200, 265));

        enrolledActivityLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        enrolledActivityLabel.setText("Enrolled Activities");
        enrolledActivityLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(enrolledActivityPanel);
        enrolledActivityPanel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(enrolledActivityLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(enrolledActivityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, Short.MAX_VALUE)//changed max
                .addContainerGap()//deleted variables
                )
                
        );

        jPanel8.setBackground(new Color(215, 235, 215));
        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(enrolledActivityPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                    .addComponent(calendarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(calendarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(enrolledActivityPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        leftPanel.add(jPanel8, java.awt.BorderLayout.CENTER);

        mainPanel.add(leftPanel, java.awt.BorderLayout.WEST);

        middlePanel.setBackground(new java.awt.Color(204, 255, 255));
        middlePanel.setMaximumSize(new java.awt.Dimension(800, 1200));
        middlePanel.setMinimumSize(new java.awt.Dimension(400, 600));
        middlePanel.setOpaque(false);
        middlePanel.setPreferredSize(new java.awt.Dimension(800, 1200));
        middlePanel.setRequestFocusEnabled(false);
        middlePanel.setLayout(new java.awt.BorderLayout());

        ImageIcon plusPhoto = new ImageIcon("photos/plus.png");
        Image plusImage = plusPhoto.getImage();
        plusImage = plusImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        plusPhoto = new ImageIcon(plusImage);
        createActivityButton.setIcon(plusPhoto);
        createActivityButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        createActivityButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createActivityButtonActionPerformed(evt);
            }
        });

        //jTextField1.setText("jTextField1");
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jTextField1.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                String text = jTextField1.getText();

                ArrayList<Activity> result = new ArrayList<Activity>(); 
                for(Activity ac : MainManager.allActivities)
                {
                    if(ac.getName().toLowerCase().startsWith(text.toLowerCase()))
                    {
                        result.add(ac);
                    }
                }
                Activity.insertActivities(panelToDisplay , result);
            }
        });

        //to show when there is no activity to display 
        panelToDisplay.setBackground(new Color(215, 235, 215));

        searchPanel.setBackground(new Color(215, 235, 215));
        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(createActivityButton)
                .addGap(25, 25, 25))
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createActivityButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        middlePanel.add(searchPanel, java.awt.BorderLayout.NORTH);

        scrollPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new java.awt.Dimension(300, 400));

        javax.swing.GroupLayout panelToDisplayLayout = new javax.swing.GroupLayout(panelToDisplay);
        panelToDisplay.setLayout(panelToDisplayLayout);
        panelToDisplayLayout.setHorizontalGroup(
            panelToDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 534, Short.MAX_VALUE)
        );
        panelToDisplayLayout.setVerticalGroup(
            panelToDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 701, Short.MAX_VALUE)
        );

        scrollPane.setViewportView(panelToDisplay);

        middlePanel.add(scrollPane, java.awt.BorderLayout.CENTER);

        jPanel9.setBackground(new Color(215, 235, 215));
        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        middlePanel.add(jPanel9, java.awt.BorderLayout.SOUTH);

        mainPanel.add(middlePanel, java.awt.BorderLayout.CENTER);

        rightPanel.setBackground(new java.awt.Color(153, 204, 255));
        rightPanel.setMaximumSize(new java.awt.Dimension(440, 1200));
        rightPanel.setMinimumSize(new java.awt.Dimension(220, 600));
        rightPanel.setPreferredSize(new java.awt.Dimension(220, 600));
        rightPanel.setLayout(new java.awt.BorderLayout());

        //notiButton.setText("notiButton");
        notiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notiButtonActionPerformed(evt);
            }
        });

        //renewButton.setText("notiButton");

        profileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileButtonActionPerformed(evt);
            }
        });

        profileSettingsPanel.setBackground(new Color(215, 235, 215));
        javax.swing.GroupLayout profileSettingsPanelLayout = new javax.swing.GroupLayout(profileSettingsPanel);
        profileSettingsPanel.setLayout(profileSettingsPanelLayout);
        profileSettingsPanelLayout.setHorizontalGroup(
            profileSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profileSettingsPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(profileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, Short.MAX_VALUE)
                .addGap(36, 36, 36)
                .addGroup(profileSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(notiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(renewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(32, 32, 32))
        );
        profileSettingsPanelLayout.setVerticalGroup(
            profileSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profileSettingsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(renewButton, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(notiButton, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(profileSettingsPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(profileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );

        rightPanel.add(profileSettingsPanel, java.awt.BorderLayout.NORTH);

        JLabel recommended_for_you_label = new JLabel("Recommended To You",SwingConstants.CENTER);
        JPanel recommendedActivities = new JPanel(new GridLayout(0,1));
        ArrayList<Activity> activities2 = MainManager.user.getRecommendedActivities();
        for(int i = 0; i<Math.min(5,activities2.size());i++){
            RecommendeForYouMiniPanel newPanel = new RecommendeForYouMiniPanel(activities2.get(i), recommendedActivities, this);
            recommendedActivities.add(newPanel);
        }

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(recommended_for_you_label, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
            .addComponent(recommendedActivities)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(recommended_for_you_label, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(recommendedActivities, javax.swing.GroupLayout.PREFERRED_SIZE, 205, Short.MAX_VALUE)//changed max
                .addContainerGap()//deleted variables
                )
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        //add friends to a new panel
        friendsWithScroll = new JPanel();
        JScrollPane friendScrollPane = new JScrollPane();
        friendsWithScroll.setLayout(new GridLayout(0,1));
        friendsWithScroll.setBorder(new LineBorder(Color.CYAN));
        refreshFriendsPanel();
        friendScrollPane.setViewportView(friendsWithScroll);

        JLabel friendsLabel = new JLabel();
        friendsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        friendsLabel.setText("Friends");
        friendsLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(friendsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
            .addComponent(friendScrollPane)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(friendsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(friendScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 205, Short.MAX_VALUE)//changed max
                .addContainerGap()//deleted variables
                )
        );

        rightPanelBottomP.setBackground(new Color(215, 235, 215));
        javax.swing.GroupLayout rightPanelBottomPLayout = new javax.swing.GroupLayout(rightPanelBottomP);
        rightPanelBottomP.setLayout(rightPanelBottomPLayout);
        rightPanelBottomPLayout.setHorizontalGroup(
            rightPanelBottomPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelBottomPLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(rightPanelBottomPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );
        rightPanelBottomPLayout.setVerticalGroup(
            rightPanelBottomPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelBottomPLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        rightPanel.add(rightPanelBottomP, java.awt.BorderLayout.LINE_START);

        mainPanel.add(rightPanel, java.awt.BorderLayout.EAST);

        wholePanel.add(mainPanel, java.awt.BorderLayout.CENTER);

        menuPanel.setBackground(new java.awt.Color(0, 204, 204));

        menuPanel.setActionPerformers(this);

        wholePanel.add(menuPanel, java.awt.BorderLayout.WEST);

        getContentPane().add(wholePanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>                        

    //listeners
    private void calendarFrameActionPerformed(MouseEvent evt) {                                              
        // TODO add your handling code here:
        this.dispose();
        FullScreenCalendar fullScreenCalendar = new FullScreenCalendar();
    }  

    //Listener for notifications
    private void notiButtonActionPerformed(java.awt.event.ActionEvent evt){   
        //To decide whether to show the popup or hide it;
        noti.decideAction();
    } 

    private void createActivityButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        this.dispose();
        CreateActivity.createActivity();
        
    }  

    private void profileButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
        this.dispose();
        new ProfilePage(MainManager.user , false);
    }    
    
    private void renewButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
        Refresh.renewActivities();
        Activity.insertActivities(MainManager.mainPage.getPanelToDisplay(), MainManager.allActivities);
    }                                        

    public void updateEnrolledPanel(Activity activity)
    {
        enActivityWithScroll.add(new EnrolledActivityMiniPanel(activity, enActivityWithScroll, this));
        enActivityWithScroll.revalidate();
        enActivityWithScroll.repaint();
        updateCalendar();
    }

    public void updateCalendar()
    {
        calendarMini.update();
    }

    /**
     * @param args the command line arguments
     */

    public Pop getNoti(){
        return this.noti;
    }

    public int positionX_profileP(){
        return profileSettingsPanel.getX();
    }
    
    public int positionY_profileP(){
        return profileSettingsPanel.getY();
    }

    public JPanel getPanelToDisplay()
    {
        return this.panelToDisplay;
    }

    public void clearTextArea()
    {
        this.jTextField1.setText("");
    }

    public void refreshFriendsPanel()
    {
        friendsWithScroll.removeAll();
        for(Account friend : MainManager.user.getFriends())
        {
            friendsWithScroll.add(new FriendMiniPanel(friend , friendsWithScroll , this));
        }
        friendsWithScroll.revalidate();
        friendsWithScroll.repaint();
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton createActivityButton;
    private javax.swing.JButton profileButton;
    private javax.swing.JButton notiButton;
    private javax.swing.JButton renewButton;
    private javax.swing.JLabel calendarLabel;
    private javax.swing.JLabel enrolledActivityLabel;
    private javax.swing.JPanel enrolledActivityPanel;
    private javax.swing.JPanel calendarPanel;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel middlePanel;
    private javax.swing.JPanel panelToDisplay;
    private javax.swing.JPanel profileSettingsPanel;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JPanel rightPanelBottomP;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JPanel wholePanel;
    private javax.swing.JPanel enActivityWithScroll;
    private CalendarPanel calendarMini;
    private JPanel friendsWithScroll;
    // End of variables declaration                   
}

