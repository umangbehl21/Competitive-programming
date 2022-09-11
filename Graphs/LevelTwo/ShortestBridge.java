package Graphs.LevelTwo;

import java.util.*;

public class ShortestBridge {  //make path to connect two islands denoted by 1 by counting the number of 0 that can be flipped to make 1 or to make a bridge 
    static class pair
    {
        int row;
        int col;
        public pair(int row,int col)
        {
              this.row = row;
              this.col = col;
        }
    }
    static int dircs[][] = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void dfs(int grid[][],int row,int col,boolean visited[][],Queue<pair> pendingnodes)  //to add all the connected 1's which together form an island 
    {
         visited[row][col] = true;
         pendingnodes.add(new pair(row, col));
         for(int i = 0;i<4;i++)
         {
            int NextRow = row + dircs[i][0];
            int NextCol = col + dircs[i][1];
            if(NextCol >= 0 && NextRow >= 0 && NextCol < grid[0].length && NextRow < grid.length && visited[NextRow][NextCol] == false && grid[NextRow][NextCol] == 1)
            {
               dfs(grid, NextRow, NextCol, visited, pendingnodes);
            } 
            else 
            continue;
         }
    }
    public static int MinimumFlipToFindShortestPath(int grid[][])
    {
        Queue<pair> pendingnodes = new LinkedList<>(); 
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        boolean flag = false;
        for(int i = 0;i<grid.length && !flag;i++)
        {
           for(int j = 0;j<grid[0].length && !flag;j++)
           {
             if(grid[i][j] == 1)
             {
                dfs(grid, i, j, visited, pendingnodes);
                flag = true;
             }
           }
        }
        int level = -1;
        while(!pendingnodes.isEmpty())
        {
           int size = pendingnodes.size();
           level++; 
           while(size-- > 0)
           {
             pair front = pendingnodes.remove();
             for(int i = 0;i<4;i++)
             {
                int NextRow = front.row + dircs[i][0]; 
                int NextCol = front.col + dircs[i][1];
                if(NextCol < 0 || NextRow < 0 || NextCol >= grid[0].length || NextRow >= grid.length || visited[NextRow][NextCol] == true)
                {
                  continue;
                } 
                if(grid[NextRow][NextCol] == 1) 
                {
                    return level; 
                }
                visited[NextRow][NextCol] = true;
                pendingnodes.add(new pair(NextRow, NextCol));
             }

           }

        }
        return -1;
    }
 public static void main(String[] args) {
    int grid[][] = {{1,1,0,0,1},{1,1,0,0,1},{1,1,0,0,0}};
    System.out.println(MinimumFlipToFindShortestPath(grid));
} 
}
