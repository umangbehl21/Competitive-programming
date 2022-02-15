package TwoDArrays;

import java.util.Scanner;

public class greatestofrowandcolumn {

    public static int[] maxrowsum(int arr[][], int rows, int cols) {
        int maxrow = Integer.MIN_VALUE;
        int sum = 0;
        int resultantrow = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum += arr[i][j];
            }
            if (sum > maxrow) {
                maxrow = sum;
                resultantrow = i;
            }
            sum = 0;
        }
        int res[] = { resultantrow, maxrow };
        return res;
    }

    public static int[] maxcolumnsum(int arr[][], int rows, int cols) {
        int maxcol = Integer.MIN_VALUE;
        int sum = 0;
        int resultantcolumn = 0;
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                sum += arr[j][i];
            }
            if (sum > maxcol) {
                maxcol = sum;
                resultantcolumn = i;
            }
            sum = 0;
        }
        int res[] = { resultantcolumn, maxcol };
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
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        int maxrow[] = maxrowsum(a, rows, cols);
        int maxcol[] = maxcolumnsum(a, rows, cols);
        if (maxrow[1] >= maxcol[1]) {
            System.out.println("row " + maxrow[0] + " " + maxrow[1]);
        } else {
            System.out.println("column " + maxcol[0] + " " + maxcol[1]);
        }
    }
}
