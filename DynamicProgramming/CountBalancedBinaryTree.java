package DynamicProgramming;

public class CountBalancedBinaryTree 
{  
    private static int CountBalancedBinaryTreeRecur(int h,int mod)
    {
         if(h == 0 || h == 1) //for height is 0 empty binary tree can be formed for height = 1 again 1 binary tree can be formed 
         {
            return 1;
         }  
         int x = CountBalancedBinaryTreeRecur(h - 1); //for h - 1 there can be x combinations and that x combination can further be represented in many ways so when the height of left subtree and right subtree are equal combinations of count are x * x
         int y = CountBalancedBinaryTreeRecur(h - 2); //for h - 2 there can be y combinations and that y combination can further be represented in many ways so the count is calculated through x * y combinations 
         long res1 = (long)x * x;  //calculating calculations in long to store big number 
         long res2 = 2*((long)x * y); //whenever we multiply long with int the calculation are then done in long not int 
         int value1 = (int)(res1 % mod);  //it might happen that res1 or res2 becomes negative(i.e number is too big it rounded off to negative) so take its modulo to bring it within int range and then type cast long into int
         int value2 = (int)(res2 % mod);
         return (value1 + value2) % mod; //now it may happen adding two big int values again give result out of range so we will again take modulo 
    } 

    public static int CountBalancedBinaryTreeRecur(int h) {
       int mod = (int)Math.pow(10, 9) + 7; //range in which int lies it is used here to convert result in negative number or out of range from int to bring it into range by taking modulo with the maximum limit of int
        return CountBalancedBinaryTreeRecur(h, mod);
    } 

    public static int CountBalancedBinaryTreeDp(int h) 
    { 
        int mod = (int)Math.pow(10, 9) + 7;
        int dp[] = new int[h + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2;i<=h;i++)                
        {   int x = dp[i-1];                 //x * x + 2 * x * y same logic as recursion 
            int y = dp[i-2];                              
            long res1 = (long)x * x;   //calculating calculations in long to store big number 
            long res2 = (long)x * y * 2; //whenever we multiply long with int the calculation are then done in long not int
            
            int value1 = (int)(res1 % mod);  //it might happen that res1 or res2 becomes negative(i.e number is too big it rounded off to negative) so take its modulo to bring it within int range and then type cast long into int
            int value2 = (int)(res2 % mod);
            
            dp[i] = (value1 + value2) % mod; //now it may happen adding two big int values again give result out of range so we will again take modulo                                                     
          
            // dp[i] = ((dp[i - 1] *  dp[i - 1]) % mod  + ( 2 * dp[i-2]) % mod * dp[i-1]) % mod; // or can write in one line like this 
        }
        return dp[h];
    }
    public static void main(String[] args) {
        System.out.println(CountBalancedBinaryTreeDp(5));
        System.out.println(CountBalancedBinaryTreeRecur(5));
    }


}
