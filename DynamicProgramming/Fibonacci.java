package DynamicProgramming;

public class Fibonacci 
{                 //Fibonacci numbers --> //0th no  1th no  2th no  3th no
                                            //f(0)  f(1)    f(2)    f(3)   //[f(2) + f(1) = f(3)]  i.e f(n-2) + f(n-1) = f(n) 
    public static int FibonacciRecur(int n)  // 0    1       1        2     //  1   +  1   =  2  to find the 2th fibonacci number we have to know the result of 1th fibonacci number and 0th fibonacci number which are our base case as 0th fibonacci number is 0 and 1th fibonacci number is 1 
    {
       if(n == 0 || n == 1)
       {
          return n;
       }
       return FibonacciRecur(n-1) + FibonacciRecur(n - 2);
    } 
    public static int FibMemoization(int n)
    {
       int storage[] = new int[n+1]; //if we have to find 3rd fibonacci number the maximum calling can reach till f(0) which is 0 to 3 i.e 4 calls means we have to store result of 4 calls so for n = 3 array storage will be 4 so one more for every n 
       for(int i = 0;i<=n;i++) //for array with storage 4 last available index is 3 and our n is also 3 so upto n we will insert -1 
       {
          storage[i] = -1; //inserting -1 because fibonacci series have positive integers while searching the stored result if we find positive integer or not equal to 1 then we will use it 
       }
      return FibMemoizationSolver(n,storage);
    }
    private static int FibMemoizationSolver(int n, int[] storage) {
        if(n == 0 || n == 1)
        {
            storage[n] = n;
            return storage[n]; 
        }
        if(storage[n] != -1)
        {
           return storage[n];
        }
        storage[n] = FibMemoizationSolver(n-1,storage) + FibMemoizationSolver(n-2, storage);
        return storage[n];
    }
      public static int FibDp(int n)
      {
         int storage[] = new int[n + 1]; //for n = 3 , 4 calls are made till 0 so 0 to 3 total 4 so size of array is n + 1
         return FibDpdo(n,storage);
      }
    private static int FibDpdo(int n, int[] storage) { //by dynamic programming
         storage[0] = 0;
         storage[1] = 1;
         for(int i = 2;i<=n;i++) //<= n because what if n = 2 then if i<n condition will not run and value of n = 2 will not be calculated 
         {
            storage[i] = storage[i-1] + storage[i-2];
         }
         return storage[n];
      }
   public static void main(String[] args) {
        int n = 44;
      //   int n = 5;
        System.out.println(FibMemoization(n));
        System.out.println(FibDp(n));
        System.out.println(FibonacciRecur(n));
    }
}
