package AVL_Tree;
class AvlNode
{
    AvlNode left = null;
    AvlNode right = null;
    int height = 0;
    int bal = 0;
    int data = 0;
    public AvlNode(int data)
    {
        this.data = data;

    }

}
public class AvlTree 
{
    public static void UpdateHeightandBal(AvlNode node)
    {  
       int lh = -1;
       int rh = -1;
       if(node.left != null) lh = node.left.height;
       if(node.right != null) rh = node.right.height;
       int bal = lh - rh;
       int height = Math.max(lh,rh)+1;
       node.height = height;
       node.bal = bal;
     
    }
    public static AvlNode rightrotation(AvlNode A) //for left left
    {
        AvlNode B = A.left;
        AvlNode B_right = B.right;
        B.right = A;
        A.left = B_right;
        UpdateHeightandBal(A);
        UpdateHeightandBal(B);
        return B;
    }
    public static AvlNode leftrotation(AvlNode A) //for right 
    {
        AvlNode B = A.right;
        AvlNode B_left = B.left;
        B.left = A;
        A.right =  B_left;
        UpdateHeightandBal(A);
        UpdateHeightandBal(B);
        return B;
        
    }
    public static AvlNode getrotation(AvlNode node)
    {
       UpdateHeightandBal(node); 
       if(node.bal == 2)
       { 
           if(node.left.bal == 1) //ll
           {
              return rightrotation(node);
           }
           else 
           {
              node.left = leftrotation(node.left);
              rightrotation(node);
           }
       }
       else if(node.bal == -2) //rr rl
       {
           if(node.right.bal == -1) //rr
           {
            return leftrotation(node);
           }
           else 
           {
              node.right = rightrotation(node);
              return leftrotation(node);
           }
       }
       return node;

    }



}
