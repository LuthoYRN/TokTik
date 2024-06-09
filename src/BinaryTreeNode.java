    /**
 * This is a specific BinaryTreeNode class that stores a dataitem of type Account and its left child and right node
 */ 
public class BinaryTreeNode
{
   Account dataitem;
   BinaryTreeNode left;
   BinaryTreeNode right;
   
       /**
 * This is a constructor for the BinaryTreeNode class
 *
 * @param a: Account dataitem (this is an Account object)
 *
 */ 
   public BinaryTreeNode(Account dataitem){
      this.dataitem =dataitem ;
      left = null;
      right = null;
   }
}