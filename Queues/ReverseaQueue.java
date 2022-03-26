package Queues;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseaQueue {  //Dry Run On 2 -> 1 To Reverse To 1 -> 2
    public static void reverse(Queue < Integer > q) {
        if(q.isEmpty())
        {
            return;
        }
        int temp = q.poll();
        reverse(q);
        pushatlast(q,temp);
    }
    public static void pushatlast(Queue<Integer> q,int k)
    {
        if(q.isEmpty() || !q.isEmpty())  //for adding the first element or the topmost element out queue will be empty so q.isEmpty() is base case and for adding the other elements which were added late there were already elements present in the queue when they were added , so !q.isempty is basecase for them 
        {
            q.add(k);
            return;
        }
        pushatlast(q,k);
    }
    public static void main(String[] args) {
        Queue<Integer> q1 = new LinkedList<>();
        for(int i = 0;i<5;i++)
        {
            q1.add(i);
        }
        System.out.println("before calling of reverse elements are removed in fifo manner");
        while(!q1.isEmpty())
        {
            System.out.println(q1.poll());
        }
        System.out.println("after calling reverse");
        for(int i = 0;i<5;i++)  
        {
            q1.add(i);
        }
        reverse(q1);
        while(!q1.isEmpty())
        {
            System.out.println(q1.poll());
        }
    }
}


