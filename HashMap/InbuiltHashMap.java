package HashMap;
import java.util.HashMap;
import java.util.Map;
public class InbuiltHashMap 
{
    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("abc", 1);

        map.put("abc1", 2);

        map.put("abc2",3);

        if(map.containsKey("abc")) //to check presence of a key 
        {
            System.out.println(map.get("abc"));  //to print value of key
        }

        for(Map.Entry<String,Integer> elem : map.entrySet())  //Map.Entry<K,V> is a iterator it is a way of iterating over map map.entrySet returns the set of keys and values 
        { 
           System.out.println(elem.getKey()+":"+elem.getValue()); 
        } 

       System.out.println("removing "+map.remove("abc"));  //on removing the key it's value will be printed 
       System.out.println("size"+map.size()); //size will be reduced to 2 
    }
}
