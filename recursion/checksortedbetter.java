package recursion;

public class checksortedbetter {
    public static boolean ifsorted(int arr[],int startindex)
    {
           if(startindex == arr.length-1)
           {
               return true;
           }
           if(arr[startindex] > arr[startindex + 1])
           {
               return false;
           }
           return ifsorted(arr, startindex+1);
    }
      public static void main(String[] args) {
          int arr[] = {1,2,3,4};
          System.out.println(ifsorted(arr,0));
      }
}
