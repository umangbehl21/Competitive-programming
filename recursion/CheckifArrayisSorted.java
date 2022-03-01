package recursion;

public class CheckifArrayisSorted {
    
public static boolean ifsorted(int arr[])
{
   if(arr.length <= 1)
   {
     return true;
   }
   if(arr[0] > arr[1])  //check if first two element are sorted if not return false
   {
       return false; 
   }
   int smallarr[] = new int[arr.length-1]; //make an array to copy from 1th index of previous array
   for(int i = 1;i<arr.length;i++)
   {
       smallarr[i-1] = arr[i]; 
   }
   boolean smallans = ifsorted(smallarr); //pass that smallarr 
   return smallans;

}
  public static void main(String[] args) {
      int arr[] = {1,2,3,5,4};
      System.out.println(ifsorted(arr));
  }
}
