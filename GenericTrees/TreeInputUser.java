package GenericTrees;

import java.util.Scanner;

public class TreeInputUser 
{
   public static TreeNode<Integer> input()
   {
       Scanner sc = new Scanner(System.in);
       System.out.println("enter next Node data");
       int data = sc.nextInt();
       TreeNode<Integer> root = new TreeNode<Integer>(data);
       System.out.println("enter the number of childs of" + data);
       int childcount = sc.nextInt();
       for(int i = 0;i<childcount;i++)
       {
           TreeNode<Integer> child = input();  //collecting the adress of child
           root.children.add(child); //adding it in the parent ArrayList 
       }
       return root;

   }
   public static void print(TreeNode<Integer> root)
   {
      String s = root.data + " : ";
      for(int i = 0;i<root.children.size();i++)
      {
        s = s + root.children.get(i).data+","; //by root.children.get(i) we get the TreeNode for an ith index and from .data we get the Interger value 
      }
      System.out.println(s);
      for(int i = 0;i<root.children.size();i++)
      {
        print(root.children.get(i));
      }
   }
   public static void main(String[] args) {
       TreeNode<Integer> root = input();
       print(root);
   }
}
