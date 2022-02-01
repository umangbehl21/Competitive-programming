package first;

public class checkcycleinll {
    public boolean hasCycle(Node<Integer> head) {
        Node<Integer> slow = head;
        Node<Integer> fast = head;
        while(fast != null && fast.next != null)
        {
         slow = slow.next;
         fast = fast.next.next;
         if(slow == fast)
         {
            return true;
         }
        }
            return false; 
        }
}
