package Binarytrees;
import java.util.*;
public class KthAncestorofaNode 
{
   public static int k;
   static BinaryTreeNode<Integer> temp = null;
   public static BinaryTreeNode<Integer> KthAncestorofTargetNode(BinaryTreeNode<Integer> root,BinaryTreeNode<Integer> targetnode)
   {
      if(root == null)
      {
          return null;
      }
      if(root.data == targetnode.data || (temp = KthAncestorofTargetNode(root.left, targetnode)) != null || (temp = KthAncestorofTargetNode(root.right, targetnode)) != null)
      {
         if(k > 0)
         {
             k--;
         }
         else if(k == 0)
         {
            System.out.println(root.data);
            return null;
         }
         return root;
      }
      return null;
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
     System.out.println("enter the target node");
     int data = sc.nextInt();
     BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(data);
     BinaryTreeNode<Integer> ansnode = KthAncestorofaNode(root, node);
     if(ansnode != null)
     {
        System.out.println("-1");
     }

    }
}


