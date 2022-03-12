package recursion;

public class PrintKeypad {
    static String[] codes = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx"};
    public static void print(String str,String ans) //"78"
    {
          if(str.length() == 0)
          {
              System.out.println(ans);
              return;
          }
         char cur = str.charAt(0); //7
         String ncall = str.substring(1);//8
         String codevalue = codes[cur - '0']; //"tu"
         for(int i = 0;i<codevalue.length();i++)
         {
            char option = codevalue.charAt(i); //'t'
            print(ncall, ans + option); //""+'t'
         }
    
    }
    public static void main(String[] args) {
        print("78", "");
    }
}
