package Activity;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;

import Core.MainManager;
import Panels.ActivitiesForPanel;
import User.Tag;
import User.Tag.TagType;

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
            likeNum = rs.getInt(10);
            dislikeNum = rs.getInt(11);
            //System.out.println(System.currentTimeMillis() + " " + date.getTime());
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }

    public Activity(String name,Tag tag, int quota, Date date, Time time, String Place, String Description, int id, int currentQuota,int likeNum, int dislikeNum){
        this.name = name;
        this.tag = tag;
        this.quota = quota;
        this.date = date;
        this.time = time;
        this.place = Place;
        this.description = Description;
        this.activityID= id;
        this.currQuota = currentQuota;
        this.likeNum = likeNum;
        this.dislikeNum = dislikeNum;
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

    //GetterMethods
    public int getActivityID(){ return this.activityID; }
    public String getName(){ return this.name; }
    public String getDescription(){ return this.description; }
    public Tag getTag(){ return this.tag; }
    public Date getDate(){ return this.date; }
    public int getQuota(){ return this.quota; }
    public int getCurrQuota(){ return this.currQuota;}
    public int getLikeCount(){ return this.likeNum;}
    public int getDislikeCount(){ return this.dislikeNum;}
    public Time getTime(){return this.time;}
    public String getPlace(){return this.place;}

    //Setter Methods
    public void changeDislikeNum(int change){ this.dislikeNum += change; }
    public void changeLikeNum(int change){ this.likeNum += change; }
    public void changeCurrQuota(int change){this.currQuota+=change;};
    public void setDislikeNum(int dislikeNum){ this.dislikeNum = dislikeNum; }
    public void setLikeNum(int likeNum){ this.likeNum = likeNum; }
    public void setCurrentQuota(int currentQuota){ this.currQuota = currentQuota; }

    public static ArrayList<Activity> getAllActivities(){
        /*ArrayList<Activity> allActivities = new ArrayList<Activity>();
        try{
            Statement st = MainManager.db.getCon().createStatement();
            ResultSet rs = st.executeQuery("SELECT activityID FROM activities;");
            while(rs.next()){
                allActivities.add(new Activity(rs.getInt(1)));
            }
        }
        catch(SQLException e){

        }
        return allActivities;*/

        ArrayList<Activity> allActivities = new ArrayList<Activity>();
        try{
            Statement st = MainManager.db.getCon().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM activities;");
            while(rs.next()){
                Activity act = new Activity(rs.getString(1),new Tag(Tag.TagType.valueOf(rs.getString(2))),rs.getInt(3),rs.getDate(4),rs.getTime(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getInt(9),rs.getInt(10),rs.getInt(11));
                allActivities.add(act);
            }
        }
        catch(SQLException e){
            System.out.println(e);
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
                empty.setBackground(new java.awt.Color(255, 224, 202));
                panelToDisplay.add(empty);
            }
        }

        //Lastly repaint and revalidete the panel;
        panelToDisplay.revalidate();
        panelToDisplay.repaint();
    }

    public int compareTo(Activity act){
        return 0;
    }

    public double getPoints(HashMap <Tag.TagType, Double> tagWeights){
        double like = (double)this.likeNum;
        double dislike = (double)this.dislikeNum;
        return tagWeights.get(this.tag.getType())*(1+like/(like+dislike+0.001));
    }

}
