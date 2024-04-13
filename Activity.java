import java.util.ArrayList;
import java.awt.Dimension;
import java.sql.Date;

public class Activity implements Comparable<Activity>{
    
    public static int numberOfActiveActivities;
    //Below can be changed according to preference;
    public static final Dimension appearanceSize = new Dimension(400, 300);

    private ArrayList<Tag> tags;
    private String name;
    private String description;
    private int activityNo;
    private Date date ;
    private int dislikeNum;
    private int likeNum;
    private int appearanceHeight;
    private int appearanceWidth;
    
    /*
     * More instance variables to add here.
     */

    public Activity(String name, String description, ArrayList<Tag> tagsTemp, Date date){
        //Instead of this get from database.
        tags = new ArrayList<Tag>();

        //Initializing the name and description according to the input.
        this.name = name;
        this.description = description;
        this.date = date;

        //Activity no
        numberOfActiveActivities++;
        this.activityNo = numberOfActiveActivities;

        //Like and dislike count will be 0 whenever an activity has been created.
        this.likeNum = 0;
        this.dislikeNum = 0;

        //Adding the chosen tags to the activities tags ArrayList.
        for(Tag tag : tagsTemp){
            tags.add(tag);
        } 

        //Height and Width of how the activity will appear in panel
        this.appearanceHeight = (int)Activity.appearanceSize.getHeight();
        this.appearanceHeight = (int)Activity.appearanceSize.getWidth();
 
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
        //Comparing activities according to their activity number (activityNo).
        if(this.activityNo == activity.getActivityNo()){ return 0; }
        else if(this.activityNo > activity.getActivityNo()){ return 1; }
        else{ return -1; }

    }

    //GetterMethods
    public int getActivityNo(){ return this.activityNo; }
    public String getName(){ return this.name; }
    public String getDescription(){ return this.description; }
    public ArrayList<Tag> getTags(){ return this.tags; }
    public Date getDate(){ return this.date; }

    //Setter Methods
    public void changeDislikeNum(int change){ this.dislikeNum += change; }
    public void changeLikeNum(int change){ this.likeNum += change; }


}
