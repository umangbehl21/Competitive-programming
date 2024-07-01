
// Initial Template for Java
import java.util.*;

class Tree {
    int data;
    Tree left;
    Tree right;

    Tree(int d) {
        data = d;
        left = null;
        right = null;
    }
}

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}


// } Driver Code Ends
// User function Template for Java
class Solution {
       public Tree convert(Node head, Tree node) {
        
        ArrayList<Node> list = new ArrayList<>();   //list to store linked list node 
        
        ArrayList<Tree> tlist = new ArrayList<>();  //list to store Tree Node reference we dont create new treenode if we do so we lost the reference
        
        while(head != null)
        {
            list.add(head);
            head = head.next;
        }
        // System.out.println(list.size());
        Tree rootnode = new Tree(list.get(0).data);
        tlist.add(rootnode);
        Tree ans = new Tree(-1);
        for(int i = 0;i<list.size();i++)
        {
            
            int Lidx = 2 * i + 1;
            int Ridx = 2 * i + 2;
            rootnode = tlist.get(i);
           
            if(i == 0)
            {
                ans = rootnode;
            }
            Tree leftnode;
            Tree rightnode;
            if(Lidx < list.size())
            {
                Node lc = list.get(Lidx); 
                leftnode = new Tree(lc.data);
            }
            else 
            {
                leftnode = null;
            }
            if(Ridx < list.size())
            {
                Node rc = list.get(Ridx);
                rightnode = new Tree(rc.data);
            }
            else 
            {
                rightnode = null;
            }
            rootnode.left = leftnode;
            rootnode.right = rightnode;
            tlist.add(leftnode);  //list to store Tree Node reference we dont create new treenode if we do so we lost the reference so when we attach leftchild and rightchild to the root we add the reference of leftchild and rightchild and then retrieve them by iterating over tlist
            tlist.add(rightnode);
            // if(rootnode.left != null)
            
            //  System.out.println(rootnode.data + "L: " +rootnode.left.data);
            //  if(rootnode.right != null)
            //   System.out.println(rootnode.data + "R: " +rootnode.right.data);
             
        }
        return ans;
}
}


//{ Driver Code Starts.
class GFG {
    static Node lhead;
    static Queue<Tree> queue = new LinkedList<Tree>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            Tree node = null;
            lhead = null;
            Node head = null;
            while (!queue.isEmpty()) {
                queue.poll();
            }
            int n = sc.nextInt();
            if (n != 0) {
                GFG llist = new GFG();
                int a1 = sc.nextInt();
                head = new Node(a1);
                llist.addToTheLast(head);
                lhead = head;
                for (int i = 1; i < n; i++) {
                    int a = sc.nextInt();
                    llist.addToTheLast(new Node(a));
                }
            }
            Solution g = new Solution();
            Tree root = g.convert(lhead, node);
            try {
                levelOrder(root, n);
            } catch (NullPointerException ex) {
                System.out.println(-1);
            }
            System.out.println();
        }
    }

    public static void levelOrder(Tree root, int n) {
        queue.add(root);
        while (!queue.isEmpty() && n-- > 0) {
            Tree proot = queue.remove();
            try {
                queue.add(proot.left);
                queue.add(proot.right);
                System.out.print(proot.data + " ");
            } catch (NullPointerException ex) {
            }
        }
    }

    public void addToTheLast(Node head) {
        if (lhead == null)
            lhead = head;
        else {
            Node temp = lhead;
            while (temp.next != null) temp = temp.next;
            temp.next = head;
        }
    }
}
// } Driver Code Ends