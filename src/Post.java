    /**
 * This class stores a post which contains a post's title, video name and number of likes 
 */ 

public class Post{
   private int numLikes;
   private String videoTitle,videoName;
   
     /**
 * This is a constructor for the Post class
 *
 * @param a: String title (title of the video)
 * @param b: int likes (number of likes of the video)
 * @param c: String name (name of the video)
 *
 */ 

   public Post(String title,int likes,String name)
   {
      this.numLikes=likes;
      this.videoTitle=title;
      this.videoName=name;
   }
     /**
 * This returns the video name
 *
 */   
   public String getVideoName(){
      return videoName;
   }
   
     /**
 * This returns the number of likes of the video
 */ 
   public int getVideoLikes(){
      return numLikes;
   }
 
     /**
 * This returns the title of the video
 */   
   public String getVideoTitle(){
      return videoTitle;
   }
   
       /**
 * This returns a string displaying the attributes of the Post class
 */ 
   public String toString()
   {
      return String.format("Title: %s\nVideo: %s\nNumber of likes: %d\n",videoTitle,videoName,numLikes);    
   }
}