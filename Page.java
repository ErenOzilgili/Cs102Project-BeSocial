import javax.swing.Popup;
import javax.swing.PopupFactory;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;


public class Page extends javax.swing.JFrame {

    /**
     * Creates new form Page
     */
    public Page() {
        initComponents();
        addToInitComponents();

        //Get all the activities from database --> Optional I (Eren) don't know
        //if we did or did not do this earlier ;
        //MainManager.allActivities = Activity.getAllActivities();

        //Load all the activities;
        Activity.insertActivities(panelToDisplay);
    }
    
    private void addToInitComponents(){
        scrollPane.getVerticalScrollBar().setUI(new NewScrollBarUI());      
        
        //profile picture adding part
        profileButton.setBackground(new java.awt.Color(255, 102, 102));
        ImageIcon profilePhoto = new ImageIcon("photos/PP2.jpeg");
        Image ppImage = profilePhoto.getImage();
        Image newPPImg = ppImage.getScaledInstance(76, 76, Image.SCALE_SMOOTH);
        ImageIcon scaledProfileIcon = new ImageIcon(newPPImg);
        profileButton.setIcon(scaledProfileIcon);

        //profileButton.setPreferredSize(new Dimension(76,76));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
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
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        profileButton = new javax.swing.JButton();
        rightPanelBottomP = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        menuPanel = new javax.swing.JPanel();

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(calendarPanel);
        calendarPanel.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(calendarLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(calendarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 201, Short.MAX_VALUE))
        );

        //add enrolled activites to a new panel
        JPanel enActivityWithScroll = new JPanel();
        JScrollPane jScrollPane2 = new JScrollPane();
        //enActivityWithScroll.setLayout(new BoxLayout(enActivityWithScroll, BoxLayout.Y_AXIS));
        enActivityWithScroll.setLayout(new GridLayout(0,1));
        enActivityWithScroll.setBorder(new LineBorder(Color.CYAN));
        for(Activity act : MainManager.user.enrolledActivities)
        {
            for(int i = 0 ; i < 4 ; i++)
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

        jTextField1.setText("jTextField1");
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

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

        jButton3.setText("jButton3");

        jButton4.setText("jButton3");

        profileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout profileSettingsPanelLayout = new javax.swing.GroupLayout(profileSettingsPanel);
        profileSettingsPanel.setLayout(profileSettingsPanelLayout);
        profileSettingsPanelLayout.setHorizontalGroup(
            profileSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profileSettingsPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(profileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, Short.MAX_VALUE)
                .addGap(36, 36, 36)
                .addGroup(profileSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(32, 32, 32))
        );
        profileSettingsPanelLayout.setVerticalGroup(
            profileSettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profileSettingsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(profileSettingsPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(profileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );

        rightPanel.add(profileSettingsPanel, java.awt.BorderLayout.NORTH);

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 224, Short.MAX_VALUE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 233, Short.MAX_VALUE)
        );

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
        menuPanel.setMinimumSize(new java.awt.Dimension(100, 600));
        menuPanel.setPreferredSize(new java.awt.Dimension(100, 600));
        menuPanel.setLayout(new java.awt.GridBagLayout());
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

    private void createActivityButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        this.dispose();
        CreateActivity.createActivity();
        
    }  

    private void profileButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
        this.dispose();
        JFrame profileFrame = new JFrame();
        profileFrame.add(new ProfilePage());
        profileFrame.pack();
        profileFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        profileFrame.setVisible(true);
        profileFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }                   

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify                     
    private javax.swing.JButton createActivityButton;
    private javax.swing.JButton profileButton;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
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
    private javax.swing.JPanel menuPanel;
    private javax.swing.JPanel middlePanel;
    private javax.swing.JPanel panelToDisplay;
    private javax.swing.JPanel profileSettingsPanel;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JPanel rightPanelBottomP;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JPanel wholePanel;
    // End of variables declaration                   
}
