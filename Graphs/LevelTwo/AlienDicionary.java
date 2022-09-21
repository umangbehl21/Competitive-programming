package Graphs.LevelTwo;

import java.util.*;

public class AlienDicionary { //given the string in the sorted lexographical order return the order in which string contains all the element in the sorted order means first elements which are not dependent on anyone is added to string as they have 0 dependency then the element which are neighbour to 1 character is added afterwards and element with 2 dependency further added afterwards
    public static String allienOrder(String words[])
    {
       HashMap<Character,HashSet<Character>> map = new HashMap<>();
       HashMap<Character,Integer> dependency = new HashMap<>();
       for(String s : words) //initially every character have 0 dependncy 
       {
          for(char ch : s.toCharArray()) 
           {
               dependency.put(ch,0);
           }
       }
       for(int i = 0;i<words.length-1;i++) //length -1 because we are accessing next element from i so if we go till end then we will be accessing out of bounds in the end
       {
          boolean flag = false;
          String curr = words[i];  //outer loop run on words array inner loop work for the strings inside the array 
          String next = words[i+1];
          int len = Math.min(curr.length(), next.length());
          for(int j = 0;j<len;j++)
          {
              char ch1 = curr.charAt(j);
              char ch2 = next.charAt(j);
              if( ch1 != ch2)
              {
                 HashSet<Character> set = new HashSet<>();
                 if(map.containsKey(ch1))
                 {
                    set = map.get(ch1);
                    if(!set.contains(ch2)) //if the character is not showing up the second time in that case it is already added in set
                    {
                      set.add(ch2);
                      dependency.put(ch2, dependency.getOrDefault(dependency.get(ch2),0)+1);
                      map.put(ch1, set);
                    }
                }
                else 
                {
                   set.add(ch2);
                   dependency.put(ch2, dependency.getOrDefault(dependency.get(ch2),0)+1); //when a character is found dependent first time then give 1 
                   map.put(ch1,set);
                }
                flag = true;
                break; //if character from both the string is unmatched the rest of the characters donnot play any role in sorting so break and move ahead to different string 
              }

          }
          if(flag == false && curr.length() > next.length())
          {
            return "";
          }

       }
       Queue<Character> pendingnodes = new LinkedList<>();
       StringBuilder ans = new StringBuilder();
       for(char ch : dependency.keySet())
       {
          if(dependency.get(ch) == 0) //first of all nodes with dependency 0 or independent will be added in queue according ko kahns algo
          {
             pendingnodes.add(ch);
          }

       }
       int count = 0;
       while(!pendingnodes.isEmpty())
       {
         char rem = pendingnodes.remove();
         ans.append(rem);
         count++;
         if(map.containsKey(rem) == true)
         {
            HashSet<Character> nbrs = map.get(rem);
            for(char nbr : nbrs)
            {
                dependency.put(nbr, dependency.get(nbr)-1);
                if(dependency.get(nbr) == 0)
                {
                    pendingnodes.add(nbr);
                }
            }
         }
         

       }
       if(count == dependency.size())
       {
         return ans.toString();
       }
       else 
       {
        return "";
       }

    
    }
}
