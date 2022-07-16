package DynamicProgramming;

public class ReduceNumTo1 {
    
    public static int RecursiveReduceTo1(int n)
    {
       if(n == 1)
       {
        return 0;
       }
       int opt1 = RecursiveReduceTo1(n - 1);  //option 1 by reducing value by 1 
       int minstep = opt1;  
       if(n % 3 == 0)
       {
          opt1 = RecursiveReduceTo1(n / 3); //option2 by dividing by 3
          if(minstep > opt1)
          {
            minstep = opt1;
          }
       }
       if(n % 2 == 0)
       {
         opt1 = RecursiveReduceTo1(n/2);  //option 3 by dividing by 2
         if(minstep > opt1)
         {
            minstep = opt1;
         }
       }
       return minstep + 1;
    }
    private static int ReduceTo1MemoizationDo(int n, int[] storage) 
    {
        if(n == 1)
        {
            storage[n] = 0;
            return storage[n];
        }
        int opt1 = ReduceTo1MemoizationDo(n-1,storage);
        int minstep = opt1;
        if(n % 3 == 0)
        {
            if(storage[n/3] != 0)   //first check that if array contains the step value of the smaller step example 9/3 = 3 if we have value of 3th index in array 9 can easily add 1 to calculate itself and there will be no need to go in else part to make a redundant call 
            {
              opt1 = storage[n/3];
            }
            else
            {
            opt1 = ReduceTo1MemoizationDo(n/3, storage);
            }
            if(minstep > opt1)
            {
                minstep = opt1;
            }
        }
        if(n % 2 == 0)
        {     
            if(storage[n/2] != 0)  //first check that if array contains the step value of the smaller step example 4/2 = 2 if we have value of 2th index in array 4 can easily add 1 to calculate itself and there will be no need to go in else part to make a redundant call 
            {
              opt1 = storage[n/2];
            }
            else
            {
             opt1 = ReduceTo1MemoizationDo(n/2, storage);
            }
            if(minstep > opt1)
            {
                minstep = opt1;
            }
        }
        storage[n] = minstep + 1;
        return storage[n];
    }
    public static int ReduceTo1Memoization(int n)
    {
        int storage[] = new int[n + 1];
        return ReduceTo1MemoizationDo(n,storage);   
    }
    public static int ReduceToN_Dp(int n)
    {
        int storage[] = new int[n + 1];
        storage[1] = 0; //although by default values on array is 0 but for the clarity i have inserted 0 
        for(int i = 2;i<=n;i++)
        {
           int opt1 = storage[i-1];
           int minstep = opt1;
           if(i % 3 == 0)
           {
             
            if(minstep > storage[i/3])
            {
                minstep = storage[i/3];
            }
           }
           if(i % 2 == 0)
           {
            if(minstep > storage[i/2])
            {
               minstep = storage[i/2];
            }
           }
           storage[i] = minstep + 1;
        }
        return storage[n];
       
    }
    public static void main(String[] args) {
        System.out.println(ReduceToN_Dp(500));
        System.out.println(ReduceTo1Memoization(500));
        System.out.println(RecursiveReduceTo1(500));

    }
}
