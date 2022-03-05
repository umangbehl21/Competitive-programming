package recursion;

public class removexrecursive {
    public static String removex(String s)
    {
      if(s.length() == 0)
      {
          return s;
      }
      if(s.charAt(0) == 'x')
      {
         String smalloutput = removex(s.substring(1));
         return smalloutput;
      }
      String smalloutput = removex(s.substring(1));
      return s.charAt(0) + smalloutput;

    }
    public static void main(String[] args) {
        System.out.println(removex("xaxb"));
        System.out.println(removex("ax"));
        System.out.println(removex("aabc"));
        System.out.println(removex("xx"));
    }
}
