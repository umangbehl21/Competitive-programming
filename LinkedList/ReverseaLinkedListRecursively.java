package Linkedlist;

import java.util.Scanner;

class reverselinkbetter {
    public static Node<Integer> reversebest(Node<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node<Integer> reversedtail = head.next;
        Node<Integer> smallhead = reversebest(head.next);
        reversedtail.next = head;
        head.next = null;
        return smallhead;
    }

    public static Node<Integer> takeinput() {
        Scanner sc = new Scanner(System.in);
        Node<Integer> head = null, tail = null;
        int data = sc.nextInt();
        while (data != -1) {
            Node<Integer> newnode = new Node<>(data);
            if (head == null) {
                head = newnode;
                tail = newnode;
            } else {
                tail.next = newnode;
                tail = tail.next;
            }
            data = sc.nextInt();
        }
        return head;
    }

    public static void print(Node<Integer> head) {
        Node<Integer> temp = head;
        while (temp != null) {
            System.out.println(temp.data + " ");
            temp = temp.next;
        }

    }
}
