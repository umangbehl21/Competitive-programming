package Binarytrees;

import java.util.*;


public class BinaryTreeLevelwiseInput {
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
    public static void print(BinaryTreeNode<Integer> root)
    {
        Queue<BinaryTreeNode<Integer>> pendingnodes = new LinkedList<>();
        pendingnodes.add(root);
        while(!pendingnodes.isEmpty())
        {
            BinaryTreeNode<Integer> frontnode = pendingnodes.remove();
            String s = frontnode.data + ":";
            if(frontnode.left != null)
            {
              s += frontnode.left.data + "L" + ",";
              pendingnodes.add(frontnode.left);
            }
            if(frontnode.right != null)
            {
                s += frontnode.right.data + "R";
                pendingnodes.add(frontnode.right);
            }
            System.out.println(s);
        }
        
    }
    public static void main(String[] args) {
      BinaryTreeNode<Integer> root = LevelWiseInput();
      print(root);

    }
}
