package recursion;

import java.util.Scanner;

public class XtopowerN {
    public static int power(int x,int n)
    {
        if(n == 1)
        {
            return x;
        }
        return power(x, n-1) * x;
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("enter the number");
            int x = sc.nextInt();
            System.out.println("enter the power");
            int n = sc.nextInt();
            System.out.println(x+" ^ "+n+ " is "+power(x, n));
        }
    }
}

