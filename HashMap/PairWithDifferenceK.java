package HashMap;
import java.util.*;
public class PairWithDifferenceK {
    public static int pairWithDiffK(int arr[],int k)   //4,4,4,4 for k = 0 //5,1,2,4,8,8 for k = 3 (dry runs)
    {
        int result = 0;
      HashMap<Integer,Integer> map = new HashMap<>();
      for(int elem : arr)
      {
          map.put(elem, map.getOrDefault(elem, 0)+1);
      }
      for(int elem : arr)
      {
        int freq = map.get(elem);
        if(k == 0)  //when k is 0 we have to find the fr
        {
           if(freq > 1) 
           {
            map.put(elem, freq -1); // 4,4 freq is 2 we have to reduce freq - 1 so that for 4,4 when we are on index (1)th 4 and freq is still 2 it will enter the if add one more pair which is actually not there because single element cannot make pair
             result += freq - 1; // 4,4 freq is 2 from frequecy 2 one pair can be made so result += freq - 1 
           }
          
        }
        if(k > 0)
        {
            int secnumfreq = map.getOrDefault(elem + k, 0); //we have to find the key of number + k (5+3 = 8 so 8-5 can be one pair) 
            if(secnumfreq > 0)
            {
                result += secnumfreq;  //number of times the number + k element is occuring the combination of pairs also increases example (5,8,8) 5 can make pair with both 8 number of pairs possible will be equal to the frequency of 8 i.e 2 pairs thats why i am doing result += secnumfreq 
            }
        }
      }
      return result;
    }
    public static void main(String[] args) {
        int arr[] = {5,1,2,4,8,8};
        System.out.println(pairWithDiffK(arr, 3));
    }


}
