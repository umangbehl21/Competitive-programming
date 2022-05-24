package BST;

import Binarytrees.BinaryTreeNode;
import Binarytrees.pair;
public class isBstBetterBesT
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
        
    }                              //min      //max
    public static pair<Boolean,pair<Integer,Integer>> isBstbetter(BinaryTreeNode<Integer> root)  //time complexity is o(n) in all scenarios as we are going on every node and bringing maximum minimum and isbst 
    {
        if(root == null)
        {
            pair<Boolean,pair<Integer,Integer>> output = new pair<>();
            output.first = true;
            output.second = new pair<Integer,Integer>(); //output.second contains one more pair class so we have to make its object to access its properties 
            output.second.first = Integer.MAX_VALUE; 
            output.second.second = Integer.MIN_VALUE; 
            return output;
        }
        pair<Boolean,pair<Integer,Integer>> left = isBstbetter(root.left);
        pair<Boolean,pair<Integer,Integer>> right = isBstbetter(root.right);
        int max =  Math.max(root.data,Math.max(left.second.second, right.second.second)); 
        int min = Math.min(root.data,Math.min(left.second.first,right.second.first));
        boolean isBst = root.data > left.second.second && root.data <= right.second.first && left.first && right.first;
        pair<Boolean,pair<Integer,Integer>> output = new pair<>();
        output.first = isBst;
        output.second.first = min;
        output.second.second = max;
        return output;

    }
    public static boolean isBstEasy(BinaryTreeNode<Integer> root,int min,int max)
    {
        if(root == null)
        {
            return true;
        }
        if(root.data < min || root.data > max)  
        {
            return false;
        }
        boolean isleftok = isBstEasy(root.left,min,root.data - 1);
        boolean isrightok = isBstEasy(root.right, root.data + 1, max);   
        return isleftok && isrightok;  
    }
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = Levelwiseinput.levelwise();
        System.out.println(isbst(root));
    }


}
