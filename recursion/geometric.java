package recursion;

public class geometric {
    public static double gp(int n)
    {
        if (n == 0) {
            return 1;
        }
     
        return gp(n - 1) + 1/Math.pow(2,n); 
    }
    public static void main(String[] args) {
        System.out.println(gp(4));
    }
}
