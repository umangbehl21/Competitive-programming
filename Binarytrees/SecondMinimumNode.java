package Binarytrees;
import java.util.*;
public class SecondMinimumNode {
    static ArrayList<Integer> treenodes = new ArrayList<>();
    public static void secondminhelper(BinaryTreeNode<Integer> root)
    {
        if(root == null)
        {
            return; 
        }
         treenodes.add(root.data);
         secondminhelper(root.left);
         secondminhelper(root.right);
    }
    public static int secondmindo()
    {
       int ans[] = new int[treenodes.size()];
       for(int i = 0;i<treenodes.size();i++)
       {
           ans[i] = treenodes.get(i);
       }
       int min = Integer.MAX_VALUE;
       int secmin = Integer.MAX_VALUE;
       for(int i = 0;i<ans.length;i++)
       {
         if(ans[i] < min)
         {
            secmin = min;
            min = ans[i];
         }
         if(ans[i] < secmin && ans[i] > min)
         {
            secmin = ans[i];
         }

       }
       return secmin;
    }
    public static int SecondMinimumNodeTree(BinaryTreeNode<Integer> root)
    {
        if(root == null)
        {
            return 0;
        }
        secondminhelper(root);
        int ans = secondmindo();
        return ans;
    }
    public static void main(String[] args) {
       BinaryTreeNode<Integer> root = BinaryTreeLevelwiseInput.LevelWiseInput();
      System.out.println(SecondMinimumNodeTree(root));
    }
}
