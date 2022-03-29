package GenericTrees;

import java.util.ArrayList;

public class TreeNode<T> {
   
    T data;
    ArrayList<TreeNode<T>> children; //every child in ArrayList will be of treenode type and its data will be of t type
    TreeNode(T data)
    {
        children = new ArrayList<>();
        this.data = data; 
    }
}
class TreeProcess
{
    public static void main(String[] args) { //use debugger to see internal working 
        TreeNode<Integer> root = new TreeNode<>(1);
        TreeNode<Integer> child1 = new TreeNode<>(2);
        TreeNode<Integer> child2 = new TreeNode<Integer>(3);
        TreeNode<Integer> child3 = new TreeNode<Integer>(4);
        root.children.add(child1); //adding elements in the ArrayList of root which are its children 
        root.children.add(child2); 
        child2.children.add(child3);
}
}
