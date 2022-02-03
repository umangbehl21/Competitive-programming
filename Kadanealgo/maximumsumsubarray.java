package Kadanealgo;

public class maximumsumsubarray {
    public static int maxsum(int arr[])
    {
       int csum = arr[0];
       int osum = arr[0];
       for(int i = 0;i<arr.length;i++)
       {
           if(csum >= 0)
           {
               csum+=arr[i];
           }
           else
           {
               csum = arr[i];
           }
           if(csum > osum)
           {
               osum = csum;
           }
       }
       return osum;

    }
    public static void main(String[] args) {
        int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
        int a = maxsum(arr);
        System.out.println(a);
    }
}
