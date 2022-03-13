package recursion;
public class StairCaseProblem {
    public static int climbways(int n) {
        if (n == 1 || n == 0) {
            return 1;
        } else if (n == 2) {
            return n;
        } else {
            return climbways(n - 3) + climbways(n - 2) + climbways(n - 1);
        }
    }
        public static void main(String[] args) {
            System.out.println(climbways(3));
        }

}
