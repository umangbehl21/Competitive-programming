package DynamicProgramming;

public class OptimalStratergy {
     public static int OptimalStratergyDp(int arr[])  //approach around which question revolves is do the best when you have to choose assume the worst when things happens to you as opponent will give us minimum number during his turn 
     {
        int dp[][] = new int[arr.length][arr.length];  //4 rows 4 cols 
        for(int g = 0;g<dp.length;g++) //dp.length is the number of one d arrays in the 2d array or the number of rows 
        {
            for(int i = 0,j = g;j<dp.length;i++,j++) //j is less than dp.length because when g = 1 or 2 or 3 j will be start from g and our i will start from 0 so j will exhaust early so if we write i < dp.length it will be index out of bound for j            {
            {
                if(g == 0)
                {
                    dp[i][j] = arr[i];
                }
                else if(g == 1)  //for two numbers we will store max of two in the gap capacity matrix 
                {
                    dp[i][j] = Math.max(arr[i],arr[j]);
                }
                else 
                {
                   int val1 = arr[i] + Math.min(dp[i+2][j],dp[i+1][j-1]); //if we choose i -> opponent will choose from i+1,j now if opponent chooses i+1 then we will have i+2,j or if opponent chooses j then we will have i+1,j-1 so assuming that worst will happen to us so we will take minimum of the two 
                   int val2 = arr[j] + Math.min(dp[i+1][j-1],dp[i][j-2]); //if we choose j -> opponent will choose from i,j-1 now if opponent chooses j-1 we will have i,j-2 or if opponent chooses i then we will have i+1,j-1 assuming that worst will happen to us we will take the minimum  of these two 
                   int val =  Math.max(val1,val2);
                   dp[i][j] = val;
                }
            }

        }
        return dp[0][dp[0].length-1]; //return the edge of gap capacity matrix first row last column from dp[0] we will get the first 1d array and from the dp[0].length we will get the length of that 1d array and by deducting - 1 from it we will get the last element from the first row 
    }
    public static void main(String[] args) {
         int arr[] = {20,30,2,10};
         System.out.println(OptimalStratergyDp(arr)); 
    }
}
