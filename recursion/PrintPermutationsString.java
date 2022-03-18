package recursion;

public class PrintPermutationsString {
    public static void printpermutaion(String ques,String asf) //"abc"
    {
        if(ques.length() == 0)
        {
           System.out.println(asf);
           return;
        }                                    //extracting each character from our string                                 
        for(int i = 0;i<ques.length();i++)   //making our rest of the string by adding the left part and right part
        {                                    //for "abc" if we have to include b in our answer first then the rest of String will be calculated index of b is 1 so left part is (0,1) and right part is 2 onwards 
            char ch = ques.charAt(i);       
            String lpart = ques.substring(0,i);   
            String rpart = ques.substring(i+1);
            String roq = lpart + rpart;
            printpermutaion(roq, asf + ch);
        }
    }
    public static void main(String[] args) {
        printpermutaion("abc", "");
    }



}
