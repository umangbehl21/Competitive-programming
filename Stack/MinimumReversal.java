package Stack;
import java.util.Stack;
public class MinimumReversal {
    public static int countRev (String s)
    {
        if(s.length() % 2 != 0)
        {
            return -1;  
        }
        Stack<Character> s1 = new Stack<>();  
        int worktodo = 0;
        for(int i = 0;i<s.length();i++)
        {
           char c = s.charAt(i);  
           if(c == '}')  
           {
               if(s1.size() == 0)   //if stack is empty means we have got closing brace in the start of string so we have to increase our work count and push it as opening bracket in stack because closing brace in the start of question cannot make pair until it is reversed 
               {
                   worktodo++;
                   s1.push('{');
               }
               else 
               {
                   s1.pop();  //else if stack is not empty means there are opening bracket in it so we can pop them on finding closing brace so rhere will be valid pair
               }
           }
           else 
           {
               s1.push(c);  //if character is { bracket then push it in stack 
           }
            
        }
        if(!s1.isEmpty())  //if stack is not empty total reversal will be worktodo + half of stack size 
        {
            worktodo += s1.size()/2;   
        }
      return worktodo;  //now these are the total reversal we will return 
    }
    public static void main(String[] args) {
        String s = "}{{}}{{{";
        String s1 = "}}}}";
        System.out.println(countRev(s));
        System.out.println(countRev(s1));
    }
}
