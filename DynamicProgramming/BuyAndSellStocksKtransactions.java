package DynamicProgramming;

public class BuyAndSellStocksKtransactions {
    public static int BuyAndSellStocksKtransactionsDp(int prices[],int k)
    {                        //on rows we are keeping the number of transactions and columns we are storing change of prices  on different days that transactions should take place 
        int dp[][] = new int[k+1][prices.length]; //for k = 3 transactions index will be 0 to 3 so giving storage 3 will only give us index 0 to 2 to in order to have 3rd index storage will be 4 i.e k+1  
        for(int i = 1;i<dp.length;i++)  //on number of transactions the outer koop will run 
        {
            int max = Integer.MIN_VALUE;  //after completing all the possible options for one transaction for a particular day max will again reset to max value for next transaction 
            for(int j = 1;j<dp[0].length;j++)  //inner loop runs on prices varying on different days 
            {
               if(dp[i-1][j-1] - prices[j-1] > max) 
               {
                 max = dp[i-1][j-1] - prices[j-1];
               }
               if(max + prices[j] > dp[i][j-1])
               {
                 dp[i][j] = max + prices[j];
               }
               else 
               {
                dp[i][j] = dp[i][j-1];
               }
               
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
    public static void main(String[] args) {
        int prices[] = {9,6,7,6,3,8};
        System.out.println(BuyAndSellStocksKtransactionsDp(prices, 3));
    }
}
