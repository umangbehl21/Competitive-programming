package recursion;

public class numberofdigits {
    public static int count(int n)
    {
        if(n < 10) //if n become a single digit we return 1 
        {
            return 1;
        }
        return count(n/10) + 1;

    }
    public static void main(String[] args) {
        int ans = count(1006967540);
        System.out.println(ans);
    }
}
