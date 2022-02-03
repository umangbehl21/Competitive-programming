package Linkedlist;

class Node<t> {
    t data;
    Node<t> next; // reference to the next node in the link list
    Node<t> bottom;

    Node(t data) {
        this.data = data;
        next = null;
        bottom = null;
    }
}

public class flatterall {
{

    Node<Integer> flatten(Node<Integer> root) {
        if (root == null || root.next == null) {
            return root;
        }
        root.next = flatten(root.next);
        root = mergelist(root, root.next);

        return root;
    }

    public Node<Integer> mergelist(Node<Integer> a, Node<Integer> b) {
        Node<Integer> dummy = new Node<>(0);
        Node<Integer> prev = dummy;
        while (a != null && b != null) {
            if (a.data < b.data) {
                prev.bottom = a;
                a = a.bottom;
            } else {
                prev.bottom = b;
                b = b.bottom;
            }
            prev = prev.bottom;
        }
        prev.bottom = a != null ? a : b;
        return dummy.bottom;

    }
}
