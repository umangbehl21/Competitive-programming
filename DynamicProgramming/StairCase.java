package DynamicProgramming;

public class StairCase {
    public static int climbwaysRecursive(int n) {
        if (n == 1 || n == 0) {
            return 1;
        } else if (n == 2) {
            return n;
        } else {
            return climbwaysRecursive(n - 3) + climbwaysRecursive(n - 2) + climbwaysRecursive(n - 1);
        }
    }
    public static int stairCaseDp(int n)
    {
       int dp[] = new int[n + 1];
       dp[0] = 1;  //for 0 stair there is one way to climb 
       dp[1] = 1; //for 1 stair there is again one way to climb 
       dp[2] = 2; //for 2 stair there are two ways 
       for(int i = 3;i<=n;i++)
       {
        dp[i] = dp[i-1] + dp[i-2] + dp[i-3]; //for 3rd stair onward the number of ways are the submation of combinations of last three stairs 
       }
       return dp[n]; 
    }
    public static void main(String[] args) {
        System.out.println(stairCaseDp(35));
        System.out.println(climbwaysRecursive(35)); 
    }
}
