import javax.swing.JPanel;

import java.awt.event.MouseEvent;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import javax.swing.JButton;
import javax.swing.JFrame;

public class RecommendeForYouMiniPanel extends javax.swing.JPanel{
    private Activity eActivity;
    private JLabel nameLabel;
    private JButton leaveButton;
    private JPanel ePanel;
    private JFrame mainFrame;



    RecommendeForYouMiniPanel(Activity activity , JPanel aPanel , JFrame aMainFrame){
        this.eActivity = activity;
        this.ePanel = aPanel;
        this.mainFrame = aMainFrame;

        String name = activity.getName(); 
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

        this.leaveButton = new JButton("Join");
        leaveButton.setPreferredSize(new Dimension(70,20));
        leaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joinButtonActionPerformed();
            }
        });

        this.add(nameLabel);
        this.add(leaveButton);
    }

    private void joinButtonActionPerformed()
    {
        MainManager.user.joinActivity(eActivity);
        ePanel.remove(this);
        ePanel.revalidate();
        ePanel.repaint();
        MainManager.mainPage.updateCalendar();
    }

    private void nameLabelActionPerformed()
    {
        mainFrame.dispose();
        ActivityPage acPage = new ActivityPage(eActivity);
        //acPage.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}