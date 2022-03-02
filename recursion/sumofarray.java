package recursion;

public class sumofarray {
    public static int sum(int arr[], int n) {
        if (n <= 0) {
            return 0;
        }
        return sum(arr, n - 1) + arr[n - 1];
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
        System.out.println(sum(arr, arr.length));
    }
}
