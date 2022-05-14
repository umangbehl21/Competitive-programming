package Binarytrees.Traversals;
import java.util.ArrayList;

public class LeftViewOfBinaryTree
 {
    private static void LeftViewHelper(BinaryTreeNode<Integer> root,int level,ArrayList<Integer> ans)
    {
       if(root == null)
       {
           return;
       }
       if(ans.size() == level)
       {
           ans.add(root.data);
       }
       LeftViewHelper(root.left, level + 1, ans);
       LeftViewHelper(root.right, level + 1, ans);

    }
    public static ArrayList<Integer> LeftView(BinaryTreeNode<Integer> root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        LeftViewHelper(root,0, ans);
        return ans;
    }

}
