import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;

public class ActivitiesForPanel extends javax.swing.JPanel {

    public ActivitiesForPanel() {
        initComponents();
        addToInitComponents();
        this.setVisible(true);
        this.setPreferredSize(new Dimension(275, 200));
    }
    
    private void addToInitComponents(){
        //Buttons
        //-------
        
        //LikeButton
        /*
        ImageIcon icon = new ImageIcon("indir.jpeg");
        Image img = icon.getImage() ;  
        Image newimg = img.getScaledInstance( likeB.getWidth(), likeB.getHeight(),  java.awt.Image.SCALE_SMOOTH ) ;  
        icon = new ImageIcon( newimg );
        //likeB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/mainmanager/indir.jpeg")));
        likeB.setIcon(icon);
        */ 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
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

        setBackground(new java.awt.Color(204, 255, 204));
        setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 51)));

        nameL.setText("Activity Name");

        descriptionL.setText("Description:");

        descriptionSP.setBorder(null);
        descriptionSP.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        descriptionSP.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        descriptionP.setBackground(new java.awt.Color(204, 240, 204));

        javax.swing.GroupLayout descriptionPLayout = new javax.swing.GroupLayout(descriptionP);
        descriptionP.setLayout(descriptionPLayout);
        descriptionPLayout.setHorizontalGroup(
            descriptionPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );
        descriptionPLayout.setVerticalGroup(
            descriptionPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 363, Short.MAX_VALUE)
        );

        descriptionSP.setViewportView(descriptionP);

        quotaL.setText("Quota:");

        quotaTF.setEditable(false);
        quotaTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quotaTFActionPerformed(evt);
            }
        });

        joinB.setBackground(new java.awt.Color(204, 240, 204));
        joinB.setText("Join");
        joinB.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        joinB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joinBActionPerformed(evt);
            }
        });

        likeB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                likeBActionPerformed(evt);
            }
        });

        dislikeB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dislikeBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nameL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(quotaL)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descriptionL)
                            .addComponent(descriptionSP, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(joinB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(quotaTF)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(likeB, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dislikeB, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(16, 16, 16))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameL)
                    .addComponent(quotaL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descriptionL)
                    .addComponent(quotaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(descriptionSP, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(joinB)
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(likeB, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dislikeB, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>                        

    private void quotaTFActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void joinBActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
    }                                     

    private void likeBActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
    }                                     

    private void dislikeBActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        


    // Variables declaration - do not modify                     
    private javax.swing.JLabel descriptionL;
    private javax.swing.JPanel descriptionP;
    private javax.swing.JScrollPane descriptionSP;
    private javax.swing.JButton dislikeB;
    private javax.swing.JButton joinB;
    private javax.swing.JButton likeB;
    private javax.swing.JLabel nameL;
    private javax.swing.JLabel quotaL;
    private javax.swing.JTextField quotaTF;
    // End of variables declaration                   
}