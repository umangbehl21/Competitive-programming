package Linkedlist;

public class deleteacycle {
    public static void  removeLoop(Node<Integer> node)  //hare and tortoise floyds algo
    {

        // If list is empty or has only one node
        // without loop
        if (node == null || node.next == null)
            return;

        Node<Integer> slow = node, fast = node;

        slow = slow.next;
        fast = fast.next.next;

    
        while (fast != null && fast.next != null) {
          

            slow = slow.next;
            fast = fast.next.next;
              if (slow == fast)
                break;
        }

       
        if (slow == fast) {
            slow = node;
              if (slow.next != fast.next) {
                  while (slow.next != fast.next) {
                      slow = slow.next;
                      fast = fast.next;
                  }
              
               fast.next = null; 
            }
             
            else {  //this one will only run when tail is pointing to head 
                while(fast.next != slow) {
                    fast = fast.next;
                }
                fast.next = null;
            }
        }
    }
}
