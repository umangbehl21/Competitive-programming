package Arrays;

import java.util.Scanner;

public class Swapalternate {
    public static int[] swapposition(int arr[]) {
        int i = 1;
        while (i < arr.length) {
            swap(arr, i - 1, i);
            i += 2;
        }
        return arr;
    }

    public static void swap(int arr[], int j, int i) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println("enter the storage of an array");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("enter array elements");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        swapposition(arr);
        for (int i = 0; i < arr.length; i++) { // 9 3 6 12 4 32 5 11 19
            System.out.print(arr[i] + " ");
        }
    }

}
