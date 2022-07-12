package com.listts;
import java.util.Scanner;
public class circulardoublyll {
    public static CdlNode<Integer> takeinput()
    {
       CdlNode<Integer> head = null,tail =null;
       Scanner sc = new Scanner(System.in);
       int data = sc.nextInt();
       while(data != -1)
       {
        CdlNode<Integer> newnode = new CdlNode<Integer>(data);
        if(head == null)
        {
            head = newnode;
            tail = newnode;
        }
        else
        {
            tail.next = newnode;
            newnode.prev = tail;
            tail = tail.next;
        }
           data = sc.nextInt();
           if(data == -1)
           {
               tail.next = head;
               head.prev = tail;
           }

       }
       return head;

    }
    public static void print(CdlNode<Integer> head)
    {
       CdlNode<Integer> temp = head;
       while(temp.next != head)
       {
           System.out.println(temp.data + " ");
           temp = temp.next;
       }
      System.out.println(temp.data+" ");
    }
    public static CdlNode<Integer> deletenode(CdlNode<Integer> head,int pos)
    {
       int i = 0;
       CdlNode<Integer> temp = head;
       while(temp.next != head) 
       {
          if(pos == 0)
          {
              CdlNode<Integer> lastnode = head.prev;
              head = head.next;
              head.prev = lastnode;
              lastnode.next = head;
              break;
          }
          if(i == pos-1)
          {
             CdlNode<Integer> temp2 = temp.next.next;
             temp2.prev = temp;
             temp.next = temp2;
             break;
          }
           i++;
           temp = temp.next;
        }
        return head;

    }
    public static CdlNode<Integer> insert(CdlNode<Integer> head,int pos,int element)
    {
        CdlNode<Integer> temp = head;
        int i = 0;
        while(temp != null)
        {  
           if(pos == 0)
           {
             CdlNode<Integer> newnode = new CdlNode<Integer>(element);
             CdlNode<Integer> lastnode =  head.prev;
             newnode.next = head;
             newnode.prev = lastnode;
             lastnode.next = newnode;
             return newnode;
           }
           if(i == pos-1)
           {
              CdlNode<Integer> newnode = new CdlNode<Integer>(element);
              CdlNode<Integer> temp2 = temp.next;
              temp.next = newnode;
              newnode.next = temp2;
              newnode.prev = temp;
              temp2.prev = newnode; 
              break;
           }
           i++;
           temp = temp.next;

        }
        return head;
    }
    public static void main(String[] args) {
       CdlNode<Integer> head = takeinput();
     //  print(head);
    //    System.out.println("head ke prev me " +head.prev.data);
    // CdlNode<Integer> head2 = deletenode(head, 5);
    //     print(head2);
       CdlNode<Integer> head1 = insert(head, 0 , 0);
       print(head1);

    }



}
