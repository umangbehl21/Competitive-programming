package Binarytrees;

import java.util.*;

public class ReverseLevelOrder {
   
    static ArrayList<Integer> ans = new ArrayList<>(); //static ArrayList can be accessed by all static member functions 
    public static void ReverseLevelOrderHelper(BinaryTreeNode<Integer> root)
    {
        if(root == null)
        {
           return;
        }
        ReverseLevelOrderHelper(root.left);
        ReverseLevelOrderHelper(root.right);
        ans.add(root.data);
    }
    public static ArrayList<Integer> ReverselevelOrder(BinaryTreeNode<Integer> root)
    {
        ReverseLevelOrderHelper(root);
        return ans;
    }
    public static void main(String[] args) {
       BinaryTreeNode<Integer> root = BinaryTreeLevelwiseInput.LevelWiseInput();
       System.out.println(ReverselevelOrder(root)); 

    }

}
