package DynamicProgramming;

public class MinimumCostPath {
    public static int minimumcostpath(int arr[][])
    {
        return minimumcostpathhelper(arr,0,0);
    }

    private static int minimumcostpathhelper(int[][] arr, int i, int j) {
        
           if(i == arr.length-1 && j == arr[0].length - 1)
           {
             return arr[i][j];
           }
           else if(i >= arr.length || j >= arr[0].length)
           {
              return Integer.MAX_VALUE;
           }
           int opt1 = minimumcostpathhelper(arr, i , j+1);
           int opt2 = minimumcostpathhelper(arr,i+1,j+1);
           int opt3 = minimumcostpathhelper(arr,i+1,j);
           return arr[i][j] + Math.min(opt1,Math.min(opt2, opt3));
    }
    public static int MinimumCostPathMemo(int arr[][])
    {
        int storage[][] = new int[arr.length][arr[0].length];
        for(int i = 0;i<storage.length ;i++)
        {
            for(int j = 0;j< storage[0].length;j++)
            {
                storage[i][j] = -1;  //storing -1 so that we can use to differentiate the value stored by recursion in array which will be a positive value 
            }
        }
        return MinimumCostPathMemohelper(arr,0,0,storage);
    }
    private static int MinimumCostPathMemohelper(int[][] arr, int i, int j, int[][] storage) 
    {  if(i >= arr.length || j >= arr[0].length)  //if i is equal to arr.length or greater than it then return maximum int value as we are calculating minimum 
        {
            return Integer.MAX_VALUE;
        }
       if(i == arr.length-1 && j == arr[0].length -1)
       {
          storage[i][j] = arr[i][j];
          return storage[i][j];
       }
       if(storage[i][j] != -1)  //if storage[i][j] is a positive value then recursion have stored it in so use that value 
       {
          return storage[i][j];
       }
       int opt1 = MinimumCostPathMemohelper(arr, i, j + 1, storage);
       int opt2 = MinimumCostPathMemohelper(arr, i + 1, j + 1, storage);
       int opt3 = MinimumCostPathMemohelper(arr, i + 1, j, storage);
       storage[i][j] = arr[i][j] + Math.min(opt1,Math.min(opt2, opt3));
       return storage[i][j];
    }
    public static int MinimumCostPathDP(int arr[][])
    {
       int dp[][] = new int[arr.length][arr[0].length];
       dp[arr.length-1][arr[0].length - 1] = arr[arr.length-1][arr[0].length-1];
       for(int j = arr[0].length-2;j>=0;j--)  //last row 
       {
          dp[arr.length-1][j] = dp[arr.length-1][j+1] + arr[arr.length-1][j];
       }
       for(int i = arr.length-2;i>=0;i--)  //last column
       {
          dp[i][arr[0].length-1] = dp[i+1][arr[0].length-1] + arr[i][arr.length-1]; 
       }
       for(int i = arr.length-2;i>=0;i--)
       {
        for(int j = arr[0].length-2;j>=0;j--)
        {
            dp[i][j] = arr[i][j] + Math.min(dp[i+1][j+1], Math.min(dp[i+1][j], dp[i][j+1]));
        }
       }
       return dp[0][0];
    }
    public static void main(String[] args) {
        int arr[][] = {{1,1,1},{4,5,2},{7,8,9}};
        System.out.println(minimumcostpath(arr));
        System.out.println(MinimumCostPathMemo(arr));
        System.out.println(MinimumCostPathDP(arr));
    }
}
