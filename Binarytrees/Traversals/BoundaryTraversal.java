package Binarytrees.Traversals;

import java.util.*;

public class BoundaryTraversal
 {
     public static void LeftBoundary(BinaryTreeNode<Integer> root,ArrayList<Integer> ans)
     {
         BinaryTreeNode<Integer> curr = root;
         while(curr.left != null || curr.right != null)
         {
            if(curr.left != null)
            {
                curr = curr.left;
                if(curr.left != null || curr.right != null)
                {
                    ans.add(curr.data);
                } 
            }
            else
            {
                curr = curr.right;
                if(curr.right != null || curr.left != null)
                {
                    ans.add(curr.data);
                } 
            }
            // if(curr.left.left == null && curr.right.right == null)
            // {
            //     break;
            // }
         }
         

     }
     public static void LeafNodes(BinaryTreeNode<Integer> root,ArrayList<Integer> res)
     {
        if(root == null)
        {
            return;
        }
        if(root.left == null && root.right == null)
        {
        res.add(root.data);
        }
        LeafNodes(root.left, res);
        LeafNodes(root.right, res);
     }
     public static void RightBoundary(BinaryTreeNode<Integer> root,ArrayList<Integer> res)
     {
         Stack<Integer> copy = new Stack<>();
        BinaryTreeNode<Integer> curr = root;
        while(curr.left != null || curr.right != null)
        {
            if(curr.right != null)
            {
                curr = curr.right;
                if(curr.right != null || curr.left != null)
                {
                    copy.push(curr.data);
                } 
            }
            else 
            {
                curr = curr.left;
                if(curr.left != null || curr.right != null)
                {
                    copy.push(curr.data);
                } 
            }

        }
             while(!copy.isEmpty())
             {
             res.add(copy.pop());
             }

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
     public static void BoundaryTraverse(BinaryTreeNode<Integer> root,ArrayList<Integer> ans)
     {
     if(root == null)
     {
         return;
     }
     else
     {
         ans.add(root.data);
     }
     LeftBoundary(root, ans);
     LeafNodes(root, ans);
     RightBoundary(root, ans);
     }
     public static void main(String[] args) {
         BinaryTreeNode<Integer> root = LevelWiseInput();
         ArrayList<Integer> ans = new ArrayList<>();
         BoundaryTraverse(root, ans);
         System.out.println(ans);
     }


}
