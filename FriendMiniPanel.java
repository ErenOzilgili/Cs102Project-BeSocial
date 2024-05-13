import javax.swing.JPanel;

import java.awt.event.MouseEvent;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import javax.swing.JButton;
import javax.swing.JFrame;

public class FriendMiniPanel extends JPanel {
    
    private Account friend;
    private JLabel nameLabel;
    private JPanel ePanel;
    private JFrame mainFrame;

    public FriendMiniPanel(Account aFriend , JPanel aPanel , JFrame aMainFrame)
    {
        this.friend = aFriend;
        this.ePanel = aPanel;
        this.mainFrame = aMainFrame;

        String name = "-- " + friend.getUserName(); 
        if(name.length()<20)
        {
            name += " ".repeat(20 - name.length());
        }
        this.nameLabel = new JLabel(name);
        nameLabel.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                nameLabelActionPerformed();
            }
        });

       

        this.add(nameLabel);

        
    }

    private void nameLabelActionPerformed()
    {
        mainFrame.dispose();
        FriendMsgPage frPage = new FriendMsgPage(friend);
        frPage.setLocationRelativeTo(null);
        frPage.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frPage.setVisible(true);
    }
}
