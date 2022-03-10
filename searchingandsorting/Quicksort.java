package searchingandsorting;

public class Quicksort {
    public static int partition(int arr[],int si,int ei)  //[artition logic to find pivot first ]
    {
       int pivot = arr[si];
       int i = si;
       int j = ei;
       while(i < j)
       {
        while(arr[i] <= pivot && i < ei)
        {
            i++;
        }
        while(arr[j] > pivot && j >= si)
        {
            j--;
        }
        if(i < j)
        {
            swap(arr,i,j);
        }
       }
       swap(arr, j, si);
       return j;
    }
    public static void quicksort(int arr[],int si,int ei)
    {
        if(si < ei) //atleast two element should there to sort 
        {
          int pivot = partition(arr, si, ei);
          quicksort(arr, si, pivot-1);
          quicksort(arr, pivot+1, ei);
        }
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int arr[] = {4,1,3,9,7};
        quicksort(arr, 0 , arr.length-1);
        for(int i = 0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
    
}
