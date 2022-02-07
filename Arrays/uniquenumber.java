package Arrays;

public class uniquenumber {
    public static int findUnique(int[] arr){
        int uni = 0;
         for(int val : arr)
         {
             uni = uni^val;
         }
         return uni;
     }
     public static void main(String[] args) {
         int arr[] = {2,7,8,3,8,3,2};
         System.out.println(findUnique(arr));
     }
}
