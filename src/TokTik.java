import java.io.FileInputStream;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
    /**
 * This is the main class that generates a list of actions to be performed 
  *
 */ 
public class TokTik {
/**
 * This static variable stores the BinarySearchTree the user works with in the main method
 *
 */ 
public static BinarySearchTree accounts = new BinarySearchTree();
/**
 * This static variable stores the posts loaded from the disk
 *
 */ 
public static ArrayList<TikTokPost> allPosts = new ArrayList<>();
/**
 * This static variable stores the names of users loaded from the disk
 *
 */ 
public static ArrayList<String> allNames = new ArrayList<>();
    /**
 * This methods reads from a textfile named dataset.txt and creates a BinarySearchTree that stores nodes of dataitem
 * of type Account.
 *
  *
 */ 
    public static void loadFromDisk(){
        Scanner myFile =null;
        Scanner myFile2 = null;
        try
        {
         String filePath = new File(".").getAbsolutePath();
         filePath = filePath.substring(0,filePath.indexOf("."));
         if (filePath.indexOf("src")>=0){
            myFile = new Scanner(new FileInputStream(".." + File.separator + "src" + File.separator +"dataset.txt"));
            myFile2 = new Scanner(new FileInputStream(".." + File.separator + "src" + File.separator +"names.txt"));
         }
         else
         {
         myFile = new Scanner(new FileInputStream(filePath + File.separator + "src" + File.separator + "dataset.txt"));         
         myFile2 = new Scanner(new FileInputStream(filePath + File.separator + "src" + File.separator + "names.txt"));
        
         }
         }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!");
            System.exit(0);
        }
        
        if (myFile!=null) {
            while (myFile.hasNextLine()==true) {
                String line = myFile.nextLine();
                String name, description,vidName,vidTitle;
                int vidLikes;
                if ((line.substring(0, 6)).compareTo("Create")==0)
                {
                    name = line.substring(line.indexOf(" ") + 1, line.indexOf(" ", line.indexOf(" ") + 1));
                    line = line.substring(line.indexOf(" ", line.indexOf(" ") + 1) + 1);
                    description = line;
                    Account newAccount = new Account(name,description);
                    accounts.insert(newAccount);
                }
                else{
                    name = line.substring(line.indexOf(" ") + 1, line.indexOf(" ", line.indexOf(" ") + 1));
                    line = line.substring(line.indexOf(" ", line.indexOf(" ") + 1) + 1);
                    vidName=line.substring(0,line.indexOf(" "));
                    vidLikes=Integer.parseInt((line.substring(line.indexOf(" ")+1, line.indexOf(" ", line.indexOf(" ") + 1))));
                    vidTitle = line.substring(line.indexOf(" ", line.indexOf(" ") + 1) + 1);
                    accounts.addExistingPost(name,new Post(vidTitle,vidLikes,vidName));     
                    allPosts.add(new TikTokPost(name,vidTitle,vidLikes)); 
                }
            }
            myFile.close();
        }
        
        if (myFile2!=null){
         while (myFile2.hasNextLine()){
            allNames.add(myFile2.nextLine());
         }
         myFile2.close();
        }
    }
    
        /**
 * This utilizes an ArrayList and Collections utility to printout the top 10 most liked posts out of all 
 * the accounts that are stored by the BinarySearchTree.
  *
 */ 
    public static void top10(){
      if (allPosts.size()>0){
      System.out.println("\nTop 10 Trending posts\n==============================================================\n");
      Collections.sort(allPosts, (post1, post2) -> post2.getVideoLikes() - post1.getVideoLikes());
      for (int i=0;i<10;i++){
         if ((allPosts.size()-1)<i){
            break;
          }
         System.out.println("No."+String.valueOf(i+1)+"\n"+allPosts.get(i).toString()+"\n");
      }
      }
      else
      {
         System.out.println("There are no posts , load from disk or add a post");
      }
    }
 
     /**
 * This methods prints out the list of actions that the user interacts with 
 *
 */  
    public static void printMenu(){
       System.out.println("Choose an action from the menu:");
       System.out.println("1. Find the profile description for a given account");
       System.out.println("2. List all accounts");
       System.out.println("3. List all accounts of one user");
       System.out.println("4. Create an account");
       System.out.println("5. Delete an account");
       System.out.println("6. Display all posts for a single account");
       System.out.println("7. Add a new post for an account");
       System.out.println("8. Top 10 Trending posts");
       System.out.println("9. Load a file of actions from disk and process this");
       System.out.println("10. Quit");
       System.out.print("Enter your choice: ");
    }
    
        /**
 * This is a recursive method that repeatedly takes in userinput until it is valid 
 *
 *
 */ 
    public static int getInput(){
      Scanner input = new Scanner(System.in);
      int userinput;
      try{
              userinput = input.nextInt();
              if ((userinput>10) || (userinput<1)){ 
              System.out.print("Enter valid choice: ");
              return getInput();}
            }
            catch (Exception e)
            {
               System.out.print("Enter valid choice: ");
               return getInput();
            }
            return userinput;
    }

    /**
 * This is the main method of the TokTik class
  *
 */ 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        printMenu();
        int userinput = getInput();
        boolean bLoaded=false;
        while (userinput!=10){
            switch (userinput)
            {
                case 1: {
                    if (accounts.root!=null){
                       System.out.print("\nEnter account name: ");
                       String name = input.nextLine();
                       if (accounts.findName(name)==null)
                       {
                           System.out.println("\nAccount name not found.\n");
                       }
                       else
                       {
                           System.out.println("The profile description is: "+(accounts.findName(name)).dataitem.getDescription()+"\n");
                       }
                    }
                    else
                    {
                        System.out.println("\nLoad actions from disk first.\n");
                    }
                    break;
                }
                case 2: {
                    if (accounts.root!=null){
                       System.out.println("\nList of all accounts\n=====================");
                       accounts.printNames();
                       System.out.println();
                       }
                    else
                    {
                       System.out.println("\nThere are no accounts to list , load actions from disk first.\n");
                    }
                    break;
                }
                
                 case 3: {
                    if (accounts.root!=null){
                       System.out.print("\nEnter name: ");
                       String userName = input.nextLine();
                       if (allNames.contains(userName)==true){
                          System.out.printf("\nList of all accounts created by user : %s\n=============================================\n",userName);
                          accounts.printUserAccounts(userName);
                          System.out.println();
                         }
                         else
                         {
                           System.out.println("\nName not found.\n");
                         }
                       }
                    else
                    {
                       System.out.println("\nThere are no accounts to list , load actions from disk first.\n");
                    }
                    break;
                }

                case 4: {
                    System.out.print("\nEnter account name: ");
                    String accountName = input.nextLine();
                    System.out.print("Enter account description: ");
                    String description = input.nextLine();
                    accounts.insert(new Account(accountName,description));
                    if (allNames.contains(accountName)==false){
                    allNames.add(accountName);}
                    System.out.println("Account created succesfully!\n");
                    break;
                }

                case 5: {
                    if (accounts.root!=null)
                    {
                       System.out.print("\nEnter account name: ");
                       String accountName = input.nextLine();
                        if (accounts.findName(accountName)!=null)
                          {
                           accounts.delete(accountName);
                           System.out.println("Account deleted succesfully!\n");
                          }
                          else
                         {
                            System.out.println("Account to be deleted does not exist.\n");
                         }
                    }
                    else
                    {
                        System.out.println("\nThere are no accounts to delete.\n");
                    }
                    break;
                }

                case 6: {
                 if (accounts.root!=null)
                    {
                    System.out.print("\nEnter account name: ");
                    String accountName = input.nextLine();
                    if (accounts.findName(accountName)!=null)
                    {
                       accounts.displayPosts(accountName);
                    }
                    else
                     {
                       System.out.println("Account not found.\n");
                     }  
                   }
                   else{
                    System.out.println("\nLoad actions from disk first.\n");}
                    break;
                }
                
                case 7: {
                if (accounts.root!=null)
                    {
                    System.out.print("\nEnter account name: ");
                    String accountName = input.nextLine();
                    if (accounts.findName(accountName)!=null)
                    {
                       System.out.print("Enter video title: ");
                       String videoTitle = input.nextLine();   
                       accounts.addNewPost(accountName,videoTitle);
                       System.out.println("New post added succesfully!\n");
                    }
                    else
                         {
                            System.out.println("Account not found.\n");
                         }
                    }
                    else
                    {
                    System.out.println("\nLoad actions from disk first.\n");}
                    break;
                }
                case 8: {
                    if (accounts.root!=null){
                     top10();
                       }
                    else
                    {
                        System.out.println("\nLoad actions from disk first.\n");
                    }
                    break;
                }

                case 9: {
                    if (bLoaded==false)
                    {
                       loadFromDisk();
                       bLoaded=true;
                       System.out.println("\nActions loaded from disk succesfully!\n");
                       }
                    else
                    {
                       System.out.println("\nYou have already loaded from the disk.\n");
                    }
                    break;
                }
            }
            printMenu();
            userinput=getInput();
            }
        System.out.println("Bye!");
    }
}
