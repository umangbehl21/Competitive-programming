package Stack;
import java.util.Stack;
public class Balancedparanthesis {
    public static boolean isbal(Stack<Character> st,String str)
    {
       for(int i = 0;i<str.length();i++)
       {
          str.charAt(i);
          if(str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[')
          {
              st.push(str.charAt(i));
          }
          else if(str.charAt(i) == ')')
          {
             boolean smallans = conditionchecker(st,'(');
             if(smallans == false )
             {
                 return false;
             }
          }
          else if(str.charAt(i) == '}')
          {
              boolean smallans = conditionchecker(st, '{');
              if(smallans == false )
              {
                  return false;
              }
          }
          else if(str.charAt(i) == ']')
          {
            boolean smallans = conditionchecker(st, '[');
            if(smallans == false )
            {
                return false;
            }
          }
       }
       if(st.size() == 0)
       {
           return true;
       }
       else 
       {
           return false;
       }

    }
    public static boolean conditionchecker(Stack<Character> st,char chcorrect)
    {
        if(st.size() == 0)
        {
            return false;
        }
        if(chcorrect != st.peek())
        {
            return false;
        } 
        else
        {
            st.pop();
            return true;
        }
    }
    public static void main(String[] args) {
        Stack<Character> st = new Stack<>();
        String str = "[(a+b)+{(c+d)+(e/f)}]";
        System.out.println(isbal(st,str));
    }
}
