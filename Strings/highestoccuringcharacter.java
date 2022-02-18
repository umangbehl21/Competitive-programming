package Strings;
public class highestoccuringcharacter {
    public static char highestoccur(String str)
    {
        int arr[] = new int[127];
        for(int i = 0;i<str.length();i++)
        {
            arr[str.charAt(i)] = arr[str.charAt(i)]+1; //arr[position of asciivalue of character] example arr[a] implies arr[97] = arr[97]+1;
        }                                                                                    //suppose 97 position initially have 0 so 0 + 1 = 1
        int max = Integer.MIN_VALUE;
        char c = ' ';
        for(int i = 0;i<str.length();i++)
        {
           if(arr[str.charAt(i)] > max)
           {
               max = arr[str.charAt(i)]; //max = arr[97 for a 98 for b so on] whatever value be there at 97 position it will be assigned to max 
               c = str.charAt(i);
           }
        }
        return c;
    }
    public static void main(String[] args) {
       char c = highestoccur("eren yeager");
       System.out.println(c);
    }
}
