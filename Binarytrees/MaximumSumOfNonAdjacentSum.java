package Binarytrees;
  class pair
    {
       int first;   //include the current node will be store in first
       int second;  //exclude the current node will be store in second 
    }
public class MaximumSumOfNonAdjacentSum {
    public static pair helper(BinaryTreeNode<Integer> root)
    {
        if(root == null)
        {
            pair p1 = new pair();
            p1.first = 0;
            p1.second = 0;
            return p1;
        }
         pair leftp  = helper(root.left);
         pair rightp = helper(root.right);
         pair p1 = new pair();
         p1.first = root.data + leftp.second + rightp.second;  //including the root node when we include root node we cannot include its direct children or imeediate children which are just below it 
         p1.second = Math.max(leftp.first, leftp.second) + Math.max(rightp.first,rightp.second); //excluding root we have 2 choices each for left and right include the immediate children donot include it so we will take max from both left and right subtree  one time including the child root and one time excluding the child root 
         return p1;
    }
    public static int maximumsum(BinaryTreeNode<Integer> root)
    {
        pair p1 = helper(root);
        return Math.max(p1.first, p1.second);
    }
}
