package Linkedlist;

public class deleteiteratively {
    public Node<Integer> removeElements(Node<Integer> head, int val) {
        if(head == null)
        {
            return head;
        }
        Node<Integer> dummy = new Node<Integer>(-1);
        dummy.next = head;
        Node<Integer> tail = dummy;
        while(tail != null && tail.next != null)
        {
            if(tail.next.data == val)
            {
                Node<Integer> temp = tail.next;
                tail.next = temp.next;
            }
            else
            {
                tail = tail.next;
            }
        }
        return dummy.next;
        
    }
}
