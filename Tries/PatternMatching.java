package Tries;
class TrieNode
{
   char data;
   boolean IsTerminate;
   TrieNode children[];
   public TrieNode(char data)
   {
      IsTerminate = false;
      this.data = data;
      children = new TrieNode[26];
   }

}
public class PatternMatching {
    TrieNode root;
    public PatternMatching()
    {
        root = new TrieNode('\0'); //when we initialise a global variable in constructor every function can use it and everyone will have same property 
    }
    private void inserthelper(String word,TrieNode root)
    {
       if(word.length() == 0)
       {
         return;
       }
       int childIndex = word.charAt(0) - 'a';  //findind childindex with help of Ascii value 
       TrieNode child = root.children[childIndex];  //retrieving the element on that index if null make node and insert on its index and then call recursively for this child 
       if(child == null)
       {
        child = new TrieNode(word.charAt(0));
        root.children[childIndex] = child;
       }
       inserthelper(word.substring(1), child);
    }
    public void insert(String word)
    {
    
      for(int i = 0;i<word.length();i++) //so through loop we are passing full string first then one position ahead substring if string is "sam" at first itereation it will be "am" at i = 1 and "m" at i = 2 and i = 3 loop will terminate 
      {
        inserthelper(word.substring(i), root); //we have to make suffix combinations and store in tire example word is sam we will store "sam" in trie then "am" in trie then "m" in trie this is because user can search any substring of word any partial word 
      }   

    }
    private boolean searchHelper(String word,TrieNode root)
    {
      if(word.length() == 0)
      {
        return true;
      }
      int childIndex = word.charAt(0) - 'a';
      TrieNode child = root.children[childIndex];
      if(child != null)
      {
        return searchHelper(word.substring(1), child);
      }
      return false;
    }
    public boolean search(String word)
    {
     return searchHelper(word, root);
    }
    public static void main(String[] args) {
        PatternMatching p1 = new PatternMatching();
        p1.insert("sam");
       
        System.out.println(p1.search("sam"));
    }

}
