import Binarytrees.BinaryTreeNode;

public class BstClass {
    
    private BinaryTreeNode<Integer> root;  //all are non static data member and mebmber functions
    public void insert(int data)
    {
      root = inserthelper(root,data);
    }
    public BinaryTreeNode<Integer> inserthelper(BinaryTreeNode<Integer> root,int data)
    {
        if(root == null)
        {
            BinaryTreeNode<Integer> newnode = new BinaryTreeNode<Integer>(data);
            return newnode;
        }
        else
        { 
            if(data < root.data)
            {
              root.left = inserthelper(root.left,data);
            }
            else if(data > root.data)
            {
                root.right = inserthelper(root.right,data);
            }

        } 
        return root;


    }
    public BinaryTreeNode<Integer> deletehelper(BinaryTreeNode<Integer> root,int data)
    {
         if(root == null)
         {
             return null;
         }
         if(data > root.data)
         {
            root.right = deletehelper(root.right, data);
            return root; 
         }
         else if(data < root.data)
         {
            root.left = deletehelper(root.left, data);
            return root;        
         }
         else 
         {
             if(root.left == null && root.right == null)
             {
                 return null;
             }
             else if(root.left == null)
             {
                 return root.right;
             }
             else if(root.right == null)
             {
                 return root.left;
             }
             else
             {
                 BinaryTreeNode<Integer> minnode = root.right;
                 while(minnode.left != null)
                 {
                     minnode = minnode.left;
                 }
                 root.data = minnode.data;
                 root.right = deletehelper(root.right,minnode.data);
                 return root;
             }
         }
         

    }
    public void delete(int data)
    {  
      root = deletehelper(root, data);
    }
    public boolean searchNode(int data)
    {
        return searchNodehelper(data, root);
    }
    private boolean searchNodehelper(int data,BinaryTreeNode<Integer> root)
    {
        if(root == null)
        {
            return false;
        }
        if(root.data == data)
        {
            return true;
        }
        if(root.data < data)
        {
            return searchNodehelper(data, root.right);
        }
        else 
        {
            return searchNodehelper(data, root.left);
        }
    }

}
