package LinkedList;

public class removedupll {
    public Node<Integer> deleteDuplicates(Node<Integer> head) {
        if(head == null || head.next == null)
        {
            return head;
        }
        Node<Integer> ans = head;
        Node<Integer> temp = head;
        
        while(temp != null && temp.next != null)
        {
            while(temp.next != null && temp.data == temp.next.data)
            {
                temp = temp.next;
            }
            ans.next = temp.next;
            ans = ans.next;
            temp = temp.next;
        }
            return head;
            
            
        }




}
