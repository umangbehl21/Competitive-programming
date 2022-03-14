package recursion;

import java.util.ArrayList;

public class PrintSubsetsOfArray {
    public static void print(int arr[],ArrayList<Integer> ar,int index,ArrayList<ArrayList<Integer>> ans)
    {
        if(index >= arr.length)
        {   
            ans.add(new ArrayList<>(ar)); //creating seperate ArrayList of every element we are adding because if we do in one ArrayList element will be removed side by side by the remove function and empty spaces will be printed
           // System.out.println(ans); //we are not printing here every element gets printed twice which we don't want 
            return;
        }
        print(arr,ar,index+1,ans);
        ar.add(arr[index]);
        print(arr,ar,index+1,ans);
        ar.remove(ar.size()-1);
         
    }  
    public static void main(String args [])
    {
        int arr[] = {20,12};
        ArrayList<Integer> ar = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans= new ArrayList<>();
        print(arr, ar, 0,ans);
        System.out.println(ans);  //when we pass the ArrayList or Array we pass the reference from the main so any changes made in ans ArrayList in the print function can be seen in main too
    }
}
