package Stack;
public class Stack {
   private int data[];
   private int top;
    public Stack(int capacity)
    {
       data = new int[capacity];
       top = -1;  //when initially object is created there are no element in stack until we push some so top should be -1
    }
    public int size()
    {
        return top + 1;  //when there are no element in stack or in our array then our size is 0 but initially our top is on -1 so we have to return top + 1
    }
    public boolean isEmpty()
    {
        if(top == -1)
        {
            return true;  //when our stack has no element our top is always on -1 so if it is -1 return true 
        }
        else
        {
           return false;
        }
    }
    public void push(int element) throws StackFullException
    {
        if(size() == data.length)  //if our array length is 5 and elements in it is 4 now before entering on the index 5 which do not exist we should check that if next index is 5 then stack is full 
        {
            throw new StackFullException("stack is full");
        }
        top++; //if we want to push at index 0 initially our top is on -1 we have to increment it first
        data[top] = element; //then on data[0] we can put
    }
    public int pop() throws StackEmptyException
    {
        if(isEmpty()) // or if(size() == 0)  //when top is on -1 means array is empty then there is nothing present on top
        {
            throw new StackEmptyException("no element left to remove");
        }
        int temp = data[top]; //first we have to retain that element so that we can display user that this element is removed 
        top--; //after retaining we can reduce the top and now no one is pointing to that element 
        return temp;
    }
    public int top() throws StackEmptyException
    {
        if(isEmpty()) // or if(size() == 0)  //when top is on -1 means array is empty then there is nothing present on top
        {
            throw new StackEmptyException("no element left to remove");
        }
        return data[top];     
    }
}


class stackuse
{
    public static void main(String[] args) throws StackEmptyException, StackFullException {
        Stack st1 = new Stack(5);
        for(int i = 0;i<5;i++)
        {
            st1.push(i);
        }
        System.out.println("element on top is "+ st1.top());
        while(!st1.isEmpty())
        {
            System.out.println(st1.pop());
        }
        
    }
}


class StackEmptyException extends Exception
{
     public StackEmptyException(String s)
     {

     }
}


class StackFullException extends Exception
{
    public StackFullException(String s)
    {
        
    }
}
