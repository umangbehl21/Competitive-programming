package recursion;

public class fibonaccirecursion {
        public static int fibonacciNumber(int n){
            if(n == 0 || n == 1)
            {
                return n;
            }
            return fibonacciNumber(n-1) + fibonacciNumber(n-2); 
        }
    public static void main(String[] args) {
        int a = fibonacciNumber(5);
        System.out.println(a);
    }
}
