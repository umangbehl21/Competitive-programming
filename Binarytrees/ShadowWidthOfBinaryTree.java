package Binarytrees;

public class ShadowWidthOfBinaryTree 
{   
    public static void width(BinaryTreeNode<Integer> root,int hl, int ans[]) 
    {
       if(root == null)
       {
           return;
       }                             //we have to find the minimum and maximum horizontal level so that we can calculate width  
       ans[0] = Math.min(ans[0], hl);  //min from current horizontal level of left node and previous level stored in array will be compared and updated until the root is null 
       ans[1] = Math.max(ans[1], hl); //max from current horizontal level of right node and previous level stored in array will be compared and updated until the root is null
       width(root.left,hl-1,ans);   // on going left the horizontal level decreases 
       width(root.right,hl+1,ans);  // on going right the horizontal level increases 
    }
    public static int width(BinaryTreeNode<Integer> root)
    {
        int ans[] = new int[2]; //on ans[0] we are storing min hl and ans[1] is storing max hl where hl is horizontal level 
        width(root,0,ans);  
        return ans[1] - ans[0] + 1;
        
   
    }

}
