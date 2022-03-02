package recursion;

public class checknumberrecursively {
    public static boolean ispresent(int arr[],int n,int num)
    {
         if(n == 0 && arr[0] != num)
         {
             return false;
         }
         if(arr[n-1] == num)
         {
             return true;
         }
         return ispresent(arr, n-1, num);
    }
    public static void main(String[] args) {
        int arr[] = {9,8,20};
        System.out.println(ispresent(arr, arr.length, 20));
    }

}
