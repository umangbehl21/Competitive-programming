package searchingandsorting;

public class Selectionsort {
    public static void selectionSort(int arr[]) {              //SELECTION SORT
        for (int i = 0; i < arr.length - 1; i++) {            //finding the minimum element from the i+1 < arr.length initially minimum element is considered to be on ith index
            int minindex = i;                                 //swapping it with ith position 
            for (int j = i + 1; j < arr.length; j++) {             
                if (arr[j] < arr[minindex]) {
                    minindex = j;
                }
            }
            swap(arr, i, minindex);
        }
    }

    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int arr[] = { 6, 5, 4, 3, 2, 1 };
        selectionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
    }
}
