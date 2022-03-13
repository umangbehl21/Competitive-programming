package recursion;

public class BinarySearchRecursive {
    private static int binarysearch(int arr[], int num, int si, int ei) {
        if (ei < si || si > ei) {
            return -1;
        }
        int mid = (si + ei) / 2;
        if (arr[mid] == num) {
            return mid;
        } else if (arr[mid] > num) {
            return binarysearch(arr, num, si, mid - 1);
        } else {
            return binarysearch(arr, num, mid + 1, ei);
        }
    }

    public static int binarysearch(int[] arr, int num) {
        return binarysearch(arr, num, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int arr[] = {2,3,4,5,6,8};
        System.out.println(binarysearch(arr, 2));
    }
}
