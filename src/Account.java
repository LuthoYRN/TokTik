import java.util.ArrayList;

      /**
 * This is an Account class that stores an account's username ,description and all posts posted by the user
 * It implements Comparable to allow for comparing of instances of same class
 *
 */ 
public class Account implements Comparable {
    private String name, description;
    private ArrayList<Post> posts;
    
     /**
 * This is a constructor for the Account class
 *
 * @param a: String name (username of the account)
 * @param b: String description (description of the account)
 *
 */ 
    public Account(String name, String description) {
        this.name = name;
        this.description = description;
        this.posts=new ArrayList<>();
    }
     /**
 * This returns the account username
 *
 */   
    public String getName() {
        return this.name;
    }
     /**
 * This returns the account description
 *
 */   
    public String getDescription() {
        return description;
    }
    
      /**
 * This is a void method that executes the toString() methods of all Post objects related to this Account class
 * In laymen terms this method shows all the posts a user posted
 *
 */   
    public void displayPosts() {
    if (posts.size()!=0){
      System.out.printf("List of %s's posts\n===============================================================\n",name);
       for (int i=posts.size()-1;i>-1;i--){
         System.out.println(posts.get(i).toString());
       }
      }
      else System.out.println(name+" has no posts yet.\n");
     }
    
         /**
 * This method adds a new post for an Account
 *
 * @param a: String title (title of the post)
 */   
    public void addNewPost(String title){
    if (posts.size()!=0)
    {
      String vidNum=posts.get(posts.size()-1).getVideoName();
      int next=Integer.parseInt(vidNum.substring(5,vidNum.indexOf(".")))+1;
      this.posts.add(new Post(title,0,"video"+String.valueOf(next)+".mpg"));
    }
    else
    {
      this.posts.add(new Post(title,0,"video1.mpg")); 
    }
    }
    
 /** This method adds a post that was already posted by this Account
 *
 * @param a: Post post (post object)
 */   
     public void addExistingPost(Post post){
      this.posts.add(post);
    }

    @Override
   /** This method overrides Comparable so that objects of this class can be compared to one another via the Account name
 *
 * @param a: Object o (instance of Account object)
 */ 
    public int compareTo(Object o) {
        if (o instanceof Account) {
            Account account2 = (Account)o;
            return this.getName().compareTo(account2.getName());
          }
        return -100;
    }
}
