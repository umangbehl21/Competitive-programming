package PriorityQueue;
import java.util.*;
public class BuyTicket {
      public static int timelimit(int arr[],int element)
      {
        int time = 0;
        for(int i = 0;i<arr.length;i++)
        {
                time++;
                if(arr[i] == element)
                {
                    break;
                }
        }
        return time;
      }
        public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int nums[] = {2,3,2,2,4};
        int element = nums[1];
        for(int i : nums)
        {
            pq.add(i);
        }
        int arr[] = new int[nums.length];
        for(int i = 0;i<arr.length;i++)
        {
            arr[i] = pq.remove(); //sorting the array using priority queue 
        }
        System.out.println(timelimit(arr,element));
    }
}
