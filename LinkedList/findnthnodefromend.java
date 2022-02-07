package Linkedlist;

public class findnthnodefromend {
        //Function to find the data of nth node from the end of a linked list.
        int getNthFromLast(Node<Integer> head, int n)
        {
            Node<Integer> temp = head;
            int l = length(head);
            if(n > l)
            {
                return -1;
            }
            while(temp != null && l!=n)
            {
                l--;
                temp = temp.next;
            }
            return temp.data;
            
        }
        public int length(Node<Integer> head)
        {
            int l = 0;
            Node<Integer> temp = head;
            while(temp != null)
            {
                l++;
                temp = temp.next;
            }
            return l;
        }
    }

