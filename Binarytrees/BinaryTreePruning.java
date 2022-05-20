package Binarytrees;

public class BinaryTreePruning {
    public static BinaryTreeNode<Integer> pruneTree(BinaryTreeNode<Integer> root) {
        if(root == null)
        {
            return null;
        }
        root.left  = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if(root.data == 0 && root.left == null && root.right == null)
        {
           return null;
        }
        else
        {
            return root;
        }
    }
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeLevelwiseInput.LevelWiseInput();
        System.out.println("before pruning");
        BinaryTreeLevelwiseInput.print(root);
        System.out.println("after pruning");
        pruneTree(root);
        BinaryTreeLevelwiseInput.print(root);

    }
}
