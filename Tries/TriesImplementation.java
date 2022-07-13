package Tries;
import java.util.*;
class TrieNode
{
   TrieNode children[];
   boolean IsTerminating;
   char data;
   int childcount = 0;
   public TrieNode(char data)
   {
    this.data = data;
    IsTerminating = false;
     children = new TrieNode[26];
     childcount = 0;
   }

}
public class TriesImplementation
 {   
     TrieNode root;
     int WordCount;
     public TriesImplementation()
     {
        root = new TrieNode('\0');
        WordCount = 0;  //to calculate number of words keep track when isTerminate is set to true or false or when we are inserting or removing a word 
     }
     public int WordCount()
     {
        return WordCount;
     }
     private void insertHelper(String word,TrieNode root)
     {
        if(word.length() == 0)
        {
            root.IsTerminating = true;
            WordCount++;
            return;
        }
        int ChildIndex = word.charAt(0) - 'a';   //to find the index Ascii value of 'a' is 97 suppose we have to find index of 'b' then Ascii value of b is 98 and a is 97 so 98-97 = 1 is index of b 
        TrieNode child = root.children[ChildIndex]; //retaining the trienode from the roots's children array 
        if(child == null) //if child is null then make a newnode and set on index where child was null 
        { 
           child = new TrieNode(word.charAt(0));
           root.children[ChildIndex] = child;
           root.childcount++;
        }
        insertHelper(word.substring(1), child); //call ahead to insert rest of the characters first time array of '\0' will add one character then character which is example 'a' then 'a' add a character in its array 
     }
     public void insert(String word)
     { 
        insertHelper(word,root);
     }
     private void removehelper(String word,TrieNode root)
     {  
        if(word.length() == 0)  //if world length is 0 means we have reach the last character of the word we want to remove so turn its isTerminate to false 
        {
            root.IsTerminating = false;
            WordCount--;
            return;
        }
        int childindex = word.charAt(0) - 'a'; //finding index by subtracting ascii value of character from 'a'
        TrieNode child = root.children[childindex]; //retreiving the child from the child index in array 
        if(child == null) //if child is null means no such word is there or a character is missing in between then return no deletion can take place
        {
            return;
        }
        removehelper(word.substring(1), child); //if not null then call for the rest of the string 
        if(!child.IsTerminating && child.childcount == 0)  //if child is non terminating(no word can be formed with its presence) and array of child is empty we can delete that child we cannot blindly delete every node while backtracking suppose news is also a word and new is also a word then if we delete news 's' will be non terminated but 'w' of new will not be terminated and now if we delete nodes blindly then w will also be deleted new word will be lost 
        {
          root.children[childindex] = null; //put null on that index where character was there to delete it 
          root.childcount--;
        }
     }
     public void remove(String word)
     {
        removehelper(word, root);
     }
     private boolean searchhelper(String word,TrieNode root)
     {
        if(word.length() == 0)
        {
            if(root.IsTerminating == false) //if we the String passed is new but there is word in trie as news with s as terminating so after new the lenngth of String will end and we cannot blindly return true we have to check if word is terminating or not 
            {
                return false;
            }
            else 
            {
            return true;
            }
        }
        int index = word.charAt(0) - 'a';
        TrieNode child = root.children[index];
        if(child != null) //if child is not null then we have found that character on its index so call ahead 
        {
           return searchhelper(word.substring(1), child);
        }
        return false;  //but if child is null then return false as there is no word present 
    }
     public boolean search(String word)
     {
        return searchhelper(word,root);
     }
     public static void main(String[] args) {
        TriesImplementation t1 = new TriesImplementation();
        
        t1.insert("news");
        
        System.out.println("before removing ");
       
        System.out.println(t1.search("news")+" this word exists ");
       
        System.out.println("after removing");
        
        t1.remove("news");
       
        System.out.println(t1.search("news")+" this word do not exists ");

        t1.insert("new");
        t1.insert("hey");
        t1.insert("eren");
        System.out.println("total number of words in tries are "+t1.WordCount);
     }
}

 
