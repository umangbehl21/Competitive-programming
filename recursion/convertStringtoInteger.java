package recursion;

public class convertStringtoInteger {
    private static int convert(String s,int index)
    {
       if(index == 0)
       {
           return s.charAt(index) - '0'; //to convert character into integer 
       }
       int smallans = convert(s,index-1); 
       int num = s.charAt(index) - '0'; //to convert character into integer 
        return smallans * 10 + num;
    }
    public static int convert(String s)
    {
        return convert(s,s.length()-1); 
    }
    public static void main(String[] args) {
        System.out.println(convert("12345"));
        System.out.println(convert("12"));
        System.out.println(convert("13"));

    }
}
