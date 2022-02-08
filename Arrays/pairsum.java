package Arrays;
import java.util.*;
public class pairsum {
    public static void pair(int arr[],int target)
    {
       Arrays.sort(arr);
       int li = 0;
       int ri = arr.length-1;
       while(li<ri)
       {
          if(arr[li]+arr[ri] > target)
          {
            ri--;
          }
          else if(arr[li]+arr[ri] < target)
          {
              li++;
          }
          else
          {
              System.out.println(arr[li]+" "+arr[ri]);
              li++;
              ri++;
          }
       }

    }
    public static void main(String[] args) {
        int arr[] = {7,15,3,18,6,4,19,2,12,11,9};
        pair(arr, 15);
    }
}
