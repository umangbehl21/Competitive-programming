package DynamicProgramming;
import java.util.*;
public class MaximumSquareMatrixWithall1
{
    public static int MaximumSquareMatrixWithAll1(int arr[][])
    {
        int ans = 0;
        int dp[][] = new int[arr.length][arr.length];
        for(int i = dp.length-1;i>=0;i--)
        {
           for(int j = dp[0].length - 1; j >= 0;j--)
           {
              if(i == dp.length-1 && j == dp[0].length-1)  //when we are at the corner cell last row last column set element as it is in dp
              {
                 dp[i][j] = arr[i][j];
              }   
              else if(i == dp.length-1)  //fill the last row as it is because they contain all the single numbers which can only make one square on individual level 
              {
                dp[i][j] = arr[i][j];
              }
              else if(j == dp[0].length-1) //j is on last column insert the number there and then j will gradually start decreasing and when i is not eqal to dp.length - 1 and j is also not equal to dp[0].length - 1 then i and j are somewhere in the middle of the matrix from where we can take the horizontal,vertical and diagonal minimum  
              {
                 dp[i][j] = arr[i][j];
              }
              else  //else we are not on the corners we are somewhere in the mid  
              { 
                  if(arr[i][j] == 0)  //if number in middle is 0 then simply put 0 at that position as no square can be made by including 0 
                  {
                    dp[i][j] = 0;
                  }
                  else  //else if it is 1 take the minimum from its vertical diagonal and horizontal boundaries to check that how large can current element form subsquare of 1's if any of the vertical horizontal or diagonal value contain 0 current element can only make 1 square of its own else if all these boundaries contail 1 current element can unite with them to make bigger square of 2 * 2
                  {
                  int min = Math.min(dp[i][j+1],dp[i+1][j]);  //horizontal min vs vertical min 
                  min = Math.min(min,dp[i+1][j+1]); //min from horizontal and vertical vs diagonal min
                  dp[i][j] = min+1; //till min dimensions there is no doubt that there will be any 0 so we can add 1 in it as if it is the minimum the rest will be greater than or equal to it which will be covering the same area that we incremented by adding 1 
                  if(dp[i][j] > ans) //if current square is greater than previous answer update ans 
                  {
                     ans = dp[i][j];
                  }
                 }

              }
           }

        }
        return ans;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[][] = new int[5][6];
        System.out.println("enter matrix");
        for(int i = 0;i<arr.length;i++)
        {
            for(int j = 0;j<arr.length;j++)
            {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(MaximumSquareMatrixWithAll1(arr));
    }

}