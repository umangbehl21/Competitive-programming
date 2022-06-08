package BST;
import Binarytrees.BinaryTreeNode;

class pair
{
    boolean isbal;
    int ht;
}
public class balancedBst
 {
    public static pair isbalanced(BinaryTreeNode<Integer> root)
    {
       if(root == null)
       {
           pair p1 = new pair();
           p1.ht = 0;
           p1.isbal = true;
       }
      pair lp = isbalanced(root.left);
      pair rp = isbalanced(root.right);
      int height = 1 + Math.max(lp.ht,rp.ht); 
      boolean isbal = lp.isbal && rp.isbal && Math.abs(lp.ht - rp.ht) <=1;
      pair p1 = new pair();
      p1.ht = height;
      p1.isbal = isbal;
      return p1;
    } 
    public static boolean Isbal = true;  //by travel and change 
    public static int isbalanced2(BinaryTreeNode<Integer> root)
    {
        if(root == null)
        {
            return 0;
        }
        int lh = isbalanced2(root.left);
        int rh = isbalanced2(root.right);
        Isbal = Math.abs(lh - rh) <= 1; //if gap between left and right height exceeds by 1 then Isbal is false 
        int height = Math.max(lh, rh) + 1;
        return height;
    }

 }
