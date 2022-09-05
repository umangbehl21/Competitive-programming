package Graphs.LevelTwo;

import java.util.Scanner;

public class NumberOfEnclaves // Remove path of 1 reaching outside the array and keep the trapped 1 in the array 
{
   public static void FindBoundaryHavingOne(int grid[][],int i,int j)  //find boundaries having 1 and turn it into 0 the middle 1's count will only be our answer  
   { 
      if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0)
      {
         return;
      }
      grid[i][j] = 0;
      FindBoundaryHavingOne(grid, i, j+1); //right
      FindBoundaryHavingOne(grid, i, j-1); //left
      FindBoundaryHavingOne(grid, i+1, j); //down
      FindBoundaryHavingOne(grid, i-1, j); //up
   }
   public static void RemainingOne(int grid[][])
   {
      for(int i = 0;i<grid.length;i++)
      {
        for(int j = 0;j< grid[0].length;j++)
        {
            if(i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1)  //we have to only find 1 on boundaries and break its link to where it spread by inserting 0 if row is 0th or column is 0th or row is ending row or column is ending column then we are on boundaries 
            {
                if(grid[i][j] == 1)  //if we find 1 on the boundary , call to find how many 1 are there in border and remove that path by inserting 0 , at the end we will check how many 1 are there in the middle which don't have path outside the array 
                {
                    FindBoundaryHavingOne(grid, i, j);     
                }
            }
        }
      }
      for(int i = 0;i<grid.length;i++)
      {
        for(int j = 0;j<grid[0].length;j++)
        {
            System.out.print(grid[i][j] + " ");
        }
        System.out.println();
      }
   }
   public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("enter no of row");
    int row = sc.nextInt();
    System.out.println("enter no of col");
    int col = sc.nextInt();
    int grid[][] = new int[row][col];
    for(int i = 0;i<row;i++)  
    {
        for(int j = 0;j<col;j++)
        {
            grid[i][j] = sc.nextInt();
        }
    }
     RemainingOne(grid);
}
