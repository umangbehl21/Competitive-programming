package GenericTrees;
import java.util.*;
public class TreeLevelWise {   //functions are implemented with help of queue as level order traversal follows first in first out 
    public static TreeNode<Integer> inputlevelwise()  //Algo is 
    {                                                 //add root element in queue
        Scanner sc = new Scanner(System.in);          //then dequeue it inside loop and ask its number of children 
        System.out.println("enter root data");        //use for loop to enter multiple childrens 
        int rootdata = sc.nextInt();                  //in the end add that child in the root arraylist to make link 
        Queue<TreeNode<Integer>> pendingnodes = new LinkedList<>(); //and enqueue them in queue so that loop can run for them next time and it can ask their children too 
        TreeNode<Integer> root = new TreeNode<>(rootdata); 
        pendingnodes.add(root);
        while(!pendingnodes.isEmpty())
        {
            TreeNode<Integer> frontnode = pendingnodes.remove();
            System.out.println("enter the number of children of" + frontnode.data);
            int numchild = sc.nextInt();
            for(int i = 0;i<numchild;i++)
            {
                System.out.println("enter the "+(i+1)+"th node");
                int childdata = sc.nextInt();
                TreeNode<Integer> child = new TreeNode<Integer>(childdata);
                frontnode.children.add(child);
                pendingnodes.add(child);
            }
        }
        return root;
    }
    public static void print(TreeNode<Integer> root)
    {
        Queue<TreeNode<Integer>> pendingnodes = new LinkedList<>(); 
        pendingnodes.add(root);   //add root in queue 
        while(!pendingnodes.isEmpty())
        {
            TreeNode<Integer> frontnode = pendingnodes.remove();   //dequeue it 
            String s = frontnode.data + ":";  //make string appending root data which is dequeued in frontnode 
            for(int i = 0;i<frontnode.children.size();i++)
             {
                s += frontnode.children.get(i).data + ","; //if root have child its child data will be appended in tue String 
                pendingnodes.add(frontnode.children.get(i)); //dont forgot to add the root's child into queue because they also have child to be printed
             }
             System.out.println(s); //in the end after appending all children string will be printed here 
        }
    }
    public static int CountNodes(TreeNode<Integer> root)
    {
        if(root == null) //this is not a basecase this is an edge case our for loop is handling the base case as if there are no children of a node it will return count without entering for loop 
        {
            return 0;
        }
        int count = 1;
        for(int i = 0;i<root.children.size();i++)
        {
            count += CountNodes(root.children.get(i));
        }
        return count;

    }
    public static int largest(TreeNode<Integer> root)
    {
       if(root == null)
       {
           return Integer.MIN_VALUE;
       }
       int ans = root.data;
       for(int i = 0;i<root.children.size();i++)  //for loop is base case if a root don't have children it will return its data in answer which will be later compared inside the loop by the parent node 
       {
           int largerchild = largest(root.children.get(i));
           if(largerchild > ans)
            {
               ans = largerchild;
            }
       }
       return ans;
    }
    public static int HeightofTree(TreeNode<Integer> root)
    {
        if(root == null)
        {
            return 0;
        }
        if(root.children.size() == 0)  //if node have no children return 1 as height of single node is one 
        {
            return 1;
        }
        int ans = 0;
        for(int i = 0;i<root.children.size();i++)  //height is greater between left subtree and right subtree + 1 
        {
            ans = Math.max(ans,HeightofTree(root.children.get(i)));  
        }
        return ans + 1;
    }
    public static void NodesAtKdepth(TreeNode<Integer> root,int k)
    {
       if(k < 0)
       {
           return;
       }
       if(k == 0)
       {
           System.out.println(root.data);
           return;
       }
       for(int i = 0;i<root.children.size();i++)
       {
           NodesAtKdepth(root.children.get(i), k-1);
       }

    }
    public static int CountLeafNodes(TreeNode<Integer> root)
    {
        if(root == null)
        {
            return 0;
        }
        if(root.children.size() == 0)  //if a node have no children its ArrayList size will be zero and a node having no child is leaf node 
        {
            return 1;
        }
        int count = 0;
        for(int i = 0;i<root.children.size();i++)
        {
            count += CountLeafNodes(root.children.get(i));
        }
        return count;
    }
    public static void preorder(TreeNode<Integer> root)
    {
        if(root == null) //this is edge case not base case
        {
            return;
        }
        System.out.println(root.data);
        for(int i = 0;i<root.children.size();i++)
        {
            preorder(root.children.get(i));
        }
    }
    public static void postorder(TreeNode<Integer> root)
    {
        if(root == null)
        {
            return;
        }
        for(int i = 0;i<root.children.size();i++)
        {
           postorder(root.children.get(i));
        }
        System.out.println(root.data);
        
    }
    public static int greater(TreeNode<Integer> root,int x)
    {
        if(root == null)
        {
            return 0;
        }
        int count = 0;
        if(root.data > x)
        {
            count++;
        }
        for(int i = 0;i<root.children.size();i++)
        {
            count += greater(root.children.get(i), x);
        }
        return count; 
    }
    public static int SumOfNodes(TreeNode<Integer> root)
    {
        if(root == null)
        {
            return 0;
        }
        int sum = root.data;
        for(int i = 0;i<root.children.size();i++)
        {
            sum += SumOfNodes(root.children.get(i));
        }
        return sum;
    }
    public static boolean iscontain(TreeNode<Integer> root,int num)
    {
       if(root.data == num)
       {
           return true;
       }
       for(int i = 0;i<root.children.size();i++)
       {
          boolean check = iscontain(root.children.get(i), num); //here we cannot blindly return the smallans because it may happen we find our node data same as num very deeper in tree so we cannot return false seeing the data of one child 
          if(check == true) //so if smallans is true then only we will return true otherwise after the end of for loop parent function will return false itself
          {
              return true;
          }
       }
         return false;
    }
    public static void main(String[] args) {
        TreeNode<Integer> root = inputlevelwise();
        print(root);
        System.out.println("number of nodes are "+CountNodes(root));
        System.out.println("largest node is "+ largest(root));
        System.out.println("height of tree is "+ HeightofTree(root));
        System.out.println("Nodes at Kth depth are ");
        NodesAtKdepth(root, 2);
        System.out.println("leaf nodes are "+CountLeafNodes(root));
        System.out.println("postorder is");
        postorder(root);
        System.out.println("preorder is");
        preorder(root);
        System.out.println("number of elements greater than x "+greater(root, 2));
        System.out.println("sum of nodes are "+SumOfNodes(root));
        System.out.println("iscotain "+iscontain(root, 7));

    }

}
