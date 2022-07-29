package DynamicProgramming;

public class LongestCommonSubsequence 
{
   public static int LongestCommonSubsequenceRecur(String s1,String s2)
   {
      if(s1.length() == 0 || s2.length() == 0)
      {
        return 0;
      }
      if(s1.charAt(0) == s2.charAt(0))
      {
        return 1 + LongestCommonSubsequenceRecur(s1.substring(1), s2.substring(1));
      }
      else 
      {
         int opt1 = LongestCommonSubsequenceRecur(s1, s2.substring(1));
         int opt2 = LongestCommonSubsequenceRecur(s1.substring(1), s2);
         return Math.max(opt1, opt2);
      }
   }
   public static int LongestCommonSubsequenceMemo(String s1,String s2)
   {
       int storage[][] = new int[s1.length() + 1][s2.length() + 1]; //the 2d matrix is of one more tham the actual length of the strings because if any of the string length is 0 or on 0 th row or 0th column all the zero will be placed as one oft eh string becomes empty there and the result of lcs between two string comes upon the s1.length,s2.length example if the two strings are "adg" and "bag" then the result will be stored on 3,3 index as both the length of string is 3 and if any of the string length is reduced to 1 then it will move to 3,2 index 
       for(int i = 0;i<storage.length;i++)
       {
        for(int j = 0;j<storage[0].length;j++)
        {
            storage[i][j] = -1;  //storing -1 helps to differentiate that we are visiting a matrix block first time if we are visiting second time some lcs will be stored on that and lcs is always positive integer 
        }
       }
       return LongestCommonSubsequenceMemoHelper(s1, s2,storage);
   }
   private static int LongestCommonSubsequenceMemoHelper(String s1, String s2, int[][] storage) {
       
      int l1 = s1.length();
      int l2 = s2.length();
      if(storage[l1][l2] != -1)
      {
        return storage[l1][l2];
      }
      if(s1.length() == 0 || s2.length() == 0)
      {
         storage[l1][l2] = 0;
         return 0;
      }
      if(s1.charAt(0) == s2.charAt(0))
      {
          storage[l1][l2] = 1 + LongestCommonSubsequenceMemoHelper(s1.substring(1), s2.substring(1), storage); 
          return storage[l1][l2];
      }
      else 
      {
          int opt1 = LongestCommonSubsequenceMemo(s1, s2.substring(1));
          int opt2 = LongestCommonSubsequenceMemo(s1.substring(1), s2);
          storage[l1][l2] = Math.max(opt1, opt2);
          return storage[l1][l2];
      }

    }
    public static int LongestCommonSubsequenceDp(String s1,String s2)
    {
      int dp[][] = new int[s1.length() + 1][s2.length() + 1];
      for(int i = dp.length-2;i>=0;i--)
      {
         for(int j = dp[0].length-2;j>=0;j--)
         {
             if(s1.charAt(i) == s2.charAt(j))
             {
                dp[i][j] = 1 + dp[i+1][j+1]; //when both characters are same we move diagonally length of both the string reduced by 1 as the first character of both strings are equal 
             }
             else  //we take max bwtween the horizontal and vertical elements
             {
                dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j]);
             }
         }
      }
      return dp[0][0];
    }
public static void main(String[] args) {
      String s1 = "abcd";
      String s2 = "aebd";
      System.out.println(LongestCommonSubsequenceDp(s1, s2));
      System.out.println(LongestCommonSubsequenceRecur(s1, s2));
      System.out.println(LongestCommonSubsequenceMemo(s1, s2));
   }

}
