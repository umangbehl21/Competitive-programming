package Arrays;
import java.util.Scanner;
public class linearsearch {
    public static int linearSearch(int arr[], int x) {
		for(int i = 0;i<arr.length;i++)
        {
            if(arr[i] == x)
            {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println("enter the storage of an array");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("enter array elements");
        for(int i = 0;i<arr.length;i++)
        {
            arr[i] = sc.nextInt();
        }
        System.out.println(linearSearch(arr, 3));
    }
}
