package Queues;

public class QueueArray {  //dry run on array size is 3 indices are 0,1,2
   private int front;
   private int rear;
   private int data[];
   private int size;
   public QueueArray(int capacity)
   {
       data = new int[capacity];
      front = -1;
      rear =  -1;
      size = 0;
   }
   public int size()
   {
       return size;
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
   public void enqueue(int element) throws Exception
   {
      if(size == data.length)
      {
         throw new Exception("queue full exception");
      }
      if(size() == 0)
      {
          front = 0;
      }        //for 0,1,2 indices
      rear++; //after enqueue on all the 0th 1th and 2th position our rear is on 2 and front is on 0 and now if we dequeue one element from index 0 and we want to enqueue some other element at that position then by incrementing rear it will become 3 so when it becomes equal to array.length reset rear again to 0 so that we can set on 0 index
      if(rear == data.length)
      {
          rear = 0;
      }
      data[rear] = element;
      size++; 
   }
   public int dequeue() throws Exception
   {
       if(size() == 0)
       {
           throw new Exception();
       }
       int temp = data[front];
       front++;
       if(front == data.length) //if after dequeue all the elements on 0th 1th and 2th position our front will be on 3rd index and if we enqueue element on 0th position and then we want to dequeue from 0th position our front must be on 0 th index so here arise condition that as soon as the front become equal to data.length reset it to 0
       {
           front = 0;
       }
       size--;          //for 0,1,2 indices
       if(size() == 0) //after dequeue of all elements our rear will be on 2nd index and front will be on 3rd so if we want to enqueue again we have to start from begining so reset front and rear to -1
       {
          front = -1;
          rear = -1;
       }
       return temp;

   }
  int front() throws Exception
  {
      if(size == 0)
      {
          throw new Exception("queue is empty");
      }
      return data[front];
  }

}
class QueueUsingArray
{
    public static void main(String[] args) throws Exception {
        QueueArray q1 = new QueueArray(10); //0 1 2 positions 
        for(int i = 0;i<3;i++)
        {
            q1.enqueue(i);
        }
        System.out.println("dequeuing first element "+q1.dequeue());
        q1.enqueue(5); //again enqueuing another element in the place of that element removed from 0th index 
     while(!q1.isEmpty()) //now our front is on first index because we have dequeued first element also so the number 5 we have enqueued will come out at last because front will be only reset to 0 when it will remove the element from 1th index to 2nd index and on reaching the 3rd index it will reset to 0th index then it will delete number 5
     {
        System.out.println(q1.dequeue());
     }
    }
    // for(int i =0;i<10;i++)
    // {
    //     q1.enqueue(i);
    // }
    // while(!q1.isEmpty())
    // {
    //     System.out.println(q1.dequeue());
    // }
}
}
