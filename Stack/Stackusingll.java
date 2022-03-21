package Stack;
class Node<T>
{ 
    T data;
    Node<T> next;
    public Node(T data)
    { 
        this.data = data;
        next = null;
    }

}
public class Stackusingll<T> {
    private Node<T> head;
    private int size;
    public Stackusingll()
    {
        head = null;
        size = 0;
    }
    public boolean isEmpty()
    {
        if(size() == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public int size()
    {
        return size;
    }
    public void push(T element)
    {
        if(size() == 0)
        {
            Node<T> newnode = new Node<>(element);
            head = newnode;
            size++;
            return;
        }
        Node<T> newnode = new Node<>(element);
        newnode.next = head;
        head = newnode;
        size++;

    }
    public T pop() throws Exception
    {
        if(size() == 0)
        {
           throw new Exception("No elements left to remove stack is empty");
        }
        Node<T> temp = head;
        head = head.next;
        size--; 
        return temp.data;
    }
    public T top() throws Exception
    {
        if(size == 0)
        {
           throw new Exception("No element is present on top because stack is empty");
        }
        return head.data;
    }
}
class stackuse1 
{
    public static void main(String[] args) throws Exception {
        Stackusingll<Integer> s1 = new Stackusingll<Integer>();
        for(int i = 1;i<=20;i++)
        {
           s1.push(i);
        }
        System.out.println("on top "+s1.top());
        System.out.println("size "+s1.size());
        while(!s1.isEmpty())
        {
            System.out.println(s1.pop());
        }
        System.out.println("size "+s1.size());
    }
}
