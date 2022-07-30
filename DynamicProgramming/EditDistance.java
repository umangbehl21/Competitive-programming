package DynamicProgramming;
public class EditDistance
{
  public static int EditDistanceRecure(String s1,String s2)
  {
     if(s1.length() == 0)
     {
        return s2.length();
     }
     if(s2.length() == 0)
     {
        return s1.length();
     }
     if(s1.charAt(0) == s2.charAt(0))
     {
        return EditDistanceRecure(s1.substring(1), s2.substring(1));  //when the first character of both the strings are same then we dont have to make any changes to current string don't add 1 just reduce both string by 1 
     }
     else 
     {
        int opt1 = EditDistanceRecure(s1,s2.substring(1));     //insert
        int opt2 = EditDistanceRecure(s1.substring(1), s2); //delete 
        int opt3 = EditDistanceRecure(s1.substring(1), s2.substring(1)); //substitute
        return 1 + Math.min(opt1, Math.min(opt2, opt3));
    }
  }
  public static int EditDistanceDp(String s1,String s2)
  {
      int m = s1.length();
      int n = s2.length();
      int dp[][] = new int[m+1][n+1]; //for m and n length of string there are m+1 * n + 1 unique calls and result of the string come on the dp[m][n] index if any of the length of the string is 0 then we assign the length of the second string on that index which is our base case 
      for(int j = 0;j<dp[0].length;j++) 
      {
          dp[0][j] = j;
      }
      for(int i = 0;i<dp.length;i++)
      {
         dp[i][0] = i;
      }
      for(int i = 1;i < dp.length;i++)
      {
        for(int j = 1;j< dp[0].length;j++)
        {
            if(s1.charAt(m-i) == s2.charAt(n-j))
            {
                dp[i][j] = dp[i-1][j-1];
            }
            else 
            {
                dp[i][j] = 1 + Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
            }
        }
      }
      return dp[m][n]; 

  }
  public static void main(String[] args) {
    String s1 = "abg";
    String s2 = "edf";
    System.out.println(EditDistanceDp(s1, s2));
    System.out.println(EditDistanceRecure(s1,s2));
  }

}