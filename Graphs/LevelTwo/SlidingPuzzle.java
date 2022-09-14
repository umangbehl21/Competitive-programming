package Graphs.LevelTwo;
import java.util.*;

import recursion.convertStringtoInteger;
public class SlidingPuzzle 
{
    public static int slidingPuzzle(int board[][])
    {
       Queue<String> pendingnodes = new LinkedList<>();
       String tar = "123450";

       StringBuilder sb = new StringBuilder();
       for(int i = 0;i<board.length;i++)
       {
        for(int j = 0;j<board[0].length;j++)
        {
            sb.append(board[i][j]);
        }
       }
       String initial = sb.toString();
       int [][]swapidx = {{1,3},{0,2,4},{1,5},{0,3},{1,3,5},{4,2}};
       pendingnodes.add(initial);
       int level = 0;
       HashSet<String> vis = new HashSet<>();
       while(!pendingnodes.isEmpty())
       {
         int size = pendingnodes.size();
         while(size-- > 0)
         {
            String rem = pendingnodes.remove();
            if(rem.equals(tar))
            {
                return level;
            }
            int idx = -1;
            for(int i = 0;i<rem.length();i++)
            {
                if(rem.charAt(i) == '0')
                {
                    idx = i;
                    break;
                }
            }
            int swap[] = swapidx[idx];
            for(int i = 0;i<swap.length;i++)
            {
              String tobeadded = swapchar(rem,idx,swap[i]);
              if(vis.contains(tobeadded))
              {
                continue;
              }  
              pendingnodes.add(tobeadded);
              vis.add(tobeadded);
            }


         }
         level++;
       }
       return -1;

    }

    private static String swapchar(String st, int i, int j) {
         StringBuilder st = new StringBuilder();
         st.setCharAt(i, st.charAt(j));
         st.setCharAt(j, st.charAt(i)); 
         return st.toString();

    }

    

}
