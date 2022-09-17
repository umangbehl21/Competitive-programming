package Graphs.LevelTwo;
import java.util.*;
public class MinimumNumberOfSwap 
{
    static class pair implements Comparable<pair>
    {
        int val = 0;
        int idx = 0;
        pair(int val,int idx)
        {
            this.val = val;
            this.idx = idx;
        }
        @Override
        public int compareTo(pair o) {
        
            if(this.val < o.val)
              return -1;

            else if
            (this.val > o.val) return 1;
            
            else
             return 0;
        }
        public static int minimumNumberOfSwap(int ques[])
        {
            boolean visited[] = new boolean[ques.length];
            pair ans[] = new pair[ques.length];
            for(int i = 0;i<ques.length;i++)
            {
               ans[i] = new pair(ques[i], i);
            }
            Arrays.sort(ans);  //the comparable interface implemented by the pair class helps Arrays.sort to compair object type data present in array 
            int sans = 0;
            int j = 0;
            for(int i = 0;i<ans.length;i++)
            {   
                int clen = 0;
                if(ans[i].idx == i || visited[i] == true) //if index in the pair is same as the actual positiom where element should be no need to swap continue or if visited of current element is true means we are visiting it second time then its cycle is already been added continue 
                {
                       continue;
                } 
                j = i;
                while(visited[j] == false) //when the loop exist it is due to the cycle that we have visited on the node second time so outside loop we will calculate the minimmum swap for current cycle 
                
                {  
                    visited[j] = true;  //mark true if current element is now visited 
                     clen++; //increment cycle length when element is not visited 
                     j = ans[j].idx;   
                }
                sans += clen - 1; //for a cycle between two nodes swapping swapping only occur one time example if 5,4 is to swap then 4,5 is done in  asingle swap 
            }  
            return sans; 
        }
        public static void main(String[] args) {
            int ques[] = {10,19,6,3,5};
            System.out.println(minimumNumberOfSwap(ques));
        }
       


    }


}
