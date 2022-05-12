package Binarytrees.Traversals;
import java.util.*;
class pair
{
   BinaryTreeNode<Integer> node = null;
   int lineno;
   public pair(BinaryTreeNode<Integer> node,int lineno)
   {
      this.lineno = lineno;
      this.node = node;
   }
}
public class TopViewBinarytree 
{
   public static ArrayList<Integer> TopView(BinaryTreeNode<Integer> root) 
   {
      ArrayList<Integer> ans = new ArrayList<>();
      if(root == null)
      {
         return ans;
      }
      Queue<pair> pendingnodes = new LinkedList<>();
      pendingnodes.add(new pair(root, 0));
      Map<Integer,Integer> map = new TreeMap<>();
      while(!pendingnodes.isEmpty())
      {
        pair it = pendingnodes.remove();
        BinaryTreeNode<Integer> temp = it.node;
        int linenum = it.lineno; 
        if(!map.containsKey(linenum)) {
           map.put(linenum, temp.data);
        }
        if(temp.left != null)
        {
           pendingnodes.add(new pair(temp.left, linenum - 1));
        }
        if(temp.right != null)
        {
           pendingnodes.add(new pair(temp.right, linenum + 1));
        }

      }
      for(Map.Entry<Integer,Integer> entry : map.entrySet())         //Map.Entry<> is an iterator used to iterate over map keys map.entryset() returns the set of the keys among values in our map 
      {
         ans.add(entry.getValue());
      }
      return ans;
   }
    

}
