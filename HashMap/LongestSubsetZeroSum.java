package HashMap;
import java.util.*;
public class LongestSubsetZeroSum {
    public static int LongenstSubsetZerosum(int arr[]) 
    {
        HashMap<Integer,Integer> map = new HashMap<>();
        int mlen = 0; //max length initially 0
        int i = -1;  //we have consider sum as 0 in begining so we are assigning it as -1 index and putting in map so that one more time sum 0 occurs we can calculate the true length between them 
        int sum = 0;
        map.put(sum, i);
        while(i<arr.length-1)
        {
           i++; //i was at -1 first bringing it on 0  
           sum += arr[i]; //adding the 0th index element in sum 
           if(!map.containsKey(sum)) //if sum after adding is no seen in the map before then put it in 
           { 
             map.put(sum, i); //(sum,index)
           }
           else  //if it is seen then calculate lenght by subtracting current index with the value of sum present in t he map that  value actually is the index of the sum when it was first occured
           {
            int len = i - map.get(sum); 
            if(len > mlen) //chefck if current length is greater than the maxlenght if greater update it 
             {
                mlen = len;
             } 
           }
        }
        return mlen;
    
    }
    public static void main(String[] args) {
        int arr[]= {-1,2,8,-3,-5,2,-4,6,1,2,1,-3,4};
        System.out.println(LongenstSubsetZerosum(arr));
    }
}
