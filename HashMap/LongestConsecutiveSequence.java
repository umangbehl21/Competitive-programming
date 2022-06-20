package HashMap;
import java.util.*;
public class LongestConsecutiveSequence 
{
     public static ArrayList<Integer> LongestConsecutivesequence(int arr[])
     {
          ArrayList<Integer> list = new ArrayList<>();
          HashMap<Integer,Boolean> map = new HashMap<>();
           for(int elem : arr)
           {                          //first we are inserting true in front of every element as if they are starting point of a consecutive series it is just an assumption 
              map.put(elem, true);
           }
           for(int elem : arr)
           {
               if(map.containsKey(elem - 1)) //now we are checking that if a smaller element is present from a particular element then it is not the starting point mark false in front of it 
               {
                    map.put(elem, false);  
               }
           }
           int tl = 1; //total length
           int ml = 0; //maximum length
           int mlsp = 0; //max length starting point 
           for(int elem : arr)  //now we will work only on true values and start finding consecutive series from there 
           {
               if(map.get(elem) == true) 
               {
                    while(map.containsKey(elem + tl)) //until we are getting keys of elem + tl we will increase the total length(tl) 1+1,1+2,1+3 
                    {
                         tl++;
                    }
                    if(tl > ml) //if our total lenght is greater than max length then update max length and also change the starting point of maximum length starting point it will have starting point of longest consecutive series
                    {
                         ml = tl;
                         mlsp = elem;
                    }
               }
          
           }
           int i = 1; //i start from one as we are adding our starting element outside the loop 
           list.add(mlsp);  //add the maximum length starting point in list 
           while(i < ml) //until i < maximum length we can add the values in the list as we know it is the length of consecutive series 
           {
          //     if(map.containsKey(mlsp + i)) //as we know that we have starting point we have length of longest series we don't now have to check that the next value are present or not they are present thats why the max length is formed
          //     {
                list.add(mlsp + i);
          //     }
              i++;
           }
           return list;
     }
     public static void main(String[] args) {
          int arr[] = {1,2,3,5,6,7,8,9,12,13,14,15,16};
          System.out.println(LongestConsecutivesequence(arr));
     }


}
