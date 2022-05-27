package BST;

import java.util.ArrayList;

import Binarytrees.BinaryTreeLevelwiseInput;
import Binarytrees.BinaryTreeNode;

public class RangeSumOfBst {
    static ArrayList<Integer> ans = new ArrayList<>();
    public static int rangeSum(BinaryTreeNode<Integer> root, int low, int high) {
        // Write your code here.
        if(root == null)
        {
            return 0;
        }
        int sum = 0;
        if(root.data >= low && root.data <= high)
        {
            ans.add(root.data);  //also storing the nodes in that range 
            sum = root.data; //and also counting their sum 
        }
        sum += rangeSum(root.left,low,high);
        sum += rangeSum(root.right,low,high);
        return sum;
    }
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeLevelwiseInput.LevelWiseInput();
        System.out.println(rangeSum(root, 2,4)); 
        System.out.println(ans);

    }
}
