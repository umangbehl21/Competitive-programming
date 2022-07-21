package DynamicProgramming;

public class LongestIncreasingSubsequence {
    public static int LongestIncreasingSubsequenceDp(int arr[])
    {
        int dp[] = new int[arr.length];
        int omax = 0;
        for(int i = 0;i<arr.length;i++)           //find the longest subsequence till every element and maintain the overall maximum
        {   int max = 0;
            for(int j = 0;j<i;j++)  //j will run till the current element till which longest subsequence should be find 
            {
              if(arr[j] < arr[i]) //if courrent element is greater than the previous of its element 
              {
                if(dp[j] > max)  //we have to find the number which is having largest subsequence within the range less than i and check if that subsequence stored in dp[j] > maximum subsequence till now if it is greatest update maximum 
                {
                    max = dp[j];
                }
              }
            }
            dp[i] = max + 1; //coming out of loop consider the current lement in the increasing maximum subsequence too 
            if(dp[i] > omax) //if our current element is having the largest subsequence till now update the overall max 
            {
                omax = dp[i];
            }
        }
        return omax;
    }
    public static void main(String[] args) {
        int arr[] = {10,22,9,33,21,50,41,60,80,1};
        System.out.println(LongestIncreasingSubsequenceDp(arr));
    }
}
