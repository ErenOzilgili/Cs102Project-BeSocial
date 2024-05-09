import java.util.ArrayList;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.*;

public class Activity implements Comparable<Activity>{
    
    public static int numberOfActiveActivities;
    //Below can be changed according to preference;
    public static final Dimension appearanceSize = new Dimension(400, 300);

    private ArrayList<Tag> tags;
    private String name, place;
    private String description;
    private int activityID, quota , currQuota;
    private Date date;
    private Time time;
    private int dislikeNum;
    private int likeNum;
    private int appearanceHeight;
    private int appearanceWidth;
    private Tag tag;

    public Activity(int id){
        try{
            this.activityID = id;
            Statement st = MainManager.db.getCon().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM activities WHERE activityID = '%d';".formatted(id));
            rs.next();
            tag = new Tag(Tag.TagType.valueOf(rs.getString(2)));
            this.name = rs.getString(1);
            quota = rs.getInt(3);
            date = rs.getDate(4);
            time = rs.getTime(5);
            place = rs.getString(6);
            description = rs.getString(7);
            currQuota = rs.getInt(9);
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }

    /*
     * This method will be used whenever
     * an activity is created.
     */
    public static boolean addActivity(){
        /*
         * Do some database things
         */

        return true;

    }

    /*
     * This method will be used whenever
     * an activity is deleted from the existing ones.
     */
    public static boolean deleteActivity(){
        /*
        * Do some database things
        */

        return true;
    }

    public void activityLiked(User user){ user.removeActLiked(this); }

    public void activityDisliked(User user){ user.removeActDisliked(this); }

    public int compareTo(Activity activity){
        //Comparing activities according to their activity number (activityID).
        if(this.activityID == activity.getActivityID()){ return 0; }
        else if(this.activityID > activity.getActivityID()){ return 1; }
        else{ return -1; }

    }

    //GetterMethods
    public int getActivityID(){ return this.activityID; }
    public String getName(){ return this.name; }
    public String getDescription(){ return this.description; }
    public ArrayList<Tag> getTags(){ return this.tags; }
    public Date getDate(){ return this.date; }
    public int getQuota(){ return this.quota; }
    public int getCurrQuota(){ return this.currQuota;}

    //Setter Methods
    public void changeDislikeNum(int change){ this.dislikeNum += change; }
    public void changeLikeNum(int change){ this.likeNum += change; }
    public void changeCurrQuota(int change){this.currQuota+=change;};

    public static ArrayList<Activity> getAllActivities(){
        ArrayList<Activity> allActivities = new ArrayList<Activity>();
        try{
            Statement st = MainManager.db.getCon().createStatement();
            ResultSet rs = st.executeQuery("SELECT activityID FROM activities;");
            while(rs.next()){
                allActivities.add(new Activity(rs.getInt(1)));
            }
        }
        catch(SQLException e){

        }
        return allActivities;
    }

    public static void insertActivities(JPanel panelToDisplay , ArrayList<Activity> result){
        //Remove old contents before getting the newest activities;
        panelToDisplay.removeAll();
        panelToDisplay.setLayout(new GridLayout(0, 1));
                
        for(Activity act : result){
            //Set the individual panels
            JPanel panelDisp = new JPanel();
            panelDisp.setLayout(new BorderLayout());
            panelDisp.setBackground(Color.WHITE);
            //Fill those individual panels with single activity
            panelDisp.add(new ActivitiesForPanel(act));
                    
            //Put individual panels into the main panel for display
            panelToDisplay.add(panelDisp);  
        }

        if(result.size()<3)
        {
            for(int i = 0 ; i < 3-result.size() ; i++)
            {
                JPanel empty = new JPanel();
                empty.setBackground(new java.awt.Color(0, 224, 224));
                panelToDisplay.add(empty);
            }
        }

        //Lastly repaint and revalidete the panel;
        panelToDisplay.revalidate();
        panelToDisplay.repaint();
    }

}
