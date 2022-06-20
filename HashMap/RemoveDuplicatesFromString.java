package HashMap;
import java.util.*;
public class RemoveDuplicatesFromString {
    public static String removeDuplicates(String str) 
    {
        HashMap<Character,Integer> map = new HashMap<>();
        String ans = "";
        for(int i = 0;i<str.length();i++)
        {
            if(!map.containsKey(str.charAt(i)))
             {
               map.put(str.charAt(i), 1);
               ans += str.charAt(i);
             }
             continue;
        }
        return ans;
    }
    public static void main(String[] args) {
        String str = "zzzxxxvvv";
        System.out.println(removeDuplicates(str));

    }
}
