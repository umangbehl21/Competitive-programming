package PriorityQueue;

import java.util.*;
class MinPriorityComparator implements Comparator<Integer>  //priority queue uses the comparator on the if statement that if(arr[childindex] < arr[parentIndex]) and it only does swapping if it gets -1 from the comparator 
{

    @Override
    public int compare(Integer o1, Integer o2) {
        if(o1 < o2)
        {
            return -1;  //swapping only occurs when the function returns -1 to the priority queue 
        }
        else if(o1 > o2)
        {
            return 1;
        }
        return 0;
    }
   
}
class MaxPriorityComparator implements Comparator<Integer>
{

    @Override
    public int compare(Integer o1, Integer o2) {
        if(o1 > o2) 
        {
            return -1; //swapping only occurs when the function returns -1 to the priority queue 
        }
        else if(o1 < o2)
        {
            return 1;
        }
        return 0;
    }
    
}
public class ComparatorInterfaceWorking {
    public static void main(String[] args) {
        MinPriorityComparator minc = new MinPriorityComparator();
        PriorityQueue<Integer> pq = new PriorityQueue<>(minc); //priority queue will sort according to min priority queue because of min comparator 
        MaxPriorityComparator maxc = new MaxPriorityComparator();
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(maxc); //priority queue will sort according to max priority queue because of max comparator 
        int arr[] = {5,9,3,8,2,1};
        for(int i : arr)
        {
            pq.add(i);
            pq1.add(i);
        }
        System.out.println("elements sorted by min priority queue due to min comparator");
        while(!pq.isEmpty())
        {
            System.out.println(pq.remove());
        }
        System.out.println("elements sorted by max priority queue due to max comparator");
        while(!pq1.isEmpty())
        {
            System.out.println(pq1.remove());
        }

    }
}