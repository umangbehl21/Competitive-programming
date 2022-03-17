package recursion;
public class PrintEncodings {
    public static void printencode(String ques,String asf) //"123"
    {
        if(ques.length() == 0)
        {
            System.out.println(asf);
            return;
        }
        else if(ques.length() == 1)
        {
            char ch = ques.charAt(0); //'1'
            if(ch == '0')
            {
                return;
            }
            else 
            {
                int chv = ch - '0'; //1 
                char rch = (char)('a' + chv - 1); //char(97 + 1 - 1) = 'a' or char(97 + 3 - 1) = 'c' 
                System.out.println(asf + rch);
            } 
        }
        else  //if length is greater than 2 example "123"
        {
            char ch = ques.charAt(0);  //'1'
            String roq = ques.substring(1); //"23"
            if(ch == '0') //if 0 then return 
            {
              return;
            }
            else //for 123 two calls are made one on '1' and other on '12' this one for single character call
            {
                int chv = ch - '0'; //chv = '1' - '0' = 1
                char rch = (char)('a' + chv - 1); //char(97 + 1 - 1) = 'a' or char(97 + 3 - 1) = 'c' 
                printencode(roq , asf + rch); //
            }
             String ch12 = ques.substring(0,2);  //this one is for '12' call 
             String roq12 = ques.substring(2);
             int chn = Integer.parseInt(ch12);
             if(chn <= 26)
             {
                char code = (char)('a' + chn - 1); 
                printencode(roq12, asf + code);
             }
        
        }
    }
    public static void main(String[] args) {
        printencode("1123","");
    }
}
