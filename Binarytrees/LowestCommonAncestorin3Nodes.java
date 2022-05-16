package Binarytrees;

public class LowestCommonAncestorin3Nodes
 {
    public static BinaryTreeNode<Integer> LowestCommonAncestor3Nodes(BinaryTreeNode<Integer> root,BinaryTreeNode<Integer> node1,BinaryTreeNode<Integer> node2,BinaryTreeNode<Integer> node3)
    {
       if(root == null || root.data == node1.data || root.data == node2.data || root.data == node3.data)
       {
         return root;  
       }
       BinaryTreeNode<Integer> lans = LowestCommonAncestor3Nodes(root, node1, node2, node3);
       BinaryTreeNode<Integer> rans = LowestCommonAncestor3Nodes(root, node1, node2, node3);
       if(lans == null)
       {
           return rans;
       }
       if(rans == null)
       {
           return lans;
       }
       else 
       {
           return root;
       }

    }

}
