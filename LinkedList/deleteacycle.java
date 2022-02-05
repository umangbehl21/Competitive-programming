package Linkedlist;

public class deleteacycle {
    public static void  removeLoop(Node<Integer> head)  //hare and tortoise floyds algo
    {

        // If list is empty or has only one node
        // without loop
        if (head == null || head.next == null)
            return; 

        Node<Integer> slow = head, fast = head;
        while (fast != null && fast.next != null) {
          

            slow = slow.next;
            fast = fast.next.next;
              if (slow == fast)
                break;
        }

       
        if (slow == fast) {
            slow = head;
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
