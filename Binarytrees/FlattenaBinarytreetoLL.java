package Binarytrees;
import java.util.*;
public class FlattenaBinarytreetoLL {
    public static void  FlattenConstantspace(BinaryTreeNode<Integer> root)   //here time complexity is o(n) but space complexity is o(1) as we are not using recursion there will not be any call stack use in it 
    {
       BinaryTreeNode<Integer> curr = root;
       while(curr != null)
       {
       if(curr.left != null)
       {
        BinaryTreeNode<Integer> prev = curr.left;
        while(prev.right != null)
        {
           prev = prev.right;
        }
         prev.right = curr.right;
         curr.right = curr.left;
         curr.left = null;
       }
         curr = curr.right;
    }
}
    public static void FlattenUsingStack(BinaryTreeNode<Integer> root)  //o(n) time o(n) space as we are using stack 
    {
      Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
      stack.push(root);
      BinaryTreeNode<Integer> curr;
      while(!stack.isEmpty())
      {
        curr = stack.pop();
        if(curr.right != null)    //adding right first and left afterwards because then left will be on top and we have to attach left to the root first 
        {
            stack.push(curr.right);
        }
        if(curr.left != null)
        {
            stack.push(curr.left);
        }
        if(!stack.isEmpty())
          {
             curr.right = stack.peek();
             curr.left = null;
          }
      }

}