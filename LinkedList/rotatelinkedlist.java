package Linkedlist;

public class rotatelinkedlist {
    public Node<Integer> rotateRight(Node<Integer> head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        int l = 1;
        Node<Integer> temp = head;
        while (temp.next != null) {
            l++;
            temp = temp.next;
        }
        temp.next = head; //our temp is on last node we point it to head 
        k = k % l;  //if the number of rotations is more we can reduce it by k modulo length because if we rotate a linked list 5 times or 100 times it will come back to its orignal form 12 % 5 = 2 now we only have to rotate 2 times 
        k = l - k; //k = 5-2 example length is 5 and we have to rotate last two nodes now if we subtract that two nodes from the total length remaing nodes are that we dont want to rotate
        while (k > 0) { //until we reach that node whose next is our new head and then we can break the link we increment the temp and reduce the kth distance by 1
            k--;
            temp = temp.next;
        }
        head = temp.next; // now our new head is that nodes next
        temp.next = null; // and now our head is on its correct position we can break its next link
        return head;
    }
}
