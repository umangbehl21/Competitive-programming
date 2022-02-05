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
            slow = head; //point slow on head again 
              if (slow != fast) { //now slow will be on head and fast will be near looping point so they are not equal
                  while (slow.next != fast.next) {   //one by one steping them forward until there next is same
                      slow = slow.next;
                      fast = fast.next;
                  }
              
               fast.next = null;  //breaking the loop
            }
             
            else {  //this one will only run when tail is pointing to head 
                while(fast.next != slow) {  //when fast and slow are together on first position we can increase fast until its next becomes slow then we can break its link 
                    fast = fast.next;
                }
                fast.next = null;
            }
        }
    }
}
