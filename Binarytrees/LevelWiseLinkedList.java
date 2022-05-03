package Binarytrees;
import java.util.*;
public class LevelWiseLinkedList {

    public static ArrayList<Node<BinaryTreeNode<Integer>>> SeperateLinkedLists(BinaryTreeNode<Integer> root)    //function that will return ArrayList of LinkedList Node those Nodes have data type of BinaryTreeNode<Integer>
    {
       Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();   //in queue we have to add BinaryTreeNode<Integer> type of Nodes 
       ArrayList<Node<BinaryTreeNode<Integer>>> ans = new ArrayList<>(); //ArrayList of LinkedList Node those Nodes have data type of BinaryTreeNode<Integer>
       queue.add(root); //first we will add root 
       queue.add(null); //then we will add null as it will help that if we find null that will be act as a breaking point of first level our one linked list is ready to be added in list 
       Node<BinaryTreeNode<Integer>> head = null; //Linked list head inititally null 
       Node<BinaryTreeNode<Integer>> tail = null; //Linked list tail initially null 
       while(!queue.isEmpty())
       {
        BinaryTreeNode<Integer> temp = null; 
        temp = queue.remove();  //removing the element on peek 
        if(temp == null)  //if the removing is done second time of execution then temp will have null in it 
        {
           ans.add(head); //here we will add the head which have some value in it as it was first gone to else part 
           if(queue.isEmpty()) ///now we will check if queue is empty then we will exit from the loop as there is no other level to be converted into linked list 
           {
               break;
           }
           head = null; //when our current head is added into the arraylist make head points to null because on the third time of execution when temp is not null on the second level then in the if(head == null) is checked then only left node of second level will be new tail and head 
           tail = null; 
           queue.add(null); //when the temp == null is used as a breaking point one time in the first level then we will add one null at the end of every level 
           continue; 
        }
        else
        {
            if(temp.left != null)
            {
              queue.add(temp.left);  //adding left node
            }
            if(temp.right != null)
            {
                queue.add(temp.right); //adding right node 
            }
           Node<BinaryTreeNode<Integer>> arr = new Node<BinaryTreeNode<Integer>>(temp);
           if(head == null)  //at the first time our head is initially null so our root of first level will be head as well as tail and on the second level our head is initially null too so again this if will executed 
           {
               head = arr;
               tail = arr;
           }
           else 
           {
               tail.next = arr; //on the third step of dry run when left node of second level is tail we will attach the tail with the new node which will be right node of second level  
               tail = tail.next; //then tail will have the address of that rightwards node of the second level 
            }
          
        }
       }
         return ans;

    }
}
