package DynamicProgramming;

public class ZeroOneKnapSack {  //maximum sum of numbers which will have some weights assigned to it and we have to make the maximum sum such that the sum of their weights do not increase the bag weight 
    
    public static int ZeroOneKnapSackDp(int val[],int weights[],int Bcap) //array of values or runs a player can make, array of weights or the balls which a player will take to score  runs, Bag capacity or total balls  
    {                      //val.length + 1 because on 0th index of row there is empty set or no players ,Bcap + 1 because if the bagcapcity is 7 we will recieve result on index 7 so if we need index 0-7 then size will be 8 on column we store the subproblems which reach till the bag capacity
       int dp[][] = new int[val.length + 1][Bcap + 1];  //on rows we will keep number of values,weights or player potential to score, number of balls on columns we will keep number of weights or ball will be calculating subproblem of smaller weights to reach larger 
      
       for(int i = 1;i<dp.length;i++)  //the loop starts from 1 because on 0th row there is empty set of numbers or no players so the 0th row contains all 0's and 0th column there are no balls left or no weights to maintain max sum so sum will be 0 on 0th column 
       {
         for(int j = 1;j<dp[0].length;j++)  
         {                      //including the current player 
            if(j >= weights[i-1]) //the value of i starts from 1st index so for working on 0th index we have to take i-1  
            {                    //if j is greater than or equal to the balls which a player can play
                int remcap = j-weights[i-1]; //jth - balls a player will play 
               if(dp[i-1][remcap] + val[i-1] > dp[i-1][j]) //sum of the score if player plays + sum of the score of the rest of the team from remaining balls left by that player if it is greater than the scenario in which player donot plays then we will set this on dp[i][j]
               {
                  dp[i][j] = dp[i-1][remcap] + val[i-1]; 
               }
               else //else if current player donot plays and sum of rest of the team is greater for the given number of balls than the scenario if the current player plays then set the remaining team score 
               {
                 dp[i][j] = dp[i-1][j];
               }
            }
            else  //else if j is less than current element or number of balls is less than a player takes to score some runs then set the remaining team score  
            {
                dp[i][j] = dp[i-1][j];
            }
         }
       }
       return dp[val.length][Bcap];
    }
    public static void main(String[] args) {
        int val[] = {15,14,10,45,30};
        int weights[] = {2,5,1,3,4};
        System.out.println(ZeroOneKnapSackDp(val, weights, 7));
    }
}
