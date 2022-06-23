package PriorityQueue;

public class MinHeapSortinplace {
    public static void insert(int arr[],int i) //i is the index of the element 
    {                                          //after insertion of elements we get the array in heap form 
         int childIndex = i;
         int parentIndex = (childIndex-1)/2;
         while(childIndex > 0)
         {
         if(arr[childIndex] < arr[parentIndex])
         {
           int temp = arr[parentIndex];
           arr[parentIndex] = arr[childIndex];
           arr[childIndex] = temp;
           childIndex = parentIndex;
           parentIndex = (childIndex - 1)/2;
         }
         else 
         {
            return;
         }
        }
         
    }
    public static int removeMin(int arr[],int heapsize) 
    {
        int temp = arr[0]; //retaining min element from our heap array 
        arr[0] = arr[heapsize - 1]; //placing last element on the 0 th index 
        heapsize--; //removing the last element by reducing the size of heap array 
        int leftchildIndex = 1;
        int rightchildIndex = 2;
        int index = 0;
        int minindex = index;
        while(leftchildIndex < heapsize)
        {
        if(arr[leftchildIndex] < arr[minindex])
        {
            minindex = leftchildIndex;
        }
        if(rightchildIndex < heapsize && arr[rightchildIndex] < arr[minindex])
        {
            minindex = rightchildIndex;
        }
        if(minindex == index)
        {
            break;
        }
        else 
        {
        int temp1 = arr[index];
        arr[index] = arr[minindex]; 
        arr[minindex] = temp1;
        index = minindex;
        leftchildIndex = 2 * minindex + 1;
        rightchildIndex = 2 * minindex + 2;
        }
       }
       return temp;
    }
    public static void main(String[] args) {
        int arr[] = {5,1,9,2,0,6};
        for(int i = 0;i<arr.length;i++)
        {
           insert(arr, i);
        }
        for(int i = 0;i<arr.length;i++)
        {
            arr[arr.length - 1 - i] = removeMin(arr,arr.length - i); //we have to decreement heap size as we are inserting from behind if we will not reduce heap size the leftchildindex < heapsize condition in while will run and the sorted element in the end of the array will be considered as the child of some elements but they are not their child
        }
        for(int i : arr)
        {
            System.out.println(i);
        }
    }
}

