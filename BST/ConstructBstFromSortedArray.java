package BST;

import Binarytrees.BinaryTreeLevelwiseInput;
import Binarytrees.BinaryTreeNode;

public class ConstructBstFromSortedArray 
{
    public static int mid(int arr[],int si,int ei)
    {
        int mid  = (si + ei)/2;
       
        return mid;
    }
    public static BinaryTreeNode<Integer> construct(int arr[],int si,int ei)
    {
       if(si > ei || ei < si)  //if si becomes greater than ei which can be in case when we are calling right or if ei becomes less than si which can be in case when we call left return null 
       {
           return null;
       }
       int mid = mid(arr,si,ei); //find mid of sub array 
       BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(arr[mid]); //make the node of mid element 
       root.left = construct(arr, si, mid-1);  //attach to root's left 
       root.right = construct(arr, mid + 1, ei); //attach to root's right
       return root;  
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7};
        BinaryTreeNode<Integer> root = construct(arr, 0 , arr.length - 1);
        BinaryTreeLevelwiseInput.print(root);

    }

}
 