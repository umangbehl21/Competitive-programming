package BST;

import Binarytrees.BinaryTreeLevelwiseInput;
import Binarytrees.BinaryTreeNode;

public class BstToSortedLinkedList 
{
     static BinaryTreeNode<Integer> prev;
    public static void inorder(BinaryTreeNode<Integer> root,BinaryTreeNode<Integer> prev)
    {
         if(root == null)
         {
             return;
         }
         inorder(root.left, prev);
         prev.left = null;
         prev.right = root; 
         prev = root;
         inorder(root.right, prev);                     
    }
    public static BinaryTreeNode<Integer> flatten(BinaryTreeNode<Integer> root)
    {
      
        BinaryTreeNode<Integer> dummy = new BinaryTreeNode<Integer>(-1);
        prev = dummy;  //assigning dummy adress to  prev 
        inorder(root, prev);
        prev.left = null;
        prev.right = null; 
        return prev;
    }
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeLevelwiseInput.LevelWiseInput();
        BinaryTreeNode<Integer> ansnode = flatten(root);
        System.out.println(ansnode.right.data);
    }

}
