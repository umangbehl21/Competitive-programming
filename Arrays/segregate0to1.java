package Arrays;

public class segregate0to1 {
    public static void segregate0and1(int[] arr) {
        int i = 0;
        int j = 0;
        while (i < arr.length) {

            if (arr[i] == 1) // j to i-1 region of 1
            {
                i++;
            } else // 0 to j-1 region of 0
            {
                swap(arr, i, j);
                i++;
                j++;
            }
        }
    }

    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    public static void main(String[] args) {
        int arr[] = { 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 1 };
        segregate0and1(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
