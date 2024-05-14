import java.awt.Image;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SearchResult extends javax.swing.JPanel {
    private boolean type;
    private boolean isFriend;
    private Account account;
    private JFrame frame;

    //If type = true --> friends page - Your_Friends
    //If type = false --> add remove page - AR_Friends page
    public SearchResult(Account account, boolean aType, boolean isFriend, JFrame aFrame) {
        this.type = aType;
        this.isFriend = isFriend;
        this.account = account;
        this.frame = aFrame;

        initComponents();
        addToInitComponents();

        this.setBackground(new java.awt.Color(255, 224, 202));
    }

    private void addToInitComponents()
    {
        if(type){
            button.setText("Chat");
        }
        else{
            ResultSet rs = null;
            int reciverID = 0;
            int senderID = 0;
            try{
                if(isFriend){
                    button.setText("Remove");
                }
                else{
                    Statement st = MainManager.db.getCon().createStatement();
                    rs= st.executeQuery("SELECT * FROM notifications WHERE NOT type AND (receiverID = %d OR senderID = %d)".formatted(MainManager.user.getID(), MainManager.user.getID()));
                    if(rs.next()){
                        reciverID = rs.getInt("receiverID");
                        senderID = rs.getInt("senderID");
                        if((account.getID() == reciverID) || (account.getID() == senderID)){
                            button.setText("Waiting");
                        }
                        else{
                            button.setText("Add"); 
                        }
                    }
                    else{
                        button.setText("Add"); 
                    }
                }       
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }

        }

        nameText.setText(account.getUserName());

        // TODO add your handling code here:
        //Add profile pic according to the account
        ImageIcon profilePhoto = new ImageIcon("photos/PP" +account.getID()%5 +".jpeg");
        Image ppImage = profilePhoto.getImage();
        Image newPPImg = ppImage.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        ImageIcon scaledProfileIcon = new ImageIcon(newPPImg);
        profileIconButton.setIcon(scaledProfileIcon);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        profileIconButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        nameText = new javax.swing.JTextField();
        button = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 240, 219));
        setPreferredSize(new java.awt.Dimension(400, 100));

        //profileIconButton.setText("jButton1");
        profileIconButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileIconButtonActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(0, 51, 204));
        jSeparator1.setForeground(new java.awt.Color(0, 51, 153));

        nameText.setText("jTextField1");

        button.setText("jButton2");
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(profileIconButton , javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addComponent(button, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(profileIconButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>    
    
    private void buttonActionPerformed(java.awt.event.ActionEvent evt) {                                       
        if(button.getText().equals("Remove")){
            Account.removeFriend(account);
            button.setText("Add");
        }
        else if(button.getText().equals("Add")){
            Account.addFriend(account);
            button.setText("Waiting");
        }
        else if(button.getText().equals("Chat")){
            //Opens new chat page, used in your friends page
            FriendMsgPage msgPage = new FriendMsgPage(account);
            frame.dispose();
        }
        else{}//Do nothing --> Button is on "Waiting" form
    } 

    private void profileIconButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        new ProfilePage(account , type);
        frame.dispose();
    } 

    // Variables declaration - do not modify                     
    private javax.swing.JButton button;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField nameText;
    private javax.swing.JButton profileIconButton;
    // End of variables declaration                   
}
