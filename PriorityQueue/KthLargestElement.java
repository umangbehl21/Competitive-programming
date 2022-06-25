package PriorityQueue;
import java.util.*;
public class KthLargestElement {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0;
        while(i < k)  //until i < k add elements blindly our queue will have k elements at every stage 
        {
            pq.add(nums[i]);
            i++;
        }
        while(i < nums.length)
        {
            if(nums[i] > pq.peek()) //as we have to find the kth largest element we will collect all the largest element in the priority queue but the number of elements do not exceeds k if k = 2 only 2 elements at every point at the end we will have all the largest elements upto k and smallest among the largest will be the answer 
            {
                pq.remove();
                pq.add(nums[i]);
            }
            i++;
        }
        return pq.peek();
    }
    public static void main(String[] args) {
        int nums [] = {9,4,8,7,11,3};
        System.out.println(findKthLargest(nums, 2));
    }
}

