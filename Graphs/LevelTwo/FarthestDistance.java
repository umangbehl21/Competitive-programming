package Graphs.LevelTwo;
import java.util.*;
public class FarthestDistance {   //Farthest distance of 0 from 1 0 represent water 1 represt land we have to find farthest distance of water from the land 
  static class pair
   {
     int row;
     int col;
     pair(int row,int col)
     {
         this.row = row;
         this.col = col;
     }
   }
   public static int FarthestDistanceBfs(int grid[][])
   {
      int dircs[][] = {{-1,0},{0,1},{1,0},{0,-1}};
      Queue<pair> pendingnodes = new LinkedList<>();
      for(int i = 0;i<grid.length;i++)
      {
        for(int j = 0;j<grid[0].length;j++)
        {
            if(grid[i][j] == 1)  //adding 0th distance far from 1 in queue that is 1 itself 
            {
               pendingnodes.add(new pair(i, j));  //pair will store index of all the 1's
            }
        }
      }
      if(pendingnodes.isEmpty() || pendingnodes.size() == grid.length * grid[0].length) //if pending nodes is empty means there is no land to tell the farther distance of it from water or there are all lands and no water 
      {
         return -1;
      }
      int level = -1;  //as we are incrementing first then adding that level nodes for example firstly nodes which are farther of 0 are there in the queue with the help of nested loop so level = -1+1 = 0 then after the removal of the 0th distance nodes they will add 1th distance farther nodes will be there in the queue level++ will increment and level = 1 which means level is incremented after the queue has added that level nodes in it
      while(!pendingnodes.isEmpty())
      {
         int size = pendingnodes.size(); //retaining the number of nodes that are 0 or 1 or 2 so on.. distance away the inner loop will run till this size after that distance will be incremented as 0th distance away node have added 1th distance away nodes in queue 
         level++;
         while(size-- > 0)
         {
            pair front = pendingnodes.remove(); //removing a pair from the queue and searching 0 in its all four directions
            for(int i = 0;i<4;i++)
            {
                int nextrow = front.row + dircs[i][0];
                int nextcol = front.col + dircs[i][1];
                if(nextrow >= 0 && nextcol >= 0 && nextrow <grid.length && nextcol < grid[0].length && grid[nextrow][nextcol] == 0)
                { 
                    grid[nextrow][nextcol] = 1; //visited
                    pendingnodes.add(new pair(nextrow,nextcol)); //adding the new pair in queue of the distance one more than the previous distance as the bfs grown in levels 

                }
            }
            
         }
      }

      return level;
   }
   public static void main(String[] args) {
    int grid[][] = {{1,0,0,1},{0,0,0,0},{1,0,0,1}};
    System.out.println(FarthestDistanceBfs(grid));
   }
}
