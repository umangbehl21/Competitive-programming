package Arrays;

public class PushZerostoEnd {
    public static void pushZerosAtEnd(int[] arr) {
        int j = 0;
        int i = 0;
        while (i < arr.length) {
            if (arr[i] == 0) {
                i++;
            } else if (arr[i] < 0 || arr[i] > 0) {
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
        int arr[] = { -1, 0, 1, 2, 3, 0 };
        pushZerosAtEnd(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
