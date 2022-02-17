package Strings;

public class RemoveConsecutives {
    public static String removeConsecutiveDuplicates(String s) {
        String res = "";
        int len = s.length();
     for(int i = 0;i<s.length();i++)
     {
         if( i<len-1 && s.charAt(i)==s.charAt(i+1))
         {
             continue;
         }
         else
         {
             res += s.charAt(i);
         }
     }
        return res;
	}
    public static void main(String[] args) {
        System.out.println(removeConsecutiveDuplicates("aaaaaccb"));
    }
}
