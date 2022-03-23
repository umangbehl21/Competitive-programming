package Stack;
import java.util.Stack;
public class ReverseStack {
    public static void ReverseStack1(Stack<Integer> st) //dry run on simple two or three numbers in stack to reverse
    {
        if(st.isEmpty())
        {
            return;
        }
        int temp = st.peek(); //saving the top element
        st.pop();
        ReverseStack1(st); //calling recurse on the remaining stack    
        PutAtLast(st,temp); 
    }

    public static void PutAtLast(Stack<Integer> st, int k) {
       if(st.isEmpty())
       {
           st.push(k);
           return;
       }

        int temp = st.peek();
        st.pop();
        PutAtLast(st, k);
         st.push(temp);
    }
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        for(int i = 1;i<=5;i++)  //5 4 3 2 1 is before reverse
        {
            st.push(i);
        }
        ReverseStack1(st);
        System.out.println("after reverse");
        while(!st.isEmpty())
        {
            System.out.println(st.pop());
        }
    }
}

    