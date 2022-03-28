package Stack;
import java.util.Stack;
public class MinimumAddToMakeValid {
    public static int minAddToMakeValid(String s) {
        
        Stack<Character> st = new Stack<>();
           for(int i = 0;i<s.length();i++)
            {
                char c = s.charAt(i);
                if(st.size() != 0 && c == ')' && st.peek() == '(')  //if size of stack is not zero and our current character is closing round bracket and our peek element in stack is opening round bracket then we can pop that opening bracket because we got a valid pair
                {
                        st.pop();   
                }
               else
               {
                   st.push(c);  //else if we got opening bracket simply push it or if stack is empty or peek of stack is closing bracket and we got closing bracket again push it also because we can't form the valid pair 
               }
                
            }
        return st.size();  //so the number of adder to make them valid is the number of brackets which are invalid in the stack and didnt found their pair
        
    }
    public static void main(String[] args) {
        System.out.println("to make them valid this much braces will be required");
        System.out.println(minAddToMakeValid(")))"));  
        System.out.println(minAddToMakeValid("(()))("));
        System.out.println(minAddToMakeValid("(()"));
        System.out.println(minAddToMakeValid("()))(("));
    }
}
