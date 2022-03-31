package GenericTrees;
import java.util.*;
public class TreeLevelWise {
    public static TreeNode<Integer> inputlevelwise()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter root data");
        int rootdata = sc.nextInt();
        Queue<TreeNode<Integer>> pendingnodes = new LinkedList<>();
        TreeNode<Integer> root = new TreeNode<>(rootdata); 
        pendingnodes.add(root);
        while(!pendingnodes.isEmpty())
        {
            TreeNode<Integer> frontnode = pendingnodes.remove();
            System.out.println("enter the number of children of" + frontnode.data);
            int numchild = sc.nextInt();
            for(int i = 0;i<numchild;i++)
            {
                System.out.println("enter the "+(i+1)+"th node");
                int childdata = sc.nextInt();
                TreeNode<Integer> child = new TreeNode<Integer>(childdata);
                frontnode.children.add(child);
                pendingnodes.add(child);
            }
        }
        return root;
    }
    public static void print(TreeNode<Integer> root)
    {
        Queue<TreeNode<Integer>> pendingnodes = new LinkedList<>();
        pendingnodes.add(root);
        while(!pendingnodes.isEmpty())
        {
            TreeNode<Integer> frontnode = pendingnodes.remove();
            String s = frontnode.data + ":";
            for(int i = 0;i<frontnode.children.size();i++)
             {
                s += frontnode.children.get(i).data + ",";
                pendingnodes.add(frontnode.children.get(i));
             }
             System.out.println(s);
        }
    }
    public static void main(String[] args) {
        TreeNode<Integer> root = inputlevelwise();
        print(root);
    }

}
