package DynamicProgramming;

public class MatrixChainMultiplication {
    public static int MatrixChainMultiplicationDP(int arr[])
    {
        int dp[][] = new int[arr.length - 1][arr.length - 1]; //because array size of 6 represent 5 number of matrix so length will be 5 we have to fill dp till [4][4]
        for(int g = 0;g < dp.length;g++)
        {
           for(int i = 0,j = g;j<dp.length;i++,j++)
           {
              if(g == 0)  //for first diagonal when gap is 0
              {
                 dp[i][j] = 0;
              }
              else if(g == 1) //for second diagonal when gap is 1
              {
                 dp[i][j] = arr[i] * arr[j] * arr[j+1];  
              }
              else   //for third and 4th diagonal when gap is 2 or 3 or 4
              {
                int min = Integer.MAX_VALUE;
                for(int k = i;k<j;k++) // k<j because last split is at index 3 for abcde last split after 3 which will make abcd left part and e right if our j is on 4 so k will remain less than 4 or iterate upto index 3 
                {
                    int lc = dp[i][k]; //the left part cost can be picked from dp for abcde if a is the left part and bcde the right part then for i = 0 k = 0 dp[0][0] contains cost of A amd for bcde as k is on 0 the right part start from k+1 and ends at j so dp[k+1][j] we will get the bcde in gap capacity 
                    int rc = dp[k+1][j]; // for bcde as k is on 0 the right part start from k+1 = 1 and ends at j = 4 so dp[k+1][j] we will get the cost of bcde in gap capacity 
                    int mc = arr[i] * arr[k+1] * arr[j+1]; //for multiplication cost A*(bcde) the dimension of A lies in k to k + 1(i.e 0th index to 1st index) in arr[] array and for Bcde dimension lies from k + 1 to j + 1(i.e 1st to 5th index) starting point remain the same ending point is increased by 1 the k+1 is common in both so formula is arr[i] * arr[k+1] * arr[j+1]
                    int tc = lc + rc + mc;
                    if(tc < min) 
                    {
                        min = tc;
                    } 
              }
              dp[i][j] = min;
           }

        }
    }
    return dp[0][dp[0].length-1];    
}
public static void main(String[] args) {
    int arr[]= {10,20,30,40,50,60};
    System.out.println(MatrixChainMultiplicationDP(arr));
}
        
}
