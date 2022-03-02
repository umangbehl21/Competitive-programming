package recursion;

public class sumofarray {
    public static int sum(int arr[]) {
        if (arr.length <= 1) {
            return arr[0];
        }
        int smallarr[] = new int[arr.length - 1];
        for (int i = 1; i < arr.length; i++) {
            smallarr[i - 1] = arr[i];
        }
        return sum(smallarr) + arr[0];
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7};
        System.out.println(sum(arr));
    }
}
