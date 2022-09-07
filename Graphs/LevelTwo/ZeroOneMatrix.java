package Graphs.LevelTwo;

public class ZeroOneMatrix {  //tell distance of 1 from nearest zero 
     
   public static void FindOne(int grid[][])
   {
         for(int i = 0;i<grid.length;i++)
         {
            for(int j = 0;j<grid[0].length;j++)
            {
                if(grid[i][j] == 1)
                {
                    CalculateDistance(grid,i,j);
                }
            }
         }
   }
   
   private static void CalculateDistance(int[][] grid, int i, int j) 
   {   int min1 = 0;
       int min2 = 0;
       if(i-1 >= 0 && i+1 < grid.length)  //if up and down direction is within bounds then min1 can be taken 
       {
           min1 = Math.min(grid[i-1][j], grid[i+1][j]);
       }
       else if(i - 1 >= 0)  //but if up or down any of the two is not in the bounds then simply give value to min1 of that index which is in bounds it can be up or down 
       {
            min1 = grid[i-1][j];
       }
       else if(i+1 < grid.length)
       {
          min1 = grid[i+1][j];
       }
       if(j+1 < grid[0].length && j-1 >= 0) //if left and right direction is in bounds min2 can be taken 
       {
          min2 = Math.min(grid[i][j-1],grid[i][j+1]); 
       }
       else if(j - 1 >= 0) //but if any of the left or right is not in bounds assign value to min2 of the index which is in bounds it can be left or right 
       {
        min2 = grid[i][j-1];
       }
       else if(j+1 < grid[0].length)
       {
        min2 = grid[i][j+1];
       }                                        
       grid[i][j] = Math.min(min1, min2) + 1;  //take min from all the four direction if there is 0 in any of the four directions than the nearest zero will be that 0 + 1 if there is no 0 then min will be 1 so distance will be min + 1 = 1 + 1 = 2
   }

public static void main(String[] args) {
      int grid[][] = {{0,0,0},{0,0,1},{1,1,1}};
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
