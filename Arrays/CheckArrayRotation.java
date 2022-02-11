package Arrays;

public class CheckArrayRotation {
    public static int findKRotation(int arr[]) {
        int k = 0;
        int j = arr.length-1;
        for(int i = 0;i<arr.length;i++)
        {
            if(arr[i] > arr[j])
            {
                k++;
            }
            else if(arr[i] < arr[j])
            {
                break;
            }
        }
        return k;
       }
       public static void main(String[] args) {
        int arr[] = {5,6,1,2,3,4};   
        int k = findKRotation(arr);
        System.out.println("the number of times arrays is rotated is "+k);
       }
}
