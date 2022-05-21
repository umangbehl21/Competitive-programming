package Binarytrees;

public class LongestUnivaluePath {
    public static int ans = 0;
    public static int longestunival(BinaryTreeNode<Integer> root)
    {
       return helper(root);
    
    } 
    public static int helper(BinaryTreeNode<Integer> root)
    {
       if(root == null)
       {
           return 0;
       }
       int left = helper(root.left);
       int right = helper(root.right);
       int leftedge = 0,rightedge = 0;
       if(root.left!= null && root.data == root.left.data)  //if left is not null and root data is equal to its left child we count 1 edge
       {
           leftedge += left + 1;
       }
       if(root.right != null && root.data == root.right.data)  //if right is not null and root data is equal to its right child we count 1 edge 
       {
           rightedge += right + 1;
       }
       ans = Math.max(ans,leftedge + rightedge);  //if path is through the root both edges will be one so we have to add and cover this case 
       return Math.max(leftedge,rightedge); //we have to find the longest path it can come from left small ans or right small ans so we have to check which one is greater 
    }
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeLevelwiseInput.LevelWiseInput();
        System.out.println(longestunival(root));
    }
}
