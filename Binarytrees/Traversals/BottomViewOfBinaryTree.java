package Binarytrees.Traversals;
import java.util.*;

import Binarytrees.BinaryTreeNode;
class pair
{
    int lineno;
    BinaryTreeNode<Integer> node;
    public pair(int lineno,BinaryTreeNode<Integer> node)
    {
       this.node = node;
       this.lineno = lineno;
    }
}
public class BottomViewOfBinaryTree 
{
    public static ArrayList<Integer> BottomView(BinaryTreeNode<Integer> root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<pair> pendingnodes = new LinkedList<>();
        Map<Integer,Integer> map = new TreeMap<>(); //here we are using TreeMap which store the keys in sorted manner or ascending manner
        pendingnodes.add(new pair(0, root));
        while(!pendingnodes.isEmpty())
        {
            pair front = pendingnodes.remove(); 
            int linenum = front.lineno;
            BinaryTreeNode<Integer> node = front.node;//as we have to add the bottom nodes values will be overrided each time until the end node on that line gets added
                map.put(linenum, node.data);
            if(node.left != null)
            {
                pendingnodes.add(new pair(linenum - 1, node.left));
            }
            if(node.right != null)
            {
                pendingnodes.add(new pair(linenum + 1, node.right));
            }
 
        }
           for(Map.Entry<Integer,Integer> iterator : map.entrySet()) //Map.Entry<> is an iterator as we cannot iterate over map as such so it is used along with entry set function which returns the set of the map 
           {
               ans.add(iterator.getValue()); //the value of keys will come out in sorted manner  or ascending order as they are stored in TreeMap
           }
        return ans;
    }
    public static BinaryTreeNode<Integer> LevelWiseInput()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter root data");
        int data = sc.nextInt();
        if(data == -1)
        {
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(data);
        Queue<BinaryTreeNode<Integer>> pendingnodes = new LinkedList<>();
        pendingnodes.add(root);
        while(!pendingnodes.isEmpty())
        {
            BinaryTreeNode<Integer> frontnode = pendingnodes.remove();
            System.out.println("enter the left child of "+frontnode.data);
            int leftchild = sc.nextInt();
            if(leftchild != -1)
            {
                BinaryTreeNode<Integer> leftNode = new BinaryTreeNode<Integer>(leftchild);
                frontnode.left = leftNode;
                pendingnodes.add(leftNode);
            }
            System.out.println("enter the right child of" + frontnode.data);
            int rightchild = sc.nextInt();
            if(rightchild != -1)
            {
                BinaryTreeNode<Integer> rightnode = new BinaryTreeNode<Integer>(rightchild);
                frontnode.right = rightnode;
                pendingnodes.add(rightnode);
            }
        }
        return root;
    }
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = LevelWiseInput();
        ArrayList<Integer> ans = BottomView(root);
        System.out.println(ans);

    }

}
