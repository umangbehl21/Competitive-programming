package Kadanealgo;

public class maximumsumsubarray {
    public static int maxsum(int arr[])
    {
       int csum = 0;
       int osum = 0;
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
        int arr[] = {1 ,2 ,3 ,-2,5};
        int a = maxsum(arr);
        System.out.println(a);
    }
}
