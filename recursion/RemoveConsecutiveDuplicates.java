package recursion;

public class RemoveConsecutiveDuplicates {
    public static String removedup(String str)
    {
        if(str.length() == 1)
        {
            return str;
        }
        if(str.charAt(0) != str.charAt(1))
        {
            return str.charAt(0) + removedup(str.substring(1));
        }
       return removedup(str.substring(1));
    }
    public static void main(String[] args) {
        System.out.println(removedup("xxxyyyzwwzzz"));
    }
}
