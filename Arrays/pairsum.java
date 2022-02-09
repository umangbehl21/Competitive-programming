package Arrays;

import java.util.*;

public class pairsum {
  public static ArrayList<ArrayList<Integer>> pair(int arr[], int target) {
    Arrays.sort(arr);
    ArrayList<Integer> ar = new ArrayList<>();
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    int li = 0;
    int ri = arr.length - 1;
    while (li < ri) {
      if (arr[li] + arr[ri] > target) {
        ri--;
      } else if (arr[li] + arr[ri] < target) {
        li++;
      } else {

        ar.add(arr[li]);
        ar.add(arr[ri]);
        li++;
        ri++;
        // System.out.println(arr[li]+" "+arr[ri]
      }
    }
    res.add(ar); //adding the ar arraylist into the ArrayList of Arraylist(ArrayList<ArrayList<Integer>) because there can be more than one pair and we have to return list of list
    return res;

  }

  public static void main(String[] args) {
    int arr[] = { 7, 15, 3, 18, 6, 4, 19, 2, 12, 11, 9 };
    ArrayList<ArrayList<Integer>> ar = pair(arr, 15);
    System.out.println(ar);
  }
}
