package Binarytrees;
import java.util.*;
public class BoundarySum {
    public static int LeftBoundarySum(BinaryTreeNode<Integer> root)
	{
		if(root == null)
		{
			return 0;
		}
        if(root.left == null && root.right == null)
        {
            return 0;
        }
		int sum = root.data;
	    sum += LeftBoundarySum(root.left);
		if(root.left == null)
		{
			sum += RightBoundarySum(root.right);
		}
		return sum;
	}
	public static int RightBoundarySum(BinaryTreeNode<Integer> root)
	{
		if(root == null)
		{
			return 0;
		}
        if(root.left == null && root.right == null)
        {
            return 0;
        }
		int sum = root.data;
		sum += RightBoundarySum(root.right);
		if(root.right == null)
		{
		  sum += RightBoundarySum(root.left);	
		}
		return sum;
		
	}
	public static int LeafNodeBoundary(BinaryTreeNode<Integer> root)
	{
		if(root == null) 
		{ 
			return 0;  
		}
		int sum = 0;  
		if(root.left == null && root.right == null)
		{
			sum = root.data;  
			return sum;
		}
		sum += LeafNodeBoundary(root.left);
		sum += LeafNodeBoundary(root.right);
		return sum;
	}
    public static int boundarySum(BinaryTreeNode <Integer > root) {
        if(root == null)
		{
			return 0;
		}
		int sum = root.data;
		return sum+= LeftBoundarySum(root.left) + RightBoundarySum(root.right) + LeafNodeBoundary(root.left) + LeafNodeBoundary(root.right); //here we are calling leafnode for left subtree leafnode seperate and right ones seperate because if i pass root in single function then that root will be added in boundary sum function too and in leafnode(root) too
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
        System.out.println(boundarySum(root)); 
    }
}

