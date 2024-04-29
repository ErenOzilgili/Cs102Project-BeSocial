import java.util.ArrayList;

public class Tag{
    private TagType type;

    public static enum TagType{
        CHESS,
        SPORTS,
        CHAT,
        VIDEOGAME,
        CINEMA,
        DANCE;
    }

    public Tag(TagType type){
        this.type = type;
    }

    public static ArrayList<Tag> detectTags(Account acc){
        //"<Chess><Sports><Chat>" --> into 3 tags
        ArrayList tags = new ArrayList<tagType>();
        String allTags = "<Chess><Sports><Chat>";

        String tag = "";
        int closeSign = 0;

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

        return tags;
    }

    public TagType getType(){
        return this.type;
    }
}
