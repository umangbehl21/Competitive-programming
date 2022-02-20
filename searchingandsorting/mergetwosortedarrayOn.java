package searchingandsorting;

public class mergetwosortedarrayOn {
    public static int[] merge(int arr1[], int arr2[]) {
        int i = 0;
        int j = 0;
        int arr[] = new int[arr1.length + arr2.length];
        int k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                arr[k] = arr1[i];
                i++;
                k++;
            } else {
                arr[k] = arr2[j];
                j++;
                k++;
            }
        }
        while (i < arr1.length) {
            arr[k] = arr1[i];
            k++;
            i++;
        }
        while (j < arr2.length) {
            arr[k] = arr2[j];
            k++;
            j++;
        }
        return arr;
    }

    public static void main(String[] args) {
        int arr1[] = { 2, 6, 9, 15 };
        int arr2[] = { 1, 4, 8, 7 };
        int k[] = merge(arr1, arr2);
        for (int i = 0; i < k.length; i++) {
            System.out.print(k[i] + " ");
        }
    }
}
