package Arrays;
import java.util.Scanner;
public class sumofalementsofarray {
    public static int sumarrayelements(int arr[])
    {
        int sum = 0;
        for(int i = 0;i<arr.length;i++)
        {
            sum+=arr[i];
        }
        return sum;
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
        System.out.println(sumarrayelements(arr));
    }
}
