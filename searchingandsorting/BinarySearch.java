package searchingandsorting;

public class BinarySearch {
    public static int binarysearch(int arr[],int k) {
        int start = 0;
        int end = arr.length - 1;
        int mid = (start + end) / 2;
        if (arr[mid] == k) {
            return mid;
        } else if (k > arr[mid]) {
            int i = mid + 1;
            while (i < arr.length) {
                if (arr[i] == k) {
                    return i;
                }
                i++;
            }

        } else if (k < arr[mid]) {
            int i = 0;
            while (i < mid) {
                if (arr[i] == k) {
                    return i;
                }
                i++;
            }

        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8};
        System.out.println(binarysearch(arr,8));
    }
}
