package recursion;

import java.util.ArrayList;

public class ReturnKeypad {    
public static String[] codes = {".;","abc","def","ghi","jkl","mno","pqrst","uv","wxyz"}; //global array
public static ArrayList<String> keypad(String str) //"678"
{
    if(str.length() == 0)  //if str length becomes 0 return empty String through arraylist
    {
        ArrayList<String> ar = new ArrayList<>();
        ar.add("");  
        return ar;
    }
    char ch = str.charAt(0); //'6' //store the first character of the string 
    String ncall = str.substring(1); //"78" call on the rest of the string 
    ArrayList<String> smallans = keypad(ncall); 
    ArrayList<String> fres = new ArrayList<>(); //making arraylist which will store final result
       String codesval = codes[ch - '0']; // now we have a global array name as codes we will fetch the string from an index if ch = '6' then first we have to convert character into integer the ascii value of '0' is 48 and '6' is 54 so we have to deduct '6' - '0' (54-48 = 6) which will give us 6 in integer form
       for(int i = 0;i < codesval.length();i++) //now we will iterate over "pqrs"                                  
       {
           char chcode = codesval.charAt(i); //chcode = 'p'
           for(String res : smallans) //smallans the ArrayList we have recieved from answer of smaller part we will iterate over all the values stored in smallans arraylist
           {
              fres.add(chcode + res);  //appending 'p' + smallans values then the next time there will be 'q' and smallans values will be appended in 'q'  
           }
       }
       return fres; //then we will return our final ArrayList 
}
public static void main(String[] args) {
    ArrayList<String> ar = keypad("78");
    for(int i = 0;i<ar.size();i++)
    {
        System.out.println(ar.get(i));
     }
}

}
