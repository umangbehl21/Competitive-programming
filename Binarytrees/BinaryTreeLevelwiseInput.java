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
    public static int countnodes(BinaryTreeNode<Integer> root)
    {
       if(root == null)
       {
          return 0;
       }
       int count = 1;
       count += countnodes(root.left);
       count += countnodes(root.right);
       return count;

    }
    public static int height(BinaryTreeNode<Integer> root)
    {
         if(root == null)
         {
             return 0;
         }
         int h1 = height(root.left);  
         int h2 = height(root.right);
         return Math.max(h1, h2) + 1;  //height of a tree is maximum between left height and right height + 1 it will happen that between left or right side one side have more nodes so we have to take maximum and check 
    }
    public static int diameter(BinaryTreeNode<Integer> root)  //its Time Complexity is n * height of tree more is the height of tree more it will get worse as we are calling height redundantly it is not an optimal soultion 
    {
        if(root == null)
        {
            return 0;
        }
        int option1 = height(root.left) + height(root.right);  //first option of diameter if root left node and root right node are farthest from each other then diameter will be the sum of both 
        int option2 = height(root.left); //otherwise root left can have nodes which are farthest from each other 
        int option3 = height(root.right); //same goes for root right
        return Math.max(option1, Math.max(option2, option3)) + 1; //height is the maximum between three + 1 
    }
    public static pair<Integer,Integer> heightdiameter(BinaryTreeNode<Integer> root)
    {
       if(root == null)
       {
           pair<Integer,Integer> output = new pair<>();
           output.first = 0;
           output.second = 0;
           return output;
       }
       pair<Integer,Integer> lo = heightdiameter(root.left);
       pair<Integer,Integer> ro = heightdiameter(root.right);  
       int height = Math.max(lo.first,ro.first) + 1; //passing small height to parent function so left height + right height can be one option to calculate diameter  
       int option1 = lo.first + ro.first;    //three option to calculate diameter left height + right height 
       int option2 = lo.second; //or only left height 
       int option3 = ro.second; //or only right height
       int diameter = Math.max(option1, Math.max(option2, option3)); //so we have to take maximum of the above options 
       pair<Integer,Integer> output = new pair<>();
       output.first = height; 
       output.second = diameter;  
       return output;
    }
    public static void inorder(BinaryTreeNode<Integer> root)
    {
        if(root == null)
        {
            return;
        }
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }
    public static void preorder(BinaryTreeNode<Integer> root)
    {
        if(root == null)
        {
            return;
        }
        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }
    public static void postorder(BinaryTreeNode<Integer> root)
    {
        if(root == null)
        { 
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.data);
    }
    public static void main(String[] args) {
      BinaryTreeNode<Integer> root = LevelWiseInput();
      print(root);
      pair<Integer,Integer> output = heightdiameter(root);
      System.out.println("Diameter is "+output.second);
      System.out.println("height is "+output.first);
      inorder(root);

    }
}
