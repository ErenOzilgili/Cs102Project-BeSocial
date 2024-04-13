import java.util.ArrayList;

public class User{

    String name;
    String password;
    String decriptionOfSelf;
    
    private ArrayList<Activity> activitiesDisliked;
    private ArrayList<Activity> activitiesLiked;
    private ArrayList<Activity> activitiesEnrolled;

    public User(String name, String password){
        //After first creation of the account, password and name is resolved.
        this.name = name;
        this.password = password;

        activitiesDisliked = new ArrayList<Activity>();
        activitiesLiked = new ArrayList<Activity>();
        activitiesEnrolled = new ArrayList<Activity>();

    }

    /*
     * Not done
     */
    public void addActLiked(Activity activity){
        //Boolean will be used to check if this activity has been 
        //formerly liked, if it has been, below method returns true.
        boolean checkIfExistPriorly = this.checkLikedActExist(activity);

        //If it has been liked priorly, remove it from the liked arrayList.
        if(checkIfExistPriorly){
            //From the user, remove the liked activity.
            this.removeActLiked(activity);
            activity.changeLikeNum(-1);
            /*
             * Do some graphics here
             * and database things
             */
            
        }
        //Else, like the activity.
        else{
            //To the user, add the liked activity.
            this.addActLiked(activity);
            activity.changeLikeNum(1);

            /*
             * Do some graphics here
             * and database things
             */

        }
    }

    /*
     * Not done
     */
    public void addActDisliked(Activity activity){
        //Boolean will be used to check if this activity has been 
        //formerly disliked, if it has been, below method returns true.
        boolean checkIfExistPriorly = this.checkDislikedActExist(activity);

        //If it has been disliked priorly, remove it from the disliked arrayList.
        if(checkIfExistPriorly){
            //From the user, remove the disliked activity.
            this.removeActDisliked(activity);
            activity.changeDislikeNum(-1);

             /*
             * Do some graphics here
             * and database things
             */
            
        }
        //Else, dislike the activity.
        else{//(!checkIfExistPriorly)
            //To the user, add the disliked activity.
            this.addActDisliked(activity);
            activity.changeDislikeNum(1);

             /*
             * Do some graphics here
             * and database things
             */

        }
    }

    public void removeActLiked(Activity activity){

    }

    public void removeActDisliked(Activity activity){

    }

    public boolean checkLikedActExist(Activity activity){
        //Checks if it has been previously liked
        for(Activity act : this.activitiesLiked){
            if(act.equals(activity)){
                return true;
            }

        }
        //If not found the activity, return false;
        return false;
    }

    public boolean checkDislikedActExist(Activity activity){
        //Checks if it has been previously disliked
        for(Activity act : this.activitiesDisliked){
            if(act.equals(activity)){
                return true;
            }

        }
        //If not found the activity, return false;
        return false;
    }

    //Setter Methods


    //Getter Methods
    public ArrayList<Activity> getActivitiesDisliked(){
        return this.activitiesDisliked;
    }

    public ArrayList<Activity> getActivitiesLiked(){
        return this.activitiesLiked;
    }

    public ArrayList<Activity> getActivitiesEnrolled(){
        return this.activitiesEnrolled;
    }


    
}
