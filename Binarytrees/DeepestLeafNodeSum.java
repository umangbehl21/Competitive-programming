package Binarytrees;

public class DeepestLeafNodeSum {
    public static int height(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        return 1 + Math.max(left, right);

    }

    public static int helper(BinaryTreeNode<Integer> root, int height) {
        if (root == null) {
            return 0;
        }
        if (height == 1) {
            return root.data;
        }
        int left = helper(root.left, height - 1);
        int right = helper(root.right, height - 1);
        return left + right;
    }

    public static int deepestLeavesSum(BinaryTreeNode<Integer> root) {

        int height = height(root);
        return helper(root, height);

    }
}

