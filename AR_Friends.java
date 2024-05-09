import java.awt.GridLayout;

public class AR_Friends extends javax.swing.JFrame {

    /** Creates new form AR_Friends */
    public AR_Friends() {
        initComponents();
        addToInitComponents();
        
        //Set size, does not really matter since we will display this in maximized view
        this.setSize(400, 600);

    }

    private void addToInitComponents(){
        //SearchBar TextField is set to "" for start
        searchBar.setText("");


        //Panel for Display implementation example
        panelForDisplay.setLayout(new GridLayout(0, 1));
        
        for(int i = 0; i < 10; i++){
            panelForDisplay.add(new SearchResult());
        }
    }
                      
    private void initComponents() {

        wholePagePanel = new javax.swing.JPanel();
        resultsPanel = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        panelForDisplay = new javax.swing.JPanel();
        resultsText = new javax.swing.JTextField();
        search_homePanel = new javax.swing.JPanel();
        searchBar = new javax.swing.JTextField();
        searchIcon = new javax.swing.JButton();
        description = new javax.swing.JTextField();
        homeButton = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        wholePagePanel.setBackground(new java.awt.Color(0, 204, 204));
        wholePagePanel.setLayout(new java.awt.BorderLayout());

        resultsPanel.setBackground(new java.awt.Color(0, 51, 153));
        resultsPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        panelForDisplay.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelForDisplayLayout = new javax.swing.GroupLayout(panelForDisplay);
        panelForDisplay.setLayout(panelForDisplayLayout);
        panelForDisplayLayout.setHorizontalGroup(
            panelForDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 742, Short.MAX_VALUE)
        );
        panelForDisplayLayout.setVerticalGroup(
            panelForDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 679, Short.MAX_VALUE)
        );

        scrollPane.setViewportView(panelForDisplay);

        resultsText.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        resultsText.setText("Results");
        resultsText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultsTextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout resultsPanelLayout = new javax.swing.GroupLayout(resultsPanel);
        resultsPanel.setLayout(resultsPanelLayout);
        resultsPanelLayout.setHorizontalGroup(
            resultsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, resultsPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(resultsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(resultsText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrollPane))
                .addGap(19, 19, 19))
        );
        resultsPanelLayout.setVerticalGroup(
            resultsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, resultsPanelLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(resultsText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        wholePagePanel.add(resultsPanel, java.awt.BorderLayout.CENTER);

        search_homePanel.setOpaque(false);

        searchBar.setText("jTextField1");

        searchIcon.setText("jButton1");

        description.setBackground(new java.awt.Color(0, 204, 204));
        description.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        description.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        description.setText("Add / Remove Friends");
        description.setBorder(null);
        description.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descriptionActionPerformed(evt);
            }
        });

        homeButton.setText("jButton1");

        javax.swing.GroupLayout search_homePanelLayout = new javax.swing.GroupLayout(search_homePanel);
        search_homePanel.setLayout(search_homePanelLayout);
        search_homePanelLayout.setHorizontalGroup(
            search_homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(search_homePanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(search_homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(search_homePanelLayout.createSequentialGroup()
                        .addComponent(searchIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 381, Short.MAX_VALUE)
                .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        search_homePanelLayout.setVerticalGroup(
            search_homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(search_homePanelLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(search_homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(search_homePanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(search_homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        wholePagePanel.add(search_homePanel, java.awt.BorderLayout.NORTH);

        add(wholePagePanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>                        

    private void resultsTextActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void descriptionActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           


    // Variables declaration - do not modify                     
    private javax.swing.JTextField description;
    private javax.swing.JButton homeButton;
    private javax.swing.JPanel panelForDisplay;
    private javax.swing.JPanel resultsPanel;
    private javax.swing.JTextField resultsText;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTextField searchBar;
    private javax.swing.JButton searchIcon;
    private javax.swing.JPanel search_homePanel;
    private javax.swing.JPanel wholePagePanel;
    // End of variables declaration                   

}
