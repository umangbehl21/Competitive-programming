package Arrays;

import java.util.Scanner;

public class RowWiseSum {
    public static int[] rowwisesum(int arr[][], int rows, int cols) {
        int sum = 0;
        int res[] = new int[rows];
        int r = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum += arr[i][j];
            }
            res[r] = sum;
            r++;
            sum = 0;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the rows");
        int rows = sc.nextInt();
        System.out.println("enter the cols");
        int cols = sc.nextInt();
        int a[][] = new int[rows][cols];
        System.out.println("enter elements of matrix");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        System.out.println("print matrix");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
        int res[] = new int[rows];
        res = rowwisesum(a, rows, cols);
        for (int i : res) {
            System.out.print(i + " ");                               
        }

    }

}
