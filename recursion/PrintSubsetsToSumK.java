package recursion;

public class PrintSubsetsToSumK {
    public static void PrintSubsets(int arr[],int index,String set,int sos,int tar)
    {
        if(index == arr.length)
        {
            if(sos == tar)
            {
                System.out.println(set);
            }
            return;
        }
        PrintSubsets(arr, index + 1, set + arr[index]+ ",", sos + arr[index], tar);
        PrintSubsets(arr, index + 1, set, sos, tar);
    } 
    public static void main(String[] args) {
        int arr[] = {5,12,3,17,1,18,15,3,17};
        PrintSubsets(arr, 0 , "" , 0 , 6);
    }
}
