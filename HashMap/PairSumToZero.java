package HashMap;
import java.util.*;
public class PairSumToZero 
{   
    static int count = 0;
    public static ArrayList<Integer> pairSumZero(int arr[])
    { 
       ArrayList<Integer> ans = new ArrayList<>(); 
       HashMap<Integer,Integer> map = new HashMap<>();
       for(int i : arr)
       {      //complementOfNum stores the value of the complement number of key 
          int complementOfNum = map.getOrDefault(-i, 0);  //if we find the value of complement of a key that means subtracting that key we can get 0 so our complement will store 1 that it has found one pair
          if(complementOfNum > 0)
          {
            ans.add(i);  // if complementofnum > 0 then we have find a pair we can freely add negative of a number and positive of it 
            ans.add(-i);
            count += complementOfNum; //number of pairs is found by the adding the frequency or value of complement of key 
          }
          map.put(i,map.getOrDefault(i, 0)+1); //map.getOrDefault(i,0) means if we have a key use it's value else use 0 which is default value

       }
       return ans;
    }
    public static void main(String[] args) {
        int arr[] = {2,-2,2,-2,2,-2};
        System.out.println(pairSumZero(arr));
        System.out.println("number of pairs"+count);
    }
}
