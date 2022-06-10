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
    public static AvlNode rightrotation(AvlNode A) //for left left rotate right 
    {
        AvlNode B = A.left;
        AvlNode B_right = B.right;
        B.right = A;
        A.left = B_right;
        UpdateHeightandBal(A);
        UpdateHeightandBal(B);
        return B;
    }
    public static AvlNode leftrotation(AvlNode A) //for right right rotate left 
    {
        AvlNode B = A.right;
        AvlNode B_left = B.left;
        B.left = A;
        A.right =  B_left;
        UpdateHeightandBal(A); //the height and balance of B depends on A so we have to update A first then B
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
              node.left = leftrotation(node.left); //for left right there are right right nodes so we have to work on that right right to rotate it left when the three of nodes turn in left left then rotate it righwards
              rightrotation(node);
           }
       }
       else if(node.bal == -2) //rr rl
       {
           if(node.right.bal == -1) //rr
           {
            return leftrotation(node);
           }
           else //rl 
           {
              node.right = rightrotation(node);  //for right left there are left left nodes so we have to rotate it right when the three of nodes turn in right right then rotate ot left  
              return leftrotation(node);
           }
       }
       return node;

    }
    public static AvlNode addData(AvlNode root,int data)  //after adding nodes the structure of the balance of the nodes can be disturbed so we have to rotate after adding 
    {
        if(root == null)
        {
           return new AvlNode(data);
        }
        if(data < root.data)
        {
           root.left = addData(root.left, data);
        }
        else if(data > root.data)
        {
          root.right = addData(root.right, data);
        }
        root = getrotation(root);
        return root;
    }
    public static void display(AvlNode root)
    {
        if(root == null)
        {
            return;
        }
        String s = root.data + ":";
        if(root.left != null) s += root.left.data + "L,";
        if(root.right != null) s += root.right.data + "R";
        System.out.println(s);
        display(root.left);
        display(root.right);
    }
    public static AvlNode deleteNode(AvlNode root,int data) //after removing nodes the structure of the balance of the nodes can be disturbed so we have to rotate after removing
    {
        if(data < root.data)
        {
            root.left = deleteNode(root.left, data);
        }
        else if(data > root.data)
        {
           root.right =  deleteNode(root.right, data);
        }
        else 
        {
            if(root.left == null && root.right == null)
            {
                return null;
            }
            if(root.left == null)  
            {
                return root.right;
            }
            if(root.right == null)
            {
                return root.left;
            }
            else 
            {

                AvlNode minnode = root.left;
                while(minnode.right != null)
                {
                    minnode = minnode.right;
                }
                root.data = minnode.data;
                root.left = deleteNode(root.left, minnode.data);

            }
        }
        root = getrotation(root);
        return root;
    }
    public static void main(String args[])
    {
        int arr[] = {10,20,30,40,50,60,70,80,90,100};
        AvlNode root = null;
        for(int ele : arr)
        {
            root = addData(root, ele);  //adding nodes 
        }
        display(root);
        System.out.println(".........");
        System.out.println();
        for(int i = arr.length-1;i>=0;i--) //one by one deleting nodes 
        {
            root = deleteNode(root,arr[i]);
            display(root);
            System.out.println("========");
        }
    }




}
