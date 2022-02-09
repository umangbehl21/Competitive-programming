package Arrays;
import java.util.HashMap;
import java.util.ArrayList;
public class IntersectionoftwoarrayCN {
    public static ArrayList<Integer> findArrayIntersection(ArrayList<Integer> arr1, int n, ArrayList<Integer> arr2, int m)
	{
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0;i<arr1.size();i++)
        {
            if(map.containsKey(arr1.get(i)))
            {
                map.put(arr1.get(i),map.get(arr1.get(i))+1);
            }
            else
            {
                map.put(arr1.get(i),1);
            }
        }
        for(int i = 0;i<arr2.size();i++)
        {
            if(map.containsKey(arr2.get(i)))
            {
                int freq = map.get(arr2.get(i));
                freq--;
                if(freq == 0)
                {
                    map.remove(arr2.get(i));
                }
                else
                {
                    map.put(arr2.get(i),freq);
                }
                list.add(arr2.get(i));
            }
        }
        if(list.isEmpty())
        {
            list.add(-1);
        }
        return list;
	}
}
