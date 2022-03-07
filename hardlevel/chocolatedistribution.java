package hardlevel;

import java.util.Arrays;

public class chocolatedistribution {
    public static int choco(int arr[],int m)      
    {
       int ans = Integer.MAX_VALUE;
       Arrays.sort(arr);
       for(int i = 0;i<= arr.length - m;i++)  //to find the starting point of the last combination subtract the length of array from the m(which is the total packets children have) 8-5 = 3rd index will be start of last combination
       {
           int min = arr[i]; //minimum starting point of combination
           int max = arr[i + m - 1]; //maximum ending point of combination for example  0 to 5 ending point is 5 + 0 - 1 = 4
           int gap = max - min; 
           if(gap < ans)
           {
               ans = gap;
           }
       }
       return ans;
    }
    public static void main(String[] args) {
        int arr[] = {1,3,4,7,9,9,12,56};
        System.out.println(choco(arr, 5));
    }
}
