package Binarytrees;
import java.util.*;
public class LargestNodeAtEachLevel {
    
    public static void largestRowHelper(BinaryTreeNode<Integer> root,int level,ArrayList<Integer> ans)
	{
		if(root == null)
		{
			return;
		}
		if(level < ans.size())  //this condition will be true when we go towards right as on adding left nodes of every level blindly the size of ArrayList will become more so level will be smaller than size
		{
			if(root.data > ans.get(level))
			{
				ans.set(level,root.data);
			}
		}
		else //on going left else will run as size of level will be equal to size of ArrayList at each level so if will be false and we will fill our ArrayList until last level and ArrayList size will become greater than total levels 
		{
			ans.add(root.data);
		}
		largestRowHelper(root.left, level + 1, ans);
        largestRowHelper(root.right, level + 1, ans);
	}
    
    public static void main(String[] args) {
        ArrayList<Integer> ans = new ArrayList<>();
       BinaryTreeNode<Integer> root = BinaryTreeLevelwiseInput.LevelWiseInput();
       largestRowHelper(root, 0, ans);
       System.out.println(ans); 

    }
}
