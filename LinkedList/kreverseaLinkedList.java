package Linkedlist;

public class kreverseaLinkedList{
    public static Node<Integer> kReverse(Node<Integer> head, int k) {
		if (head==null){
            return null;
        }
        Node<Integer> next= null;
        Node<Integer> prev= null;
        Node<Integer> curr= head;
        int count=0;
        while(curr!=null && count<k){
            next= curr.next;
            curr.next= prev;
            prev= curr;
            curr= next;
            count++;
        }
     if(next!=null){
         head.next= kReverse(next,k);
     }
        return prev;
	}
    
}
