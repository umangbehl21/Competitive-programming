package Arrays;

public class Secondlargest {
    public static int print2largest(int A[]) 
    {
       int secmax = -1;
       int max = -1;
       for(int i = 0;i<A.length-1;i++)
       {
           if(A[i] > max)
           {
              secmax = max;
               max = A[i];
           }
           if(A[i] > secmax && A[i] < max)
           {
               secmax = A[i];
           }
           
       }
       
       return secmax;
      
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,9,6,8};
        int a = print2largest(arr);
        System.out.println(a);
    }
}
