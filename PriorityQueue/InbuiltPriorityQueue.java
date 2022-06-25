package PriorityQueue;

import java.util.PriorityQueue;

public class InbuiltPriorityQueue {
    public static void main(String[] args) {
        int arr[] = { 5,8,9,2,3,1};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : arr)
        {
            pq.add(i); // to add elements
        }
        System.out.println(pq.peek()); // to see the minimum element 
        System.out.println(pq.remove());//to remove the minimum element 
        System.out.println("after removal");
        while(!pq.isEmpty())
        {
            System.out.println(pq.remove());
        }
    }
}
