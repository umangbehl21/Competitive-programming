package recursion;

public class firstindex {
    private static int firstoccurence(int input[],int startindex,int num)
    {
        if(input[startindex] == num)
        {
           return startindex;
        }
        if(startindex == input.length-1 && input[startindex] != num)
        {
            return -1;
        }
        {

        }
        return firstoccurence(input, startindex + 1, num);
    }
    public static int firstoccurence(int input[],int num)
    {
        return firstoccurence(input,0, num);
    }
    public static void main(String[] args) {
        int input[] ={9,8,9,19,8};
        System.out.println(firstoccurence(input,190));
    }
}
