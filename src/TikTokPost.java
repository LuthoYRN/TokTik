    /**
 * This is a specialized child class of the Post class which additionally stores the name of the author of the post
 */ 
public class TikTokPost extends Post
{
   private String name;
       
       /**
 * This is a constructor for the TikTokPost class
 *
 * @param a: String name (name of the author of the post)
 * @param b: String title (title of the video)
 * @param c: int likes (number of likes of the video)
 *
 */ 
   public TikTokPost(String name,String title,int likes){
      super(title,likes,"");
      this.name = name;
   }
   
       /**
 * This returns the name of the author of the post
 */ 
    public String getName(){
      return this.name;
   }
  
      /**
 * This is a polymorphic toString method that adds the name of the person who posted the video to the original toString() of the parent
 */ 
   public String toString(){
      return String.format("Title: %s\nNumber of likes: %d\nPosted by : %s",getVideoTitle(),getVideoLikes(),name);
   }
}