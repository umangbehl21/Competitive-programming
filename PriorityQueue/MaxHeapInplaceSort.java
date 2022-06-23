package PriorityQueue;

public class MaxHeapInplaceSort {
    public static void insert(int arr[],int i)
    {
        int childIndex = i;
        int parentIndex = (childIndex - 1)/2;
        while(childIndex > 0)
        {
        if(arr[childIndex] > arr[parentIndex])
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
    public static int removeMax(int arr[],int heapsize)
    {
        int temp = arr[0];
        arr[0] = arr[heapsize - 1];
        heapsize--; //for removing element from the end of array
        int index = 0;
        int maxindex = index;
        int leftchildIndex = 1;
        int rightchildIndex = 2;
        while(leftchildIndex < heapsize)
        {
        if(arr[maxindex] < arr[leftchildIndex])
        {
            maxindex = leftchildIndex;
        }
        if(rightchildIndex < heapsize &&  arr[maxindex] < arr[rightchildIndex])
        {
            maxindex = rightchildIndex;
        }
        if(maxindex == index)
        {
            break;
        }
        else{
        int temp1 = arr[index];
        arr[index] = arr[maxindex];
        arr[maxindex] = temp1;
        index = maxindex;
        leftchildIndex = 2 * maxindex + 1;
        rightchildIndex = 2 * maxindex + 2;
        }
       }
       return temp;
    }

    public static void main(String[] args) {
        int arr[] = {5,8,10,17,16,7,6};
        for(int i = 0 ;i<arr.length;i++)
        {
            insert(arr, i);
        }
        for(int i = 0 ;i<arr.length;i++)
        {
           arr[arr.length - 1 - i] = removeMax(arr, arr.length - i);
        }
        for(int i : arr)
        {
            System.out.println(i);
        }
    }


}
