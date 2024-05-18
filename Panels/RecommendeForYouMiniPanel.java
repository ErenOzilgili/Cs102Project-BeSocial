package Panels;
import javax.swing.JPanel;

import Activity.Activity;
import Frames.ActivityPage;

import java.awt.event.MouseEvent;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import javax.swing.JFrame;

public class RecommendeForYouMiniPanel extends javax.swing.JPanel{
    private Activity eActivity;
    private JLabel nameLabel;
    private JPanel ePanel;
    private JFrame mainFrame;



    public RecommendeForYouMiniPanel(Activity activity , JPanel aPanel , JFrame aMainFrame){
        this.eActivity = activity;
        this.ePanel = aPanel;
        this.mainFrame = aMainFrame;

        String name = "<" + eActivity.getTag().getName() + ">";
        if(name.length()<15)
        {
            name += " ".repeat(15 - name.length());
        }
        name += eActivity.getName();
        if(name.length()<30)
        {
            name += " ".repeat(30 - name.length());
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
        ActivityPage acPage = new ActivityPage(eActivity);
    }
}
