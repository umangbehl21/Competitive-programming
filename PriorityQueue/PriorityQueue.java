package PriorityQueue;
import java.util.*;
public class PriorityQueue {
    int size;
    ArrayList<Integer> heap;
    public PriorityQueue()
    {
       heap = new ArrayList<>();
    }
    public boolean IsEmpty()
    {
        return size == 0;
    }
    public int getMin() throws Exception 
    {
        if(IsEmpty())
        {
            throw new Exception("priority queue empty exception");
        }
        return heap.get(0);
    }
    public void insert(int elem)
    {
        size++;
        heap.add(elem);
        int childIndex = heap.size()-1;
        int parentIndex = (childIndex - 1)/2;
        while(childIndex > 0)
        {
        if(heap.get(childIndex) < heap.get(parentIndex))
        {
            int temp = heap.get(childIndex);
            heap.set(childIndex, heap.get(parentIndex));
            heap.set(parentIndex, temp);
            childIndex = parentIndex;    //now childindex will be that which was parent previously childindex was 6 previously now it will be 2 next time it will be 0
            parentIndex = (childIndex - 1)/2; //calculate new parent index 
        }
        else
        {
            return;
        }
    }
  }
  public int removeMin() throws Exception
  {
    if(IsEmpty()) 
    {
        throw new Exception("priority queue is empty");
    }
    size--;
    int temp1 = heap.get(0); 
    heap.set(0, heap.get(heap.size() -1));
    heap.remove(heap.size()-1);
    int leftchildIndex = 1; //2*i+1 i is parent index which is 0 at begining
    int rightchildIndex = 2; //2*i+2 i is parent index which is 0 at begining
    int index = 0;
    int minindex = index;
    while(leftchildIndex < heap.size())
    {
    if(heap.get(leftchildIndex) < heap.get(minindex))
    {  
       minindex = leftchildIndex;
    }
    if(rightchildIndex < heap.size() && heap.get(rightchildIndex) < heap.get(minindex))  //sometimes the parent don't have the right child so we will try to get element from the index which do not exist so we will check that index is less than heap size or it is in the range we are not doing it for left child because loop is covering that condition 
    {
        minindex = rightchildIndex;
    }
    if(minindex == index) //when the leftchild  and right child is greater than parent then the minindex will not get updated and donnot move further downwards so the moment minindex and index become equal we don't want any further swapping we will break 
    {
        break;
    }
    else
    {
        int temp = heap.get(index);
        heap.set(index, heap.get(minindex));
        heap.set(minindex, temp);
        index = minindex; //we have to update index to minindex because on next iteration minindex will move further downwards towards the left or right child and the index should keep the track on the parent because minindex has move to the child   
        leftchildIndex = 2 * minindex + 1;
        rightchildIndex = 2 * minindex + 2;
    }
    
  } 
  return temp1;
}
}
class PriorityQueueTest
{
    public static void main(String[] args) throws Exception {
    PriorityQueue pq = new PriorityQueue();
    int arr[] = {5,1,9,2,0};
    for(int i : arr)
    {
        pq.insert(i);
    }
    while(!pq.IsEmpty())
    {
        System.out.print(pq.removeMin()+" ");
    }
  }
}