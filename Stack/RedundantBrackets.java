package Stack;

import java.util.Stack;

public class RedundantBrackets {
    public static boolean duplicatebraces(String s) {
        Stack<Character> s1 = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') { //if closing backet occur we have to check two things that what is on the peek of stack  if peek is '(' an opening bracket then return true because there is no content between the opening and closing means they are redundant or duplicate  
                if (s1.peek() == '(') {
                    return true;
                } else {
                    while(s1.peek() != '(') {  //else if peek is not opening bracket then pop until the opening backet occur then pop opening bracket also 
                        s1.pop();
                    }
                    s1.pop();
                }
            } else {  //if character is not closing bracket push them in the stack until the closing bracket arises 
                s1.push(c);  
            }
        }
        return false; //if string is finished and we have reached the end return false means there are no redundant bracket 
    }

    public static void main(String[] args) {
        String s = "((a+b) + ((c+d))"; //true there is redundancy 
        System.out.println(duplicatebraces(s));
        String s1 = "(a+b)"; // false no redundancy 
        System.out.println(duplicatebraces(s1));
        String s2 = "((a+b)+(c+d))"; //false no redundancy 
        System.out.println(duplicatebraces(s2));
        
    }
}
