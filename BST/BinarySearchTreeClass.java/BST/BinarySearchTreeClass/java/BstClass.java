import Binarytrees.BinaryTreeNode;

public class BstClass {
    
    private BinaryTreeNode<Integer> root;  //all are non static data member and mebmber functions
    public void insert(int data)
    {
      inserthelper(root,data);
    }
    public BinaryTreeNode<Integer> inserthelper(BinaryTreeNode<Integer> root,int data)
    {
        if(root == null)
        {
            root = new BinaryTreeNode<Integer>(data);
            return root;
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
         if(data == root.data)
         {
             return null;
         }
         if(data > root.data)
         {
            root.right = deletehelper(root.right, data);
         }
         else
         {
            root.left = deletehelper(root.left, data);
         }
         return root;

    }
    public void delete(int data)
    {  
       deletehelper(root, data);
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
