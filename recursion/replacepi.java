package recursion;

public class replacepi {
    private static String pi(String s)
    {
      if(s.length() == 0 || s.length() == 1)
      {
          return s;
      }
      if(s.charAt(0) == 'p' && s.charAt(1) == 'i')
      {
          String smallans = pi(s.substring(2));
          return smallans + "3.14";
      }
      else{
          String smallans = pi(s.substring(1));
          return smallans + s.charAt(0);
      }


    }
    public static void main(String[] args) {
        System.out.println(pi("xpix"));
    }
}
