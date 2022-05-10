package Binarytrees;

public class DeletenewandoldLeafNodes {
    public static BinaryTreeNode<Integer> deleteleafnodes(BinaryTreeNode<Integer> root, int x)  //delete the leaf node with the data same as x and if the newly form leaf nodes have value x then also delete them 
    {
        if(root == null)
		{
			return null;
		}
		if(root.data == x && root.left == null && root.right == null)  //if a node has same value as x as well it is a leaf node return null 
		{
			return null;
		}
		root.left = deleteleafnodes(root.left,x); 
		root.right = deleteleafnodes(root.right,x);
	    if(root.data == x && root.left == null && root.right == null) //if after deleting a leaf node a newly formed leaf node also have value x then delete it too 
		{
			return null;
		}
		return root; 
    }
}
