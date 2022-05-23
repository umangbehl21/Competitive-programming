package BST;

import Binarytrees.BinaryTreeNode;

public class isBst2
{
    
    public static boolean isbst(BinaryTreeNode<Integer> root)  //the worst case complexity will be o(n^2) as every node is first returning maximum and minimum and when checking that it is balanced it is checking maximum and minimum again 
    {
        if(root == null)
        {
            return true;
        }
        int leftmax = maximum(root.left);
        int rightmin = minimum(root.right);
        if(leftmax >= root.data)
        {
            return false;
        }
        if(rightmin < root.data)
        {
            return false;
        }
        boolean isleftbst = isbst(root.left);
        boolean isrightbst = isbst(root.right);
        if(isleftbst && isrightbst)
        {
            return true;
        }
        else 
        {
            return false;
        }
    }

    private static int maximum(BinaryTreeNode<Integer> root) {
        if(root == null)
        {
            return Integer.MIN_VALUE;
        }
        return Math.max(root.data, Math.max(maximum(root.left),maximum(root.right)));
    }
    public static int minimum(BinaryTreeNode<Integer> root)
    {
        if(root == null)
        {
            return Integer.MAX_VALUE;
        }
       return Math.min(root.data,Math.min(minimum(root.right),minimum(root.left)));
        
    }
    public static pair<Boolean,pair<Integer,Integer>> isBst2(BinaryTreeNode<Integer> root)
    {
       if(root == null)
       {
           pair<Boolean,pair<Integer,Integer>> output = new pair
       }
    }
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = Levelwiseinput.levelwise();
        System.out.println(isbst(root));
    }


}
