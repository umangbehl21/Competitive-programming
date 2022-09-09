package Graphs.LevelTwo;
import java.util.*;
public class RottenOranges 
{
   static int dircs[][] = {{-1,0},{0,1},{1,0},{0,-1}};
   static class pair 
   {
      int row = 0;  //row index 
      int col = 0;  //column index 
      pair(int row,int col)
      {
        this.row = row;
        this.col = col;
      }
   } 
   public static int TimeToRotOranges(int grid[][])
   {
    LinkedList<pair> pendingnodes = new LinkedList<>();
    int fresh = 0; 
       for(int i = 0;i<grid.length;i++)
       {
         for(int j = 0;j<grid[0].length;j++)
         {
            if(grid[i][j] == 2)
            {
               pendingnodes.add(new pair(i, j));
            }
            else if(grid[i][j] == 1)
            {
                fresh++;
            }
            
         }   

       }
       if(fresh == 0)
       {
           return 0;
       }
       int level = -1;
       while(pendingnodes.size() > 0)
       {
         level++; 
         int size = pendingnodes.size();
         
         while(size-- > 0)
         {
            pair front = pendingnodes.remove();
            for(int i = 0;i<dircs.length;i++)
            {
                int NextRow = front.row + dircs[i][0];
                int NextColumn = front.col + dircs[i][1];
                if(NextRow >= 0 &&  NextColumn >= 0 && NextRow < grid.length && NextColumn < grid[0].length && grid[NextRow][NextColumn] == 1)
                {
                   grid[NextColumn][NextRow] = 0;
                   pendingnodes.add(new pair(NextRow, NextColumn));
                     fresh--;
                }
            }
         }
       }
      if(fresh == 0)
      {
         return level;
      }
      else 
      return -1;

   }
   public static void main(String[] args) {
    int grid[][] = {{2,1,1},{1,1,0},{0,1,1}};
    System.out.println(TimeToRotOranges(grid));
   }

}
