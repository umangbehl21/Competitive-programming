package Tries;
import java.util.ArrayList;

class TrieNode
{
    boolean isTerminating;
    TrieNode Children[];
    char data;
    public TrieNode(char data)
    {
        this.data = data;
        Children = new TrieNode[26];
        isTerminating = false;
    }
}
public class IsPalindromePair {  //check pairs forming palindrome as well as a single string can also be palindrome
    TrieNode root;
    public IsPalindromePair()
    {
        root = new TrieNode('\0');
    }
    private void addhelper(String word,TrieNode root)
    {
       if(word.length() == 0)
       {
        root.isTerminating = true;
        return;
       }
       int ChildIndex = word.charAt(0) - 'a';
       TrieNode child = root.Children[ChildIndex];
       if(child == null)
       {
        child = new TrieNode(word.charAt(0));
        root.Children[ChildIndex] = child;
       }
       addhelper(word.substring(1), child);
    }
    public void add(String word)
    {
       addhelper(word, root);
    }
    private boolean searchhelper(String word,TrieNode root)
    {
       if(word.length() == 0)
       {
          return true;
       }
       int childIndex = word.charAt(0) - 'a';
       TrieNode child = root.Children[childIndex];
       if(child == null)
       {
         return false;
       }
       return searchhelper(word.substring(1), child);
    }
    public boolean search(String word)
    {
        return searchhelper(word, root);
    }
    public boolean Ispalindrome(String arr[])
    {
        ArrayList<String> rev = new ArrayList<>(); //idea is to store the orignal string in the trie and the reverse of that string in the arraylist store all the reversed string in arraylist and then search that reverse string in the trie example if two strings are abc and cba the if they are combined together they make a palindrome so reverse of first string will be cba which is present in the trie thus it is a palindrome
        for(int i = 0;i<arr.length;i++) 
        {
            add(arr[i]);  //add the strings as it is in tries 

            rev.add(reverse(arr[i])); //add their reverse in arraylist 
        }
        for(int i = 0;i<rev.size();i++)
        {
           boolean ans = search(rev.get(i)); //now search the string (present in arraylist) in trie 
           if(ans == true)
           {
             return true;
           }
        }
        return false;
    }
    public String reverse(String word)
    {
       if(word.length() == 0)
       {
          return word;
       }
      return reverse(word.substring(1)) + word.charAt(0);
    }
    public static void main(String[] args) {
     String arr[] = {"geekf","keeg"};    
     IsPalindromePair pair = new IsPalindromePair();
      boolean ans = pair.Ispalindrome(arr);
      System.out.println(ans);
    }
    
}
