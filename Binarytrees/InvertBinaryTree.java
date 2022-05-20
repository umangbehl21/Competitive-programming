package Binarytrees;

public class InvertBinaryTree {
    public static BinaryTreeNode<Integer> InvertTree(BinaryTreeNode<Integer> root)
    {
        if(root == null)
        {
            return null;
        }
        BinaryTreeNode<Integer> leftroot = InvertTree(root.left);
        BinaryTreeNode<Integer> rightroot = InvertTree(root.right);
        root.left = rightroot;
        root.right = leftroot;
        return root;
    }
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeLevelwiseInput.LevelWiseInput();
        System.out.println("before inversion");
        BinaryTreeLevelwiseInput.print(root);
        InvertTree(root);
        System.out.println("after inversion");
        BinaryTreeLevelwiseInput.print(root);

    }
}
