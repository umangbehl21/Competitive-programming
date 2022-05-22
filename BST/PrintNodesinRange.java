package BST;

import java.util.ArrayList;

import Binarytrees.BinaryTreeLevelwiseInput;
import Binarytrees.BinaryTreeNode;

public class PrintNodesinRange {
    public static void  printrange(BinaryTreeNode<Integer> root,int lowerlim,int upperlim)
    {
    
        if(root == null)
        {
            return;
        }
        if(root.data >= lowerlim && root.data <= upperlim)
        {
            System.out.println(root.data);
            // printrange(root.left, lowerlim, upperlim); //can also write here 
            // printrange(root.right, lowerlim, upperlim);
        }
        if(upperlim < root.data)  //if upperlim is less than root data go on left as lower limit will be more smaller and on right all element are greater 
        {
           printrange(root.left, lowerlim, upperlim);
        }
        else if(lowerlim > root.data)  //if lower lim is greater than root data go on right 
        {
            printrange(root.right, lowerlim, upperlim);
         }
         printrange(root.left, lowerlim, upperlim);  //else if range is including the root is on the left as well as right side call call on both 
         printrange(root.right, lowerlim, upperlim);

    }
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = Levelwiseinput.levelwise();
        printrange(root, 2, 8);
    }
}
