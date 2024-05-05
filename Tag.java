import java.util.ArrayList;
import java.sql.*;

public class Tag{
    private TagType type;

    public enum TagType{
        CHESS,
        SPORTS,
        CHAT,
        VIDEOGAME,
        CINEMA,
        FOOTBALL,
        DANCE;
    }

    public Tag(TagType type){
        this.type = type;
    }

    public static ArrayList<Tag> detectTags(Account acc){
        //"<Chess><Sports><Chat>" --> into 3 tags
        ArrayList<Tag> tags = new ArrayList<Tag>();
        String allTags = "<>";
        try{
            Statement st = MainManager.db.getCon().createStatement();
            ResultSet rs = st.executeQuery("SELECT tags FROM account WHERE username = '%s';".formatted(acc.userName));
            rs.next();
            allTags = rs.getString("tags");
        }
        catch (SQLException e) {
            System.out.println(e);
        }
        finally {
            
        }
        

        String tag = "";
        int closeSign = 0;

        if(allTags != null){
            while(allTags.length() > 0){

                for(int j = 1; j < allTags.length(); j++){
                    if(allTags.charAt(j) == '>'){
                        closeSign = j;
                        break;
                    }
                }
    
                if(!(allTags.substring(1, closeSign) == "")){
                    tag = allTags.substring(1, closeSign);
    
                    TagType typeOf = TagType.valueOf(tag.toUpperCase());
                    tags.add(new Tag(typeOf));
                }
                allTags = allTags.substring(closeSign + 1);
            }
        }
        
        return tags;
    }

    public TagType getType(){
        return this.type;
    }

    
}
