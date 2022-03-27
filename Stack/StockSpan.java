package Stack;
import java.util.Stack;
public class StockSpan {
    
public static int[] highestspan(int rate[])
{
    int span[] = new int[rate.length];
    span[0] = 1; //if we are on the first index it will be the current highest span where stock price is high till now so setting 1 at 0 index 
    Stack<Integer> st = new Stack<>();
    st.push(0);  //pushing the 0th index in stack 
   for(int i = 1;i<rate.length;i++)  //iterating over the rate array (i is our currentindex)
   {
     while(st.size() > 0 && rate[i] > rate[st.peek()])  //until the stack is empty we have to pop that element which are on peek of stack and are smaller from our current ith index element 
     {
        st.pop();
     }
     if(st.size() == 0)  //if all the elements in the stack are removed means our ith index element is the highest rate till now so currentindex + 1 will be set 
     {
         span[i] = i + 1;
     }
     else 
     {
         span[i] = i - st.peek(); //if current rate or element is smaller then we have to tell when was the last highest rate found from that current index so current index - peek element becuase element at peek is greater 
     }
     st.push(i);  //then push the current element 
   } 
   return span; 
} 
public static void main(String[] args) {
    int rate[] = {60,70,80,100,90,75,80,120}; 
    int span[] = highestspan(rate);
    for(int i = 0;i<span.length;i++)
    {
        System.out.println(span[i]);
    }
}


}
