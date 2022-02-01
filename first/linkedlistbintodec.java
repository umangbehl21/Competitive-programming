package first;

import java.util.Scanner;

public class linkedlistbintodec {
    public static int getDecimalValue(Node<Integer> head) {
        int ln = length(head);
        int decval = 0;
        Node<Integer> temp = head;
        while (temp != null) {
            decval += temp.data * Math.pow(2, ln);
            temp = temp.next;
            ln--;
        }
        return decval;

    }

    public static int length(Node<Integer> head) {
        Node<Integer> temp = head;
        int ln = 0;
        while (temp.next != null) {
            temp = temp.next;
            ln++;
        }
        return ln;
    }

    public void print(Node<Integer> head) {
        Node<Integer> temp = head;
        while (temp != null) {
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
    }

    public static Node<Integer> takeinput() {
        Node<Integer> head = null, tail = null;
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        while (data != -1) {
            Node<Integer> newnode = new Node<Integer>(data);
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
    public static void main(String[] args) {
       Node<Integer> head = takeinput();
       System.out.println(getDecimalValue(head));
       

    }

}
