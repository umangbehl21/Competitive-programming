package recursion;
import java.util.Scanner;
public class TowerOfHanoi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter tower 1");  //source tower a
        char a = sc.nextLine().charAt(0);
        System.out.println("enter tower 2");  //destination tower b
        char b = sc.nextLine().charAt(0);
        System.out.println("enter tower 3");  //helper tower c
        char c = sc.nextLine().charAt(0);
        toh(3, a, b, c);
    }
    public static void toh(int n,char a,char b,char c) //abc
    {
       if(n == 0)
       {
           return;
       }
       toh(n-1, a, c, b);
       System.out.println(n+"th disk :"+a+"->"+b);
       toh(n-1, c, b, a);
    }
}
