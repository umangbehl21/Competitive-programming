package PriorityQueue;
import java.util.*;
public class RunningMedian {
    static PriorityQueue<Integer> Minpq = new PriorityQueue<>(); //for min priority 
    static PriorityQueue<Integer> Maxpq = new PriorityQueue<>(Collections.reverseOrder()); //for max priority queue Collections.reverseOrder is comparator for max priority queue
    public static void runningMedian(int arr[],int i)
    {
       if(Maxpq.isEmpty() || arr[i] <= Maxpq.peek())
       {
          Maxpq.add(arr[i]);
       }
       else 
       {
        Minpq.add(arr[i]);
       }
       if(Maxpq.size() > Minpq.size() + 1) //as we are storing one element more in the max priority queue we will check that if difference of size of maxpq and minpq is greater than or equal to 2 if it is so we will pop one element from maxpq and add it in min   
       {
          Minpq.add(Maxpq.poll());
       }
       else if(Minpq.size() > Maxpq.size())
       {
        Maxpq.add(Minpq.poll());
       }
       runningmediancalculate(arr, i);
    }
    public static void runningmediancalculate(int arr[],int i )
    {
        int res = 0;
        if(Minpq.size() == Maxpq.size())
        {
           res = (Minpq.peek() + Maxpq.peek())/2;
           System.out.println(res);
        }
        else
        {
            System.out.println(Maxpq.peek());
        }
    }
    public static void main(String[] args) {
       int arr[] = {6,2,1,3,7,5};
       for(int i = 0;i<arr.length;i++)
       {
          runningMedian(arr,i);
       }

    }
}
