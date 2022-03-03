package recursion;

public class lastindexofx {
    private static int lastoccurence(int input[],int n,int elem)
    { 
        if(n == 1 && input[n-1] != elem)
        {
            return -1;
        }
        if(input[n-1] == elem)
        {
            return n-1;
        }
        return lastoccurence(input, n-1, elem);
    }
    public static int lastoccurence(int input[],int elem)
    {
        return lastoccurence(input,input.length,elem);
    } 
    public static void main(String[] args) {
        int input[] = {9,8,9,10,8};
        System.out.print(lastoccurence(input, 9));
    }
} 
