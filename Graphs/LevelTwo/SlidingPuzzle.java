package Graphs.LevelTwo;
import java.util.*;

public class SlidingPuzzle 
{
    public static int slidingPuzzle(int board[][])
    {
       Queue<String> pendingnodes = new LinkedList<>();
       String tar = "123450";
       String initial = "";

       StringBuilder sb = new StringBuilder();
       for(int i = 0;i<board.length;i++)
       {
        for(int j = 0;j<board[0].length;j++)
        {
            sb.append(board[i][j]);
        }
       }
       initial = sb.toString();
       int [][]swapidx = {{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{4,2}};
       pendingnodes.add(initial);
       int level = 0;
       HashSet<String> vis = new HashSet<>();
       while(!pendingnodes.isEmpty())
       {
         int size = pendingnodes.size();
         while(size-- > 0)
         {
            String rem = pendingnodes.remove();
            if(rem.equals(tar))  ///if removed string is equal to tar string the return level on which it is fouund 
            {
                return level;
            }
            int idx = -1;
            for(int i = 0;i<rem.length();i++)
            {
                if(rem.charAt(i) == '0')
                {
                    idx = i;  //finding index of 0
                    break; 
                }
            }
            int swap[] = swapidx[idx]; //giving index of 0 in swapidx array where all the details that if 0 is on 3rd position in which direction it can be swapped is stored
            for(int i = 0;i<swap.length;i++)
            {
              String tobeadded = swapchar(rem,idx,swap[i]); //passing current removed string , index of 0 & swap[i] contains the positions where 0 can be swapped with example swap array is {1,3,5} then first swap[0] = 1 will be passed, swap[1] = 3 will be passed ,swap[2] = 5 
              if(vis.contains(tobeadded)) //the returned string will be checked that if it is already present in hashset then continue it is not a new combination 
              {
                continue;
              }  
              pendingnodes.add(tobeadded); //otherwise if it is a new combination add it in the queue 
              vis.add(tobeadded); //mark it visited too 
            }


         }
         level++;
       }
       return -1;

    }

    private static String swapchar(String st, int i, int j) {
         StringBuilder sb = new StringBuilder(); //String buffer provides the mutable String 
         sb.append(st);  //first copy the String in String builder and then proceed swapping 
         sb.setCharAt(i, st.charAt(j));  //swapping the 0th index with the possible indexes in the swap array example if swap[4] = {1,3,5} in first string -> 0 at index 4 will be swapped with index 1 element then this string will be returned next time new string will be made and i will become 1 hence visiting 2nd index i.e 3 value from  (1,3,5) array and swapping will occur on 4th index the 3rd index element of the st string  will be set on 3rd index and on the 3rd index 4th index i.e 0 will be set 
         sb.setCharAt(j, st.charAt(i)); 
         return sb.toString(); //we will every time return new String to make and return all possible combination 

    }
    public static void main(String[] args) {
        int board[][] = {{4,1,2},{5,0,3}};
        System.out.println(slidingPuzzle(board));
    }

    

}
