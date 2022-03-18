package recursion;

import java.util.ArrayList;

public class ReturnPermutation {
    private static void returnpermutation(String ques, String asf,ArrayList<String> ans)
    {            
         if(ques.length() == 0)               //Detailed explanation in printpermutation
         {
             ans.add(asf);
             return;
         }
         for(int i = 0;i<ques.length();i++)
         {
             char ch = ques.charAt(i);
             String lpart = ques.substring(0,i);
             String rpart = ques.substring(i + 1);
             String roq = lpart + rpart;
             returnpermutation(roq, asf + ch, ans);
         }
    }
    public static ArrayList<String> returnpermutation(String ques)
    {
       ArrayList<String> ans = new ArrayList<>();
       returnpermutation(ques,"",ans);
       return ans;
    }
    public static void main(String[] args) {
        System.out.println(returnpermutation("abc"));
    }
}
