package Strings;

public class words {
   public static int countWords(String s) 
    { 
       int out = 0;
       int in  =  1;
       int state = out;
       int i =  0;
       int wc = 0;
       while(i < s.length())
       {
          if(s.charAt(i) == ' ' || s.charAt(i) == '\n' || s.charAt(i) == '\t')
          {
              state = out;
          }
          else if(state == out)
          {
              state = in;
              wc++;
          }
           i++;      
           
       }
       return wc;
    }
    public static void main(String[] args) {
        String s = "@\n \tdef gh";
        System.out.println(countWords(s));
    }
}
