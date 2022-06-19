package HashMap;
import java.util.*;
public class MostFrequentKey {
	public static int maxFrequencyNumber(int n, int[] arr) {
		HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : arr)
        {
          map.put(i, map.getOrDefault(i,0)+1);  //map.getOrDefault(keyvalue,0)  //it means that if key is already present then take the value of key otherwise 0 
        }
        int max = 0; int maxkey = Integer.MIN_VALUE;
        for(int i : arr)
        {
            if(map.get(i) > max)   //if frequency which is stored as value in the map is greater than maximum value till now then update the value also and maxkey also 
            {
                max = map.get(i);
                maxkey = i;
            }
        }
        return maxkey;
}
   public static void main(String[] args) {
    int arr[] = {4,-5,1};
    System.out.println(maxFrequencyNumber(arr.length, arr));
   }
}

