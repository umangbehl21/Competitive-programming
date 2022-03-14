package recursion;

import java.util.ArrayList;

public class PrintSubsetsOfArray {
    public static void print(int arr[],ArrayList<Integer> ar,int index)
    {
        if(index == arr.length)
        {   
            System.out.println(ar);
            return;
        }
        print(arr,ar,index+1);
        ar.add(arr[index]);
        print(arr,ar,index+1);
        ar.remove(ar.size()-1);
         
    }  
    public static void main(String args [])
    {
        int arr[] = {20,15,12};
        ArrayList<Integer> ar = new ArrayList<>();
        print(arr, ar, 0);
    }
}
