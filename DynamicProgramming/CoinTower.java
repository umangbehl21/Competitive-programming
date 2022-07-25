package DynamicProgramming;
 
public class CoinTower {   //approach to solve question is if any of n-1 or n-x or n-y subproblems stores false in them means A lost previously then now for n A can win 
    public static boolean coinTower(int n,int x, int y)
    {
        boolean dp[] = new boolean[n+1]; // for n = 4 we need answer for 4th index in dp so 4th index will only be available if the storage is 5 which is n+1
                                         //array of boolean we will store true or false for the subproblems to find for N
        
        dp[0] = false; //for 0 coin A will lose as first turn is of A and he will not be able to pick anything 
        dp[1] = true; //for 1 coin A will win as there is only one coin and A have first turn so he will pick it and b will have nothing to pick
        
        for(int i = 2;i<=n;i++) //<=n as for n = 4 we will have to fill till 4th index
        {                    
                                            //if any of the below condition is true then for current subproblem a will will 
           if(i-1 >=0 && dp[i-1] == false)  //if i-1 is > or = to 0 and its previous subproblem was false or a lost there then this time a will win 
           {                                //example for n = 3 if we reduce 1 i.e n-1 = 2 now for dp[2] A lost so if statement will be true and dp[3] will be true 
             dp[i] = true;
           }
           else if(i-x >= 0 && dp[i-x] == false) //if option x = 4 and n = 4 then n-x = 0 on dp[0] A loses as there was nothing to pick so now for dp[4] A will win 
           {
            dp[i] = true;
           }
           else if(i-y >= 0 && dp[i-y] == false)  //if option y = 5 and n = 7 so n-y = 7-5 = 2 so at dp[2] answer was false so now on dp[7] answer will be true 
           {
            dp[i] = true;
           }
           else  //for example if n = 2 and options of coins to pick are 1 , 3 , 5 now 2-1 = 1 will only be greater than 0 but for dp[1] result is true so dp[2] will be false 
           {
            dp[i] = false; 
           }
        }
         return dp[n];                                
    }
    public static void main(String[] args) {
        boolean ans = coinTower(4, 3, 4);  //A wins
        // boolean ans = coinTower(2, 3, 4);  //B wins
        if(ans)
        {
            System.out.println("A wins");
        }
        else 
        {
            System.out.println("B wins");
        }
    }
}
