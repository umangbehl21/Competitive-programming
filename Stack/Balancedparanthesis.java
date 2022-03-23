package Stack;
import java.util.Stack;
public class Balancedparanthesis {
    public static boolean isbal(Stack<Character> st,String str)
    { 
       for(int i = 0;i<str.length();i++)
       {
          if(str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[') //pushing the opening brackets in the stack
          {
              st.push(str.charAt(i));
          }
          else if(str.charAt(i) == ')')  //when closing brackets arise we will check the conditions that it is not the extra closing or whether the closing one and opening on the peek are the counter of each other if not return false and in the last if closing and opening are counter of each other pop the opening bracket
          {
             boolean smallans = conditionchecker(st,'(');
             if(smallans == false ) //if any smallans is false means there is bracket mismatch return false 
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
       if(st.size() == 0)  //if there are not extra opening bracket then size must be 0 so return true
       {
           return true;
       }
       else  //else if there are extra opening bracket return false 
       {
           return false;
       }

    }
    public static boolean conditionchecker(Stack<Character> st,char chcorrect)
    {
        if(st.size() == 0)  //closing brackets are more and there is nothing left in stack to check so return false 
        {
            return false;
        }
        else if(chcorrect != st.peek())  //if appropriate counter part is not there on the peek return false 
        {
            return false;
        } 
        else  //else if approproiate part is there then pop it from stack and return true
        {
            st.pop();
            return true;
        }
    }
    public static void main(String[] args) {
        Stack<Character> st = new Stack<>();
        String str = "[(a+b)+{(c+d)+(e/f)}]";
        String s = "((a+b)"; //extra opening 
        String stg = "{}}";//extra closing 
        System.out.println(isbal(st,str));
        System.out.println(isbal(st, s));
        System.out.println(isbal(st, stg));
    }
}
