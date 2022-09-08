package Graphs.LevelTwo;

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {  //tell distance of 1 from nearest zero 
   static class pair
   {
      int x = 0;
      int y = 0;
      pair(int x,int y)
      {
         this.x = x;  //row index
         this.y = y;  //column index 
      }
   }                      //up , right , down , left 
   static int dirs[][] = {{-1,0},{0,1},{1,0},{0,-1}};
   public static void FindOne(int grid[][])
   {
         Queue<pair> pendingnodes = new LinkedList<>();
         for(int i = 0;i<grid.length;i++)
         {
            for(int j = 0;j<grid[0].length;j++)
            {
                if(grid[i][j] == 0)  //if element is 0 then add in the queue as it will help in finding the distance of the numbers that are 1 distance away 
                {
                    pendingnodes.add(new pair(i, j)); //adding the index where we found 0
                }
                else 
                {
                    grid[i][j] = -1;  //else if number is 1 mark it unvisited 
                }
            }
         }
         while(!pendingnodes.isEmpty())
         {
            pair front = pendingnodes.remove();
            for(int i = 0;i<dirs.length;i++)
            {
                    int RowDash = front.x + dirs[i][0];
                    int ColDash = front.y + dirs[i][1];
                    if(RowDash < grid.length && ColDash < grid[0].length && RowDash >= 0 && ColDash >= 0 && grid[RowDash][ColDash] == -1)
                    {
                            grid[RowDash][ColDash] = grid[front.x][front.y] + 1;  //if we find -1 on left or right or up or down then that index is unvisited then its distance will be distance of the current index from 0 + 1 
                            pendingnodes.add(new pair(RowDash, ColDash)); //add the newly calculated distance of index element in the queue so it can be used to calculate distance of next level example if we find -1 at the distance of 1 from 0 then distance of 0 + 1 will be the distance of 1 and if we find -1 at the distance of 2 from the 0 then there will be 1 in between which willl have distance of 1 from 0 so the distance of 1 will be calculated by 1 + 1 = 2
                    }

         }
   }
}

public static void main(String[] args) {
      int grid[][] = {{0,1,1},{1,1,1},{1,1,1}};
      FindOne(grid);
      for(int i = 0;i<grid.length;i++)
      {
        for(int j = 0;j<grid[0].length;j++)
        {
            System.out.print(grid[i][j]+" ");
        }
        System.out.println();
      }
   }

}
