package recursion;

import java.util.ArrayList;

public class ReturnEncodings {
    private static void returnencodingdoer(String ques,String asf,ArrayList<String> ans) //"123"
    {
       if(ques.length() == 0)               //DETAILED EXPLANATION IN PrintEncoding ques
       {
           ans.add(asf);
           return;
       }
       if(ques.length() == 1) 
       {
          char ch = ques.charAt(0);
          if(ch == '0')
          {
              return;
          }
          int chv = ch - '0'; //1
          char code = (char)('a' + chv - 1);
          asf = asf + code;
          returnencodingdoer(ques.substring(1), asf, ans);
       }
       else
       {
          char ch = ques.charAt(0); //'1'
          if(ch == '0')
          {
              return;
          }
          else {    
              String roq = ques.substring(1);
              int chv = ch - '0';
              char code = (char)('a' + chv - 1);
              returnencodingdoer(roq, asf + code, ans);
            }
            String ch12 = ques.substring(0,2);
            String roq12 = ques.substring(2);
            int numv = Integer.parseInt(ch12);
            char code12 = (char)('a' + numv - 1);
            returnencodingdoer(roq12, asf + code12, ans);

       }
        
    }
    public static ArrayList<String> returnencodings(String ques)
    {
        ArrayList<String> ans = new ArrayList<>();
        returnencodingdoer(ques, "" , ans);
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(returnencodings("123"));
    }
}
