package Strings;
import java.util.Scanner;
public class ispalindrome {
   public static Boolean isPalindrome(String S) {
        int i = 0;
        int j = S.length()-1;
        while(i<j)
        {
            if(S.charAt(i) != S.charAt(j))
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
     }
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         System.out.println("enter a String");
         String s = sc.nextLine();
         System.out.println(isPalindrome(s));

        }
}
