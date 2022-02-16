package TwoDArrays;

import java.util.Scanner;

public class printlikeawave {
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
        for (int i = 0; i < cols; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < rows; j++) {
                    System.out.println(a[j][i]);
                }
            } else {
                for (int j = rows - 1; j >= 0; j--) {
                    System.out.println(a[j][i]);
                }
            }
        }
    }
}
