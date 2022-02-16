package TwoDArrays;

import java.util.*;

public class spiralmatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int minrow = 0;
        int maxrow = matrix.length - 1;
        int mincol = 0;
        int maxcol = matrix[0].length - 1;
        int totalelements = matrix.length * matrix[0].length;
        int count = 0;
        while (count < totalelements) {
            // top line
            for (int i = minrow, j = mincol; j <= maxcol && count < totalelements; j++) {
                list.add(matrix[i][j]);
                count++;
            }
            minrow++;

            // right line
            for (int i = minrow, j = maxcol; i <= maxrow && count < totalelements; i++) {
                list.add(matrix[i][j]);
                count++;
            }
            maxcol--;
            // bottom line
            for (int i = maxrow, j = maxcol; j >= mincol && count < totalelements; j--) {
                list.add(matrix[i][j]);
                count++;
            }
            maxrow--;

            // left line
            for (int i = maxrow, j = mincol; i >= minrow && count < totalelements; i--) {
                list.add(matrix[i][j]);
                count++;
            }
            mincol++;
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the rows");
        int rows = sc.nextInt();
        System.out.println("enter the cols");
        int cols = sc.nextInt();
        int a[][] = new int[rows][cols];
        System.out.println("enter the elements of matrix");
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
        List<Integer> list = spiralOrder(a);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
