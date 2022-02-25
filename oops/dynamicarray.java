package oops;

public class dynamicarray {

    private int data[];
    private int nextindex;

    public dynamicarray()
    {                                                   // constructor 
     data = new int [5];                                
     nextindex=0; 

    }
    public int size()                                   // size return size of the array
    {
        return nextindex;
    }
    public void add(int element)                       // add(add elements to next index)  
    {
    if(nextindex == data.length)
    {
        restructure();
    }
    else
    {
        data[nextindex] = element;
        nextindex++;
    }

    }
    public void set(int index,int element)                  //set set an element in the particular index
    {
    if(index>nextindex)
    {
        throw new IndexOutOfBoundsException();
    }
    if(index<nextindex)
    {
        data[index] = element;

    }
    else
    {
    add(element);
    }

}
    public int get(int index)                         //get th element on an index
    {
        if(index >= nextindex)
        {
            throw new IndexOutOfBoundsException("trying to get the element out of bounds");
        }
        return data[index];
    }
    public boolean isEmpty()                          // check whether the array is empty
    {
        if(size()==0)
        {
            return true;
        }
        else 
        {
           return false;
        }
    }
    public int removelast()                          // remove lastnumber from the array transfer it in to value and return it and bring the nextindex on that position
    {
    if(size()==0)
    {
        throw new Error("no elements left to remove");
    }
    int value = data[nextindex-1];    //retaining the last value 
    data[nextindex - 1] = 0;   //setting the last index as 0
    nextindex--;  //further decreasing nextindex which have some element to remove 
    return value; //returning the value of the last index 
    }
    private void restructure()      
    {
    int temp[] = data;               //storing a new reference of our current data array in temp 
    data = new int[data.length*2];   //doubling the length of the array and pointing it instead of old array
    for(int i=0;i<temp.length;i++)   //copying the elements of old array into new array
    {
     data[i]=temp[i];

    }
}
}
class dyanmicarrayuse
{
    public static void main(String[] args)
    {  
    dynamicarray d = new dynamicarray();

    for(int i=0;i<100;i++)
    {
        d.add(i+10);
    }
    System.out.println(d.size());
    d.set(4,10);
    System.out.println(d.get(3));
    System.out.println(d.get(4));

    while(!d.isEmpty())
    {
    System.out.println(d.removelast());
    System.out.println("size = "+d.size());
    }

    }
}
