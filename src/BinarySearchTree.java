 /** This is a BinarySearchTree class which stores and performs operations on nodes of type Account
 *
 */ 
public class BinarySearchTree extends BinaryTree{
    public BinarySearchTree(){
      super();
   }
   
         /**
 * This is a constructor for the BinarySearchTree class
 *
 * @param a: BinaryTreeNode root (root node of the tree)
 *
 */ 
   public BinarySearchTree(BinaryTreeNode root){
      super(root);
   }
   
   /**
 * Helper function of insert.
 * 
 * @param a: data (the dataitem of node of type Account)
 */
   public void insert(Account data){
      if (super.root==null){
         super.root=new BinaryTreeNode(data);
      }
      else
      {
         insert(data,super.root);
      }
   }
     
     /**
 * This inserts a node with dataitem of type Account to tree with given root node
 *
 * @param a: Account data (the dataitem of node of type Account)
 * @param b: BinaryTreeNode node (the root of the tree we insert in)
 *
 */ 
   
   public void insert(Account data,BinaryTreeNode node){
      int cmp = data.compareTo(node.dataitem);
      if (cmp<0){
         if (node.left!=null){
         insert(data,node.left);
         }
         else{
            node.left=new BinaryTreeNode(data);
         }
        }
       
       if (cmp>0){
         if (node.right!=null){
         insert(data,node.right);
         }
         else{
            node.right=new BinaryTreeNode(data);
         }
      }
     }
  
  /**
 * This is a helper function for addNewPost()
 *
 */       
   public void addNewPost(String accountName, String vidTitle){
       if (root!=null){
         addNewPost(accountName,vidTitle,root);
         }
   }
 /**
 * This adds a new post for a binary search tree node of type account
 * Extends on a simple recursive find algorithm for BinarySearchTrees 
 *
 * @param a: String accountName (name of the account to add post for)
 * @param b: String vidTitle (video title of the post to be added)
 * @param c: BinaryTreeNode node (the node used for traversing the tree)
 *
 */ 
   public void addNewPost(String accountName, String vidTitle,BinaryTreeNode node){
       if (node!=null){
         int cmp=accountName.compareTo(node.dataitem.getName());
         if (cmp==0)
         {
            node.dataitem.addNewPost(vidTitle);
         }
         else{
            if (cmp<0){
               addNewPost(accountName,vidTitle,node.left);
            }
            else
            {
               addNewPost(accountName,vidTitle,node.right);
            }
         }
      }
   }
   
    /**
 * This is a helper function for addExistingPost(a,b,c)
 *
 */ 
   public void addExistingPost(String accountName, Post post){
          addExistingPost(accountName,post,root);
   }
   
    /**
 * This adds an existing post for a binary search tree node of type account
 * Extends on a simple recursive find algorithm for BinarySearchTrees 
 *
 * @param a: String accountName (name of the account to add post for)
 * @param b: Post post (post object to be added under account)
 * @param c: BinaryTreeNode node (the node used for traversing the tree)
 *
 */ 
   public void addExistingPost(String accountName, Post post,BinaryTreeNode node){
       if (node!=null){
         int cmp=accountName.compareTo(node.dataitem.getName());
         if (cmp==0)
         {
            node.dataitem.addExistingPost(post);
         }
         else{
            if (cmp<0){
               addExistingPost(accountName,post,node.left);
            }
            else
            {
               addExistingPost(accountName,post,node.right);
            }
         }
      }
   }

    /**
 * This is a helper function of the findName method
*
 */ 
   public BinaryTreeNode findName(String data){
      if (root==null)
      {
         return null;
      }
      else{
         return findName(data,root);
      }
   }
    /**
 * This finds a given account name in the BinarySearchTree by searching the dataitems of the nodes
 * Extends on a simple recursive find algorithm for BinarySearchTrees 
 *
 * @param a: String data (name of the account to search)
 * @param b: BinaryTreeNode node (node to start traversing at)
  *
 */ 
   public BinaryTreeNode findName(String data,BinaryTreeNode node){
      if (node!=null){
         int cmp=data.compareTo(node.dataitem.getName());
         if (cmp==0)
         {
            return node;
         }
         else{
           return (cmp<0)?findName(data,node.left):findName(data,node.right);
         }
      }
      return null;
   }
    /**
 * This is a helper function of the delete method
  *
 */ 
   public BinaryTreeNode delete(String data){
      if (root==null)
      {
         return null;
      }
      else
      {
         root=delete(data,root);
         return root;
      }
   }
   
    /**
 * This deletes a node in the BinarySearchTree if its dataitem name is the same that was input
 * Extends on a recursive delete algorithm for BinarySearchTrees 
 *
 * @param a: String data (name of the account to delete)
 * @param b: BinaryTreeNode node (node to start traversing at)
  *
 */ 
   
   public BinaryTreeNode delete(String data,BinaryTreeNode node){
    if (node == null) {
      return null;
   }
   
    int cmp=data.compareTo(node.dataitem.getName());
         if (cmp<0){
            node.left=delete(data,node.left);
         }
         if (cmp>0){
            node.right=delete(data,node.right);
         }
         if (cmp==0)
         {
            if ((node.left!=null) || (node.right!=null))
            {
               node.dataitem=findMin(node.right).dataitem;
               node.right=removeMin(node.right);
            }
            else
            {
               if (node.left!=null)
               {
                  node=node.right;
               }
               else
               {
                  node=node.right;
               }
            }
         }
         return node;
     }
   
    /**
 * This finds the minimum node on the right subtree to replace deleted node 
 *
 * @param a: BinaryTreeNode node (node to start traversing at)
  *
 */ 
   public BinaryTreeNode findMin(BinaryTreeNode node){
      if (node!=null){
         while (node.left!=null)
         {
            node=node.left;
         }
         return node;
      }
      return node;
   }
  
     /**
 * This removes the minimum node on the right subtree that was used to replace deleted node 
 *
 * @param a: BinaryTreeNode node (node to start traversing at)
  *
 */ 
   public BinaryTreeNode removeMin(BinaryTreeNode node){
      if (node!=null){
         if (node.left!=null)
         {
            node.left=removeMin(node.left);
            return node;
         }
         return node.right;
      }
      return null;
   }
   
    /**
 * This is a helper function of the printUserAccounts method
*
 */ 
   public void printUserAccounts(String data){
         printUserAccounts(data,root);
      }
    /*** This function prints the name of dataitem if it is equal to the value we compare it with
 * It is an extension of the inorder traversal
 *
 * @param a: String data (comparator)
 * @param b: BinaryTreeNode node (start node for traversal)
 *
 */ 
   public void printUserAccounts(String data,BinaryTreeNode node){
      if (node!=null){
         printUserAccounts(data,node.left);
         if ((node.dataitem.getName().length()>=data.length()) && ((node.dataitem.getName().substring(0,data.length())).equalsIgnoreCase(data)==true)){
            System.out.println(node.dataitem.getName());         
         }
        printUserAccounts(data,node.right);        
   }
}

   
   
   
   
   
   
   
   
   
   
   
   
       /**
 * This is a helped function of the displayPosts method 
  *
 */ 
   public void displayPosts(String accountName){
      displayPosts(accountName,root);
   }
   
      /**
 * This method traverses through all the BinarySearchTree nodes and locates a node and displays all located node's posts
 * This extends on a simple recursive find algorithm for BinarySearchTrees
 *
 * @param a: String accountName (name of account to display posts for)
 * @param b: BinaryTreeNode node (node to start traversing at)
  *
 */ 
   public void displayPosts(String accountName,BinaryTreeNode node){
       if (node!=null){
         int cmp=accountName.compareTo(node.dataitem.getName());
         if (cmp==0)
         {
            node.dataitem.displayPosts();
         }
         else{
            if (cmp<0){
               displayPosts(accountName,node.left);
            }
            else
            {
               displayPosts(accountName,node.right);
            }
         }
      }
   }
 }