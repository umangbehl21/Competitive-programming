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
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public static void preorder(BinaryTreeNode<Integer> root)
    {
        if(root == null)
        {
            return;
        }
        System.out.print(root.data + " ");
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
        System.out.print(root.data + " ");
    }
    public static BinaryTreeNode<Integer> buildtreehelper(int in[],int pre[])
    {
       return buildtree(in,pre,0,in.length-1,0,pre.length-1);
    }
    private static BinaryTreeNode<Integer> buildtree(int in[],int pre[],int inS,int inE,int preS,int preE)
    {
       if(inS > inE)
       {
          return null;
       }
       int rootindex = -1;
       int rootdata = pre[preS];
       BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootdata);
       for(int i = inS;i<=inE;i++)
       {
          if(rootdata == in[i])
          {
              rootindex = i;
              break;
          }
       }
       int liS = inS;
       int liE = rootindex - 1;
       int lpS = preS + 1;
       int lpe = liE - liS + lpS;
       int ris = rootindex + 1;
       int riE = inE;
       int rpS = lpe + 1;
       int rpE = preE;
       root.left = buildtree(in, pre, liS, liE, lpS, lpe);
       root.right = buildtree(in, pre, ris, riE, rpS, rpE);
       return root;
        
    }
    public static BinaryTreeNode<Integer> BuildTreeFromPostOrder(int in[],int po[])
    {
        return BuildTreeFromPostOrderhelp(in, po,0,in.length-1,0,po.length-1);
    }
    private static BinaryTreeNode<Integer> BuildTreeFromPostOrderhelp(int in[],int po[],int inS,int inE,int poS,int poE)
    { 
        if(inS > inE)
        {
            return null;
        }
        int rootdata = po[poE];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootdata);
        int rootindex = -1;
        for(int i = inS;i<=inE;i++)  //when third recursive call is made inorder start become equal to inorder end so we will write <= in condition 
        {
             if(rootdata == in[i])
              {
                  rootindex = i;
                  break;
              }
        }
        int leftins = inS;
        int leftinE = rootindex - 1;
        int leftpoS = poS;
        int leftpoE = leftinE - leftins + leftpoS;
        int rightinS = rootindex + 1;
        int rightinE = inE;
        int rightpoS = leftpoE + 1;
        int rightpoE = poE - 1;
        root.left = BuildTreeFromPostOrderhelp(in, po,leftins, leftinE, leftpoS, leftpoE);
        root.right = BuildTreeFromPostOrderhelp(in, po, rightinS, rightinE, rightpoS, rightpoE);
        return root;
    }
    public static void MirrorBinaryTree(BinaryTreeNode<Integer> root)
    {
        if(root == null)
        {
            return;
        }
        MirrorBinaryTree(root.left);
        MirrorBinaryTree(root.right);
        BinaryTreeNode<Integer> temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
    public static boolean IsPresent(BinaryTreeNode<Integer> root,int data)
    {
        if(root == null)
        {
            return false;
        }
        if(root.data == data)
        {
            return true;
        }
        boolean Lsmallans = IsPresent(root.left,data);
        if(Lsmallans == true)
        {
            return true;
        }
        boolean Rsmallans = IsPresent(root.right, data);
        if(Rsmallans == true)
        {
            return true;
        }
        return false;

    }
    public static void main(String[] args) {
    //   BinaryTreeNode<Integer> root = LevelWiseInput();
    //   print(root);
    //   pair<Integer,Integer> output = heightdiameter(root);
    //   System.out.println("Diameter is "+output.second);
    //   System.out.println("height is "+output.first);
    //   System.out.println("inorder");
    //   inorder(root);
    //   System.out.println("postorder");
    //   postorder(root);
    //   System.out.println("preorder");
    //   preorder(root);
    // int in[] = {4,2,5,1,6,3,7};
    // int pre[] = {1,2,4,5,3,6,7};
    // BinaryTreeNode<Integer> root = buildtreehelper(in, pre);
    // print(root);
    int in1[] = {4,2,5,1,6,3,7};
    int po[] = { 4,5,2,6,7,3,1};
    BinaryTreeNode<Integer> root = BuildTreeFromPostOrder(in1, po);
    print(root);
    // System.out.println(IsPresent(root, 4));

    }
}
