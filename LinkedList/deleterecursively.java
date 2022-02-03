package Linkedlist;

public class deleterecursively {
    public Node<Integer> removeElements(Node<Integer> head, int val) {
        if(head == null)
        {
            return head;
        }
        head.next = removeElements(head.next,val);
        if(head.data == val)
        {
            return head.next;
        }
        else
        {
            return head;
        }
    }
}
