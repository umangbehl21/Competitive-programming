package BST;
import java.util.*;

import Binarytrees.BinaryTreeLevelwiseInput;
import Binarytrees.BinaryTreeNode;
public class RootToNodePath 
{
    public static BinaryTreeNode<Integer> roottonodepath(BinaryTreeNode<Integer> root,ArrayList<Integer> ans,BinaryTreeNode<Integer> searchnode)
    {
         if(root == null)
         {
             return null;
         }
         if(root.data == searchnode.data)
         {
             ans.add(root.data);  //if we find the node then add that it is the begining of the path 
             return root;
         }
         BinaryTreeNode<Integer> lans = roottonodepath(root.left, ans, searchnode);
         BinaryTreeNode<Integer> rans = roottonodepath(root.right, ans, searchnode);   
         if(lans != null || rans != null)  //if left small ans is not null or right small ans is not null means that there was the node we were finding on thw left or right path so add the current root in arraylist too 
         {
            ans.add(root.data);
            return root;
         }
         else
         {
            return null;  //if both lans and rans are null return null 
         }

        }
        public static void main(String[] args) {
            BinaryTreeNode<Integer> root = BinaryTreeLevelwiseInput.LevelWiseInput();
            ArrayList<Integer> ans = new ArrayList<>();
            BinaryTreeNode<Integer> searchnode = new BinaryTreeNode<Integer>(7);
            roottonodepath(root, ans,searchnode);
            System.out.println(ans);
        }

}
