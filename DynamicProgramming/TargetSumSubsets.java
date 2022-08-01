package DynamicProgramming;

public class TargetSumSubsets {  //if given number of numbers can have their sum or their any subset sum equal to the given target 
    public static boolean TargetSumSubsetsDp(int arr[],int tar)
    {  //boolean array because we have to store true or false that whether current elements can make a subproblem 
       boolean dp[][] = new boolean[arr.length + 1][tar + 1]; //arr.length + 1 because on 0th index it have the empty subset placed there and the numbers start from the 1st row tar + 1 because for target = 10 we will need index till 10 and index till 10 means 11 number of columns 
       for(int i = 0;i<dp.length;i++)
       {
        for(int j = 0;j<dp[0].length;j++)
        {
            if(i == 0 && j == 0) //when empty subset have to represent 0th subproblem dp[0][0] will be true
            {
                dp[i][j] = true; 
            }
            else if(i == 0) //means when empty subset is asked to fullfil the target greater than 0 it cannot do so insert false on the 0th row 
            {
                dp[i][j] = false;
            }
            else if(j == 0) //whenever j will be 0 we are asking the subsets of array element that if they can fulfill target empty or 0 suppose element is 4 it has two subsets {4,_} (4,empty) empty can represent 0 likewise every subset have empty they can represent 0 so insert true 
            {
               dp[i][j] = true;
            }
            else 
            {                          //dry run for single element 4 
                if(dp[i-1][j] == true)  //on the dp[1][4] 4 will check if I dont include myself in the subset then can the remaining subset which is empty make 4 which is false so condition will be false
                {
                   dp[i][j] = true;
                }
                else 
                {    
                   int val = arr[i-1];   //the reason for arr[i-1] is that on i = 0 or 0th row empty subset is there in the 2d array but arr[] have normal indexing and have first element on 0th index so loop come into action and started to operate for arr 0th element when i = 1 so i-1 index give us 0th element of arr[] 
                   if(j >= val) //for array element = 4 we can only solve subproblem greater than or equal to 4 if j = 3 and element is 4 then 3-4 will give -1 index 
                   {
                    if(dp[i-1][j-val] == true)  //for subproblem 4 and element 4 if 4 include itself in the subset then 4-4 = 0 which its remaining subset empty can fulfil 
                    {
                      dp[i][j] = true;
                    }
                    else 
                    {
                        dp[i][j] = false; //of even after including an element its rest of the team subset cannot fulfil the remaining target then insert false 
                    }
                   }
                }
            }
        }
       }
       return dp[dp.length-1][dp[0].length - 1]; 
    }
    public static void main(String[] args) {
        int arr[] = {4,2,7,1,3};
        System.out.println(TargetSumSubsetsDp(arr, 10));
    }
}
