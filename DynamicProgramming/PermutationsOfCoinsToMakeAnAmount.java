package DynamicProgramming;

public class PermutationsOfCoinsToMakeAnAmount 
{
   public static int PermutationsOfCoinsToMakeAnAmountDp(int coins[],int tar)
   {
       int dp[] = new int[tar + 1];
       dp[0] = 1; //for zero coin there is one way just like x^0 is 1 
       for(int i = 0;i<dp.length;i++)
       {
          for(int coinVal : coins)  //now for every coin we will find the ways for the subproblem smaller than the target for example tar = 6 we will find and fill the subproblem from 0 to 5 using every coin 2,3,4 for example for coin = 5 i.e 5-2 = 3 so if there are ways to pay 3 then we can pay 5 too so number of ways to pay 3 will be added in 5 too similarly 5-3 = 2 if there are ways to pay 2 then we can pay 5 too so number of ways to pay 2 will be added in 5 
          {  
              if(coinVal <= i) //if the value of the coin is less than that of subproblem then only it is used to pay for subproblem example if coin is 4 and we have to pay 2 from it we cannot pay so we will check that coin we have is less than subproblem 
              {
                 dp[i] += dp[i - coinVal]; //we will add all the ways in which subproblem can be paid for example if dp[6] can be paid in 4 ways and dp[8] have come to dp[6] to find how many ways dp[6] can be paid in all those ways dp[8] can also be paid same goes with dp[5] and dp[4] so it will do dp[8]+= dp[6] + dp[5] + dp[4] 
              }      
          }

       }
       return dp[tar];  //in the end return the target 
   }
   public static void main(String[] args) {
    int coins[] = {2,3,4};
    System.out.println(PermutationsOfCoinsToMakeAnAmountDp(coins, 8));
    
   }

}
