import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;

public class ActivityPanel extends JPanel{
    
    private ArrayList<Activity> activities; 
    private JPanel holdActivivites;//These is a bigger panel where it will have a scroolbar and it will hold each individual activity.
    private JScrollPane scrollBar;//This will be added into holdActivities Panel.

    public ActivityPanel(){
        holdActivivites = new JPanel();//Larger container for individual activities. To be added into ActivityPanel(this).
        holdActivivites.setLayout(new GridLayout(0, 1));
        holdActivivites.setPreferredSize(new Dimension(300, 210));

        //Instead get from the database.
        activities = new ArrayList<Activity>();

        ArrayList<Tag> t1arrs = new ArrayList<Tag>();
        Tag t1 = new Tag("Chess");
        t1arrs.add(t1);
        Activity a1 = new Activity("Game1", "First game" ,t1arrs );

        ArrayList<Tag> t2arrs = new ArrayList<Tag>();
        Tag t2 = new Tag("Football");
        t2arrs.add(t2);
        Activity a2 = new Activity("Game2", "Second game" ,t2arrs );

        ArrayList<Tag> t3arrs = new ArrayList<Tag>();
        Tag t3 = new Tag("Basketball");
        t3arrs.add(t3);
        Activity a3 = new Activity("Game3", "Third game" ,t3arrs );

        this.activities.add(a1);
        this.activities.add(a2);
        this.activities.add(a3);
    
        //
        this.setPreferredSize(new Dimension(400, 600));
        
        for(Activity activity : activities){
            JPanel displayAct = new JPanel();//This panel is for each individual activity.
            displayAct.setPreferredSize(new Dimension(350, 200));
            displayAct.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
            displayAct.setLayout(new GridLayout(2, 2));

            //Showing the name of the activity.
            displayAct.add(new JLabel(activity.getName()));
            
            //Showing the tags.
            JPanel tagsPanel = new JPanel();
            JLabel tagsInActivity = new JLabel("Tags:");
            for(Tag tag : activity.getTags()){
                tagsInActivity.setText(tagsInActivity.getText() + "\n- " + tag.getType() + "\n" );

            }
            tagsPanel.add(tagsInActivity);
            displayAct.add(tagsPanel);

            //Under the name of the activity, we show the decription of it.
            displayAct.add(new JLabel(activity.getDescription()));

            //Like buttons are added to the displayAct panel (which holds just 1 activity).
            JPanel likeButtonsPanel = new JPanel();
            likeButtonsPanel.add(new Button("Like"));
            likeButtonsPanel.add(new Button("Dislike"));
            displayAct.add(likeButtonsPanel);

            /*
             * Add few more things as well;
             *
             */

            holdActivivites.add(displayAct);//Add one of the activities into the holdActivities panel.

        }

        scrollBar = new JScrollPane(holdActivivites);//Adding holdActivities panel into scrollBar.

        this.add(scrollBar);//Adding scrollBar to the AActivityPanel(this).

    }


}
