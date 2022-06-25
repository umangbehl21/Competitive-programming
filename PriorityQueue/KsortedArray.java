package PriorityQueue;

import java.util.PriorityQueue;

public class KsortedArray 
{
    public static void nearlySorted(int[] arr, int n, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0;
        while(i < k) //for k = 3 elements at index 0 1 and 2 will be added 
        {
            pq.add(arr[i]);
            i++;
        }
        while(i<arr.length)
        {
            arr[i - k] = pq.remove();  //we want to set the smallest element on 0 th index but our i is on 3rd index after first loop and our k is 3 each time doing i - k set elements on their respective index when i is 3 and k is 3 i-k (3-3 set element on 0th index)
            pq.add(arr[i]); //after removing add one element in the priority queue too because next element will be in range of 3 so we have to fill priority queue with 3 elements at every moments
            i++;
        
        } //when this loop is over still the largest element are left inside the queue so we have to seperately set them in array  
        
        int j = arr.length - k; // remaining elements are inserted on array length - k as for length of 6 only elements are inserted on 0 1 and 2 index so rest of elements will be inserted from 6 - 3 = 3 index onwards
        while(!pq.isEmpty())
        {
            arr[j] = pq.remove();
            j++;
        }
      
    }
    public static void main(String[] args) {
        int arr[]= {2,4,1,9,6,8};
        nearlySorted(arr, arr.length, 3);
        for(int i : arr)
        {
            System.out.println(i);
        }
    }

}
