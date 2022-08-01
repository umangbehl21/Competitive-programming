package recursion;

import java.util.ArrayList;

public class ReturnSubsetsToSumK {
    public static void ReturnSubsetsDoer(int arr[],int index,ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> set,int sos,int tar)
    {
        if(index == arr.length)
        {
            if(sos == tar)
            {
                ans.add(new ArrayList<>(set));  //adding every set as an new arraylist 
            }
            return;
        }
        ReturnSubsetsDoer(arr, index + 1, ans, set, sos,tar); //discluding the element from sum and set 
        set.add(arr[index]);
        ReturnSubsetsDoer(arr, index + 1, ans, set, sos + arr[index],tar); //including the element in set 
        set.remove(set.size()-1);

    }
    public static ArrayList<ArrayList<Integer>> ReturnSubsets(int arr[])
    {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> set =  new ArrayList<>();
        ReturnSubsetsDoer(arr, 0 , ans, set, 0 , 70);
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {10,20,30,40,50};
        System.out.println(ReturnSubsets(arr));
    }
}
