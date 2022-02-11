package Arrays;

public class Secondlargest {
    public static int print2largest(int A[]) 
    {
       int secmax = Integer.MIN_VALUE;
       int max = Integer.MIN_VALUE;
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
       if(secmax == max || secmax == Integer.MIN_VALUE)
       {
           return -1;
       }
       
       return secmax;
      
    }
    public static void main(String[] args) {
        int arr[] = {10,10,10,10,10};
        int a = print2largest(arr);
        System.out.println(a);
    }
}
