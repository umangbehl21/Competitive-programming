package Binarytrees.Traversals;

import java.util.ArrayList;

public class RightViewOfBinaryTree {
 private static void rightviewTree(BinaryTreeNode<Integer> root,int level,ArrayList<Integer> ans)
  {
    
    if(root == null)
    {
        return;
    }
    if(ans.size() == level)
    {
        ans.add(root.data);
    }
       rightviewTree(root.right, level + 1,ans);  
       rightviewTree(root.left, level + 1,ans);   
 
  }
  public static ArrayList<Integer> rightview(BinaryTreeNode<Integer> root)
  {
      ArrayList<Integer> ans = new ArrayList<>();
      rightviewTree(root, 0, ans);
      return ans;
  }

}
