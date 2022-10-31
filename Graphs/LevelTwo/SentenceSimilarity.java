package Graphs.LevelTwo;
import java.util.*;
public class SentenceSimilarity
{
    static HashMap<String,String> parent = new HashMap<>(); //child,parent
    static HashMap<String,Integer> rank = new HashMap<>();  //parent,height of a set
    public static boolean sentenceSimilarity(String[] sentence1,String sentence2[],String pairs[][])
    {
        if(sentence1.length != sentence2.length) return false;
        for(String[]p : pairs)  //as the words which are on the index pair[0]th and pair[1]th are similar so union them in their set 
        {
            union(p[0], p[1]);
        }
        for(int i = 0;i<sentence1.length;i++)
        {
            String w1 = sentence1[i];
            String w2 = sentence2[i];
            String pw1 = find(sentence1[i]);
            String pw2 = find(sentence2[i]);
            if(!w1.equals(w2) && !pw1.equals(pw2)) //if the two words are not equal as well as they are not in the same set or they don't have same parent after doing union of the pairs in ppair array then return false
            {
                return false;
            }
        }
        return true; //if we did'nt get false for any of the words then return true
    }
    public static void union(String w1,String w2)
    {
        String pw1 = find(w1);
        String pw2 = find(w2);
        if(!pw1.equals(pw2))
        {
            if(rank.get(pw1) > rank.get(pw2))
            {
                parent.put(pw2, pw1); //if set height of parent of word 2 is less than parent of word 1 then word1 will become parent of word2 as we are storing child,parent in hash map put parent.put(pw2,pw1)
            }
            else if(rank.get(pw2) > rank.get(pw1))
            {
                parent.put(pw1,pw2);
            }
            else 
            {
                parent.put(pw2,pw1);
                rank.put(pw1,rank.get(pw1) + 1);
            }

        }
    }
    public static String find(String w)
    {
        if(!parent.containsKey(w))
        {
            parent.put(w, w);
            rank.put(w, 1);
        }
        if(w.equals(parent.get(w)))
        {
            return w;
        }
         String temp = find(parent.get(w));  //calling on the parent og the child as we have stored child,parent i.e child as key and parent as value 
         parent.put(w, temp);
         return temp;
    }

}
