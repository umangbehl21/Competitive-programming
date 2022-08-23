package Graphs;

public class CountIslands {
    public static int countIslands(int arr[][])
    {
        boolean visited[][] = new boolean[arr.length][arr[0].length];
        int count = 0;
        for(int i = 0;i<arr.length;i++)
        {
            for(int j = 0;j<arr[0].length;j++)
            {
                if(arr[i][j] == 0 && !visited[i][j])
                {
                    CountIslandshelper(arr,visited,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void CountIslandshelper(int[][] arr, boolean[][] visited,int i,int j) 
    {
        if(arr[i][j] == 1 || i < 0 || j < 0 || j >= arr[0].length || i >= arr.length || visited[i][j] == true)
        {
            return;
        } 
        visited[i][j] = true;                        //considering the piece of land in the middle it can call to find more combined land to it in four direction north , south , east , west 
        CountIslandshelper(arr, visited, i - 1, j);  //north direction 
        CountIslandshelper(arr, visited, i + 1, j);  //south direction 
        CountIslandshelper(arr, visited, i, j + 1);  //east direction 
        CountIslandshelper(arr, visited, i , j - 1);  //west direction 
    }
}
