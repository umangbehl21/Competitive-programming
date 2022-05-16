package Binarytrees;
import java.util.*;
public class LowestCommonAncestor
{
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
    public static BinaryTreeNode<Integer> Lowestcommonancestor(BinaryTreeNode<Integer> root,BinaryTreeNode<Integer> node1,BinaryTreeNode<Integer> node2)
    {
     
        if(root == null || root.data == node1.data || root.data == node2.data)
        {
           return root;
        }
       BinaryTreeNode<Integer> lans = Lowestcommonancestor(root.left, node1, node2);
       BinaryTreeNode<Integer> rans = Lowestcommonancestor(root.right, node1, node2);
       if(lans == null)  //if left ans is null return rans whether its null or not 
       {
           return rans;
       }
       else if(rans == null)  //if right ans is null return left ans 
       {
           return lans;
       }
       else
       {
           return root;  //if both are not null then return root that will be our common ancestor because as we know if both the child return not null then only we can declare root as ancestor 
       }
    
    }
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = LevelWiseInput();
        Scanner sc = new Scanner(System.in);
        System.out.println("enter node1");
        int data = sc.nextInt();
        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<Integer>(data);
        System.out.println("enter node2");
        int data1 = sc.nextInt();
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<Integer>(data1);
        BinaryTreeNode<Integer> ansnode = Lowestcommonancestor(root, node1, node2);
        System.out.println(ansnode.data);
    }
}
