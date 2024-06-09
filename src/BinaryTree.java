import java.lang.*;
    /**
 * This is a BinaryTree class that has a root node which allows for traversal of the entire tree
 *
 */ 
public class BinaryTree
{
   BinaryTreeNode root;
       /**
 * This is a default constructor for the BinaryTree class
 *
 */ 
   public BinaryTree(){
      root = null;
   }
       /**
 * This is a constructor for the BinaryTree class
 *
 * @param a: BinaryTreeNode root (root node of the tree)
 *
 */ 
   public BinaryTree(BinaryTreeNode root){
      root = root;
   }
   
      /**
 * This is a helper function for the printNames method
 *
 */ 
    public void printNames(){
      printNames(root);
   }
       /**
 * This function prints the names of the dataitem of each node in the tree which is Account username
 * It is an inorder traversal as the node's dataitem is printed after its left child but before right child
 *
 * @param a: BinaryTreeNode node (start node for traversal)
 *
 */ 
   public void printNames(BinaryTreeNode node){
      if (node==null){
         return;
      } 
      else
      {
         printNames(node.left);
         System.out.println(node.dataitem.getName());
         printNames(node.right);
      }
}
   
      /**
 * This is a helper function for the printDescriptions method
 *
 */    
   public void printDescriptions(){
      printDescriptions(root);
   }
  /**
 * This function prints the descriptions of the dataitem of each node in the tree which is Account description
 * It is an inorder traversal as the node's dataitem is printed after its left child but before right child
 *
 * @param a: BinaryTreeNode node (start node for traversal)
 *
 */ 
   public void printDescriptions(BinaryTreeNode node){
      if (node==null){
         return;
      } 
      else
      {
         printDescriptions(node.left);
         System.out.println(node.dataitem.getDescription());
         printDescriptions(node.right);
      }
  }
}