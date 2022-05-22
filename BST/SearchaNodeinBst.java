package BST;

import Binarytrees.BinaryTreeNode;

public class SearchaNodeinBst {
    public static int search(BinaryTreeNode<Integer> root,int num)
    {
        if(root == null)
        {
            return -1;
        }
        if(root.data == num)
        {
            return root.data;
        }
        else if(num < root.data)
        {
          return search(root.left, num);
        }
          return search(root.right, num);
    }
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = Levelwiseinput.levelwise();
        System.out.println(search(root, 7));
    }
}
