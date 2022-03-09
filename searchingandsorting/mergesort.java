package searchingandsorting;

public class mergesort {
    public static void merge(int arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }
        int mid = (si + ei) / 2;
        merge(arr, si, mid);
        merge(arr, mid + 1, ei);
        mergetwo(arr, si, ei);
    }

    private static void mergetwo(int[] arr, int si, int ei) {
        int mid = (si + ei) / 2;
        int i = si;
        int j = mid + 1;
        int k = 0;
        int ans[] = new int[ei - si + 1];
        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                ans[k] = arr[i];
                i++;
                k++;
            } else {
                ans[k] = arr[j];
                j++;
                k++;
            }

        }
        while (i <= mid) {
            ans[k] = arr[i];
            i++;
            k++;
        }
        while (j <= ei) {
            ans[k] = arr[j];
            k++;
            j++;
        }
        for (int index = 0; index < ans.length; index++) {
            arr[si + index] = ans[index];
        }

    }

    public static void main(String[] args) {
        int arr[] = { 8, 1, 4, 3, 9, 2, 7 };
        merge(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
