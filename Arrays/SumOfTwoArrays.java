package Arrays;
import java.util.ArrayList;
public class SumOfTwoArrays {
    public static int[] findArraySum(int[] a,int[] b) {
        ArrayList<Integer> arr = new ArrayList<>();
		int i = a.length-1;
        int j = b.length-1;
        int carry = 0;
        while(i >= 0 || j >=0)
        {
            int digit = carry;
            if(i >= 0)
            {
                digit += a[i];
                i--;
            }
            if(j >= 0)
            {
                digit += b[j];
                j--;
            }
            carry = digit/10;
            digit = digit%10;
            arr.add(digit);
        }
        if(carry != 0)
        {
            arr.add(carry);
        }
        int sum[] = new int[arr.size()];
        int realposi = 0;
        for(int k = arr.size()-1;k>=0;k--)
        {
            sum[realposi] = arr.get(k);
            realposi++;
        }
        return sum;
        }
        public static void main(String[] args) {
            int arr1[] = {9,9,9};
            int arr2[] = {2,8};
            int sum[] = new int[arr1.length > arr2.length?arr1.length:arr2.length];
            sum = findArraySum(arr1, arr2);
            for(int i = 0;i<sum.length;i++)
            {
               System.out.print(sum[i]); 
            }

        }
}
