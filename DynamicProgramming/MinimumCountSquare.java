package DynamicProgramming;

public class MinimumCountSquare            //what's happening in the question is we are forming the least route to make the number itself i.e for n = 9 n can take steps of n = 8(as if we subtract 9 - 1^2 = 8) and n = 5(as if we subtract 9 - 2^2 = 5) and n = 0(as if we subtract 9 - 3^2 = 0) so we will go on these position and the find the minimum step to make 9 
{
    public static int minimumCountSquareDp(int n)  //dry run till n = 9
    { 
        int storage[] = new int[n+1]; //for n = 8 we have to fill array till 8th index if the storage of array will be 8 then indexes will be 0 to 7 so we don't have 8th index so we have to take n+1 storage i.e 8+1 = 9 storage indexes is 0 to 8 
        storage[0] = 0; //minimum count square to reach 0 is 0 
        storage[1] = 1; //minimum count square to reach 1 is 1^2 
        for(int i = 2;i<=n;i++)
        {
            int min = Integer.MAX_VALUE;
            for(int j = 1;j*j <= i;j++)
            {
                int rem = i - j*j;
                if(storage[rem] < min)
                {
                    min = storage[rem];
                }
            }
               storage[i] = min + 1; //for n = 2 it will go to n = 1 , 1 takes 1 step to reach 1 (i.e 1^2) and 2 also took one step to reach 1(i.e 1^2 + 1^2) so min + 1 

        }
          return storage[n];
    }
    public static void main(String[] args) {
       System.out.println(minimumCountSquareDp(17)); //4*4 = 16 + 1^2 = 2 steps
    }

}
