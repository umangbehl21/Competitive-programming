package Linkedlist;

    class Solution {
        public Node<Integer> deleteMiddle(Node<Integer> head) {
            Node<Integer> temp = head;
            int mid = length(head)/2;
            Node<Integer> prev = null;
            if(head.next == null)
            {
                return head.next;
            }
            for(int i = 0;i<mid && temp.next != null;i++)
            {
                prev = temp;
                temp = temp.next;
            }
            prev.next = temp.next;
            return head;
            
        }
        public int length(Node<Integer> head)
        {   
            int ln = 0;
            Node<Integer> temp = head;
            while(temp != null)
            {
                ln++;
                temp = temp.next;
            }
            return ln;
        }
    }

