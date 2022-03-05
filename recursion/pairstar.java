package recursion;

public class pairstar {
    public static String pair(String s)
    {
        if(s.length() == 0 || s.length() == 1)
        {
            return s;
        }
        if(s.charAt(0) == s.charAt(1))
        {
            String smalloutput = pair(s.substring(1));
            return s.charAt(0)+ "*" + smalloutput;
        }
        String smalloutput = pair(s.substring(1));
           return s.charAt(0) + smalloutput;

    }
    public static void main(String[] args) {
        System.out.println(pair("aaaa"));
        System.out.println(pair("xllmp"));
        System.out.println(pair("ll"));
    }



}
