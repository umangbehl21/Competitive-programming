package HashMap;
import java.util.*;
public class CountOfZeroSumSubArray 
{
     public static int ZeroSumSubArray(int arr[])
     {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;  //initially sum is 0 we are taking sum as zero as it donnot cause increment or decrement while adding any number in it 
        map.put(0,1); //so we will add it as a key with frequency 1 so that next time 0 sum strikes we can add this frequency as ome subarray sum 
        int i = 0;
        while(i<arr.length-1)
        {
           sum += arr[i];
           if(map.containsKey(sum)) //if subarray sum come up second time we will add the frequency or value of first sum subarray in count because one subarray = 0 can be formed  
           {
              count += map.get(sum);
              map.put(sum, map.get(sum)+1);
           }
           else 
           {
            map.put(sum, 1);
           }
           i++;
        }
        return count;

     }
     public static void main(String[] args) {
        int arr[] = {2,8,-3,-5,2,-4,6,1,2,1,-3,4};
        System.out.println(ZeroSumSubArray(arr));
     }

}
