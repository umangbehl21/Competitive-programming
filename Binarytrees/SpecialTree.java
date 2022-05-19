package Binarytrees;

public class SpecialTree {
//https://www.codingninjas.com/codestudio/problems/special-binary-tree_920502?topList=top-amazon-coding-interview-questions&leftPanelTab=1
  
       public static boolean isSpecialBinaryTree(BinaryTreeNode<Integer> root) {
		// Write your code here.
		if(root == null)
		{ 
			return true;  //this is the base case we are returning true but on backtracking we are doing the actual work here returning true is necessary because leftans and right ans is checked whether they are not false
		}
		boolean leftans = isSpecialBinaryTree(root.left);
		boolean rightans = isSpecialBinaryTree(root.right);
        if(leftans == false || rightans == false)  //if any of the left or right subtree is return false false is returned 
        {
            return false;
        }
		if((root.left == null && root.right == null) || (root.left != null && root.right != null))  //if root's left and right is null or both are not null are the condition where it is a special tree
		{
			return true;
		}
		else
		{
			return false; //if above condition is not true return false as on of the parent have a single child 
		}
	}
}
