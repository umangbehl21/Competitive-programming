package recursion;

import java.util.ArrayList;

public class ReturnSubsets {
    private static void subsetsdoer(int arr[],ArrayList<Integer> ar,ArrayList<ArrayList<Integer>> ans,int index) //12 20
    {
        if(index == arr.length)
        {
            ans.add(new ArrayList<>(ar)); //creating seperate ArrayList of every element we are adding because if we do in one ArrayList element will be removed side by side by the remove function and empty spaces will be printed
            return;
        }
        subsetsdoer(arr, ar, ans, index + 1);
        ar.add(arr[index]);
        subsetsdoer(arr, ar, ans, index + 1);
        ar.remove(ar.size() - 1);
    }
    public static ArrayList<ArrayList<Integer>> subsets(int arr[])
    {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> ar = new ArrayList<>();
        subsetsdoer(arr,ar,ans,0);
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {12,20};
        ArrayList<ArrayList<Integer>> ans = subsets(arr); 
            System.out.println(ans); //when we pass the ArrayList or Array we pass the reference from the main so any changes made in ans ArrayList in the print function can be seen in main too
    }
}
