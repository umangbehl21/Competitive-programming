package Linkedlist;
import java.util.Scanner;
class reverselliteratively {
  public static Node<Integer> reverse(Node<Integer> head) {
    Node<Integer> cur = head;
    Node<Integer> prev = null;
    while (cur != null) {
      Node<Integer> temp = cur.next;
      cur.next = prev;
      prev = cur;
      cur = temp;
    }
    return prev;
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

  public static void print(Node<Integer> head) {
    Node<Integer> temp = head;
    while (temp != null) {
      System.out.println(temp.data + " ");
      temp = temp.next;
    }
  }

  public static void main(String[] args) {

     Node<Integer> head = takeinput();
     head = reverse(head);
     print(head);
  }

}
}
