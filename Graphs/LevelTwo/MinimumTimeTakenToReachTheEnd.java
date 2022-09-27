package Graphs.LevelTwo;
import java.util.*;
public class MinimumTimeTakenToReachTheEnd  //minimum time taken to reach the bottom right ending cells for 2 * 2 matrix we have to reach 1 * 1 right most bottom cell
{
    static class pair implements Comparable<pair>
    {   
        int RowIdx;
        int ColIdx;
        int Mpsf;
        pair(int RowIdx,int ColIdx,int Mpsf)
        {
            this.Mpsf = Mpsf;
            this.ColIdx = ColIdx;
            this.RowIdx = RowIdx;
        }
        @Override
        public int compareTo(pair o) {
            if(this.Mpsf < o.Mpsf) return -1;

            else if(this.Mpsf > o.Mpsf) return 1;

            else return 0;
        }
       
    }
    public static int MinimumTimeTakenToReachTheBottom(int grid[][])
    {
       boolean visited [][] = new boolean[grid.length][grid[0].length];
       PriorityQueue<pair> pendingnodes = new PriorityQueue<>();
       pendingnodes.add(new pair(0, 0, grid[0][0]));
       int dircs[][] = {{-1,0},{0,1},{1,0},{0,-1}};
       while(!pendingnodes.isEmpty())
       {
          pair rem = pendingnodes.remove();
          if(visited[rem.RowIdx][rem.ColIdx] == true) 
          {
            continue;
          }
          if(rem.RowIdx == grid.length - 1 && rem.ColIdx == grid[0].length-1)
          {
            return rem.Mpsf;
          }
          visited[rem.RowIdx][rem.ColIdx] = true;
          for(int i = 0;i<dircs.length;i++)
          {
             int NextRowIdx = rem.RowIdx + dircs[i][0];
             int NextColIdx = rem.ColIdx + dircs[i][1];
             if(NextRowIdx >=0 && NextColIdx >=0 && NextRowIdx < grid.length && NextColIdx < grid[0].length && !visited[NextRowIdx][NextColIdx])
             {
                   pendingnodes.add(new pair(NextRowIdx, NextColIdx, Math.max(rem.Mpsf, grid[NextRowIdx][NextColIdx]))); //we are taking maximum because when we travel in our own route it can be possible that earlier we have taken t = 5 seconds but now in that route t = 3 seconds is found but we have once reach our time 5 second in that same route while trying to reach end so although we have to find the minimum elevation to reach the end but we cannot ignore the spike of 5 seconds which once raised our time before reaching the end  
             }
          }
          

       }
       return -1;
    }
    public static void main(String[] args) {
        int grid[][] = {{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}};
       // int grid[][] = {{5,6,8},{4,9,5},{3,7,2}};
        System.out.println(MinimumTimeTakenToReachTheBottom(grid));
    }
}
