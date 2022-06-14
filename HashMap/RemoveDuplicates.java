package HashMap;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
public class RemoveDuplicates {
public static ArrayList<Integer> duplicates(int arr[])
{
   ArrayList<Integer> ans = new ArrayList<>();
   HashMap<Integer,Integer> map = new HashMap<>();
   for(int i = 0;i<arr.length;i++)
   {
    if(!map.containsKey(arr[i]))  //if element is not present in the map then put it in map 
    {
        map.put(arr[i], 1);
    }
    else 
    {
        continue;  //if we see the duplicate element again then skip the current iteration 
    }
   }
    for(Map.Entry<Integer,Integer> elem : map.entrySet()) //entryset() returns the set of key value Map.Entry<> is an iterator way of iterating over a map 
    {
       ans.add(elem.getKey());
    }
   return ans;

}
public static void main(String[] args) {
    int arr[] = {1,1,1,2,2,2,4,4,3,3};
    System.out.println(duplicates(arr)); 
}

}
