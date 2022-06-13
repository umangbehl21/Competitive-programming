package Linkedlist;

public class MergeTwoSortedLL {
    public static Node<Integer> meregesortedll(Node<Integer> head1, Node<Integer> head2) {
        if (head1 == null || head2 == null) {
            return head1 != null ? head1 : head2;
        }
        Node<Integer> c1 = head1;
        Node<Integer> c2 = head2;
        Node<Integer> dummy = new Node<>(-1);
        Node<Integer> prev = dummy;
        while (c1 != null && c2 != null) {
            if (c1.data < c2.data) {
                prev.next = c1;
                c1 = c1.next;
            } else {
                prev.next = c2;
                c2 = c2.next;
            }
            prev = prev.next;

        }
        prev.next = c1 != null ? c1 : c2; // hoskta hai ek list jo hai uska pointer null pr ajae toh hum prev ke next me
                                          // vo list attach kradege jo list bachi hui hai c1 bachi hai to c1 nhi toh c2
        return dummy.next;
    }
}
