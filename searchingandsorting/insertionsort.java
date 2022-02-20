package searchingandsorting;

public class insertionsort {
    public static void sort(int arr[])
    {
        for(int i = 0;i<arr.length;i++)               //INSERTION SORT for dry run use 8,4,1,5,9,2 or 9,8,5,6,2,1
        {                                            //in insertion sort array is divided into two parts sorted and unsorted
                                                    //pick an ith element from unsorted store it in temp 
            int j = i-1;                            //check if element on jth position is greater than the temp if greater then shift it by j+1 or one position further then further decrement the j though the entire sorted region to find the right place of the temp
            int temp = arr[i];                      //int the end insert temp at j+1 position 
            while(j >= 0 && arr[j] > temp)
            {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
    }
    public static void main(String[] args) {
        int arr[] = {9,8,5,6,2,1};
        sort(arr);
        for(int i = 0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
    } 
}
