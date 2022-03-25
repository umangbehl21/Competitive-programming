package Queues;

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

public class QueueUsingLL<T> {
   private Node<T> front;
   private Node<T> rear;
   private int size;
   public QueueUsingLL()
   {
       front = null;
       rear = null;
       size = 0;
   }
   public int size()
   {
       return size;
   }
   public void enqueue(T element)
   {
       if(size == 0)
       {
           Node<T> newnode = new Node<T>(element);
           rear = newnode;
           front = newnode;
           size++;
       }
       else 
       { 
         Node<T> newnode = new Node<T>(element);
         rear.next = newnode;
         rear = rear.next;
         size++;
        }
    
   }
   public boolean isEmpty()
   {
       if(size == 0)
       {
           return true;
       }
       else{
           return false;
       }
   }
   public T front() throws Exception
   {
    if(size == 0)
    {
        throw new Exception("queue is empty");
    }
      return front.data;
   }
   public T dequeue() throws Exception
   {
       if(size == 0)
       {
           throw new Exception("queue is empty");
       }
       Node<T> temp = front;
       front = front.next;
       if(size() == 1)
       {
           rear = null;
       }
       size--;
       return temp.data;
   }
   
}
class queueuse
{
    public static void main(String[] args) throws Exception {
        QueueUsingLL<Integer> q1 = new QueueUsingLL<>();
        for(int i = 0;i<10;i++)
        {
            q1.enqueue(i);
        }
        System.out.println("size "+q1.size());
        while(!q1.isEmpty())
        {
            System.out.println(q1.dequeue()); 
        }
        System.out.println(q1.isEmpty());
    }
}