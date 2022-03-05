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
          return "3.14" + smallans;
      }
      else{
          String smallans = pi(s.substring(1));
          return s.charAt(0) + smallans;
      }


    }
    public static void main(String[] args) {
        System.out.println(pi("pipi"));
    }
}
