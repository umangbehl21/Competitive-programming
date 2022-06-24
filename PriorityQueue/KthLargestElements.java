package PriorityQueue;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KthLargestElements {
    
    public static ArrayList<Integer> KthLargestnumbers(int arr[],int k)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0;i<arr.length;i++)
        {
            if(i < k)  //add elements blindly until i < k to fill the priority queue 
            {
               pq.add(arr[i]);
            }
            else {
              if(arr[i] > pq.peek()) //when i becomes equal or greater than k then check if current element is greater than the smallest element in the priority queue if greater than remove the smallest element which is on the peek and add the new greater element repeat until the end of the array 
              {
                pq.remove();
                pq.add(arr[i]);
              }
            }

        }
        while(!pq.isEmpty())
        {
            ans.add(pq.remove());
        }
       return ans;
    }
    public static void main(String[] args) {
        int arr[] = {2,10,5,17,7,18,6,4};
        System.out.println(KthLargestnumbers(arr, 3));
    }

}
