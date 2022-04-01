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
        if(root.children == null)
        {
            return 1;
        }
        int ans = 0;
        for(int i = 0;i<root.children.size();i++)
        {
            ans = Math.max(ans,HeightofTree(root.children.get(i)));
        }
        return ans + 1;
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
    public static void main(String[] args) {
        TreeNode<Integer> root = inputlevelwise();
        print(root);
        System.out.println("number of nodes are "+CountNodes(root));
    }

}
