package recursion;

public class checkopalindromeString {
    public static boolean palindrome(String s,int start,int end)
    {
        if(start == end)
        {
           return true;
        }
        if(start > end)
        {
            return true;
        }
        if(s.charAt(start) != s.charAt(end))
        {
            return false;
        }
        return palindrome(s, ++start, --end);
    }
    public static boolean palindrome(String s)
    {
        return palindrome(s, 0, s.length()-1);
    }
    public static void main(String[] args) {
        System.out.println(palindrome("maam"));
    }

}
