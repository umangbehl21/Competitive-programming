package Graphs.LevelTwo;

import java.util.HashSet;

public class DistinctIsland {
    static StringBuilder psf = new StringBuilder();
  public static int FindDistinctIsland(int grid[][])
  {
      HashSet<String> set = new HashSet<>();
      for(int i = 0;i<grid.length;i++)
      {
         for(int j = 0;j<grid[0].length;j++)
         {
            if(grid[i][j] == 1)  //if we find one topleft part of island find more by calling on up,down,left,right
            {
               psf = new StringBuilder();  //each time new string is made for different groups of 1 or different island
               psf.append("x");
               FindDistinctIslandHelper(grid,i,j,set);
               set.add(psf.toString());  //toString() returns a String containg the characters in the sequence 
               
            }
 
         }

      }
      return set.size();
  }
private static void FindDistinctIslandHelper(int[][] grid, int i, int j,HashSet<String> set) 
{
    grid[i][j] = 0; //marking visited to a piece of land so that it can't be called twice 
    if(j+1 < grid[0].length && grid[i][j+1] == 1) //for Right direction first we will check that the column on which we are going should be withing matrix index 
    {
        psf.append("r"); //adding r means that we have found 1 or land on the right direction 
        FindDistinctIslandHelper(grid, i, j+1, set);
    }
    if(j-1 > 0 && grid[i][j-1] == 1) //LEFT
    {
      psf.append("l"); //adding l means that we found 1 on left direction
      FindDistinctIslandHelper(grid, i, j-1, set);
    }
    if(i-1 > 0 && grid[i-1][j] == 1) //Up
    {
        psf.append("u");
        FindDistinctIslandHelper(grid, i-1, j, set);
    }
    if(i+1 < grid.length && grid[i+1][j] == 1) //down
    {
        psf.append("d");
        FindDistinctIslandHelper(grid, i+1, j, set);
    }
    psf.append("B"); // we are adding B because we are keeping the trace of backtracking whether the land is found continously or a function has returned in between and then search is continued in the case of continued all the B will be added in the end of the string in the case of the non continous search of land then b will be added in between 1->2 and 1->2  they are structurically distinct as in former 3 is under 1 and in later 3 is under 2 but there directions are same top right down are the direction of both but in first case the land is not found continously as from 2 we have backtracked to 1 in between which will be recorded in the string and as in the second case land is found continously and all the backtracking is done after all the 1 is covered in that area 
}                                                                                                                                                                                                                                                                                                                                                                // |        |
                                                                                                                                                                                                                                                                                                                                                                 // 3        3
                                                                                                                                                                                                                                                                                                                                                           //there are only 0 and 1 in matrix the above example is to make the structure and backtracking clear                                                      
}

