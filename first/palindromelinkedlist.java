package first;

public class palindromelinkedlist {
        public boolean isPalindrome(Node<Integer> head) {
            if(head == null || head.next == null)
            {
                return true;
            }
            Node<Integer> slow = midnode(head);
            slow.next = reversell(slow.next);
            slow = slow.next;
            while(slow != null)
            {
                if(head.data != slow.data)
                {
                    return false;        
                }
                head = head.next;
                slow = slow.next;
            }
            return true;
          
        }
        public Node<Integer> midnode(Node<Integer> head)
        {
          Node<Integer> slow = head;
          Node<Integer> fast = head;
          while(fast.next != null && fast.next.next != null)
          {
              fast = fast.next.next;
              slow = slow.next;  
          }
            return slow;
            
            
        }
        public Node<Integer> reversell(Node<Integer> head)
        {
            if(head == null || head.next == null)
            {
                return head;
            }
            Node<Integer> reversedtail = head.next;
            Node<Integer> smallhead = reversell(head.next);
            reversedtail.next = head;
            head.next = null;
            return smallhead;
            
        }
    }
