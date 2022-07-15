package Tries;
import java.util.Scanner;           //IN HUFFMAN ALGORITHM LEAST MEMORY BITS ARE GIVEN TO THE MOST FREQUENCY CHARACTERS AND MORE MEMORY GIVEN TO LEAST FREQUENCY WITHOUT LOSS OF DATA USE IN SPACE OPTIMISATION 
import java.util.Comparator;
import java.util.PriorityQueue;
class HuffmanNode      //HuffmanNode           //geeksforgeeks
{ 
    int data;         //frequency 
    char ch;           // character 
    HuffmanNode left;  // left child
    HuffmanNode right; //right child
}

class MyComparator implements Comparator<HuffmanNode>  
{            //priority queue will use compare to func of comparator interface two compare two huffnodes

    @Override
    public int compare(HuffmanNode x, HuffmanNode y) {
        if(x.data < y.data)  // if answer is in negative the first x.data is small and will be swapped
        {
           return -1;
        }
        else if(x.data > y.data) 
        {
        return 1;
        }
        else 
        {
            return 0;
        }

    }
}
 class Huffman 
{
   public static void printcode(HuffmanNode root,String s)  
   {
       if(root.left == null && root.right == null && Character.isLetter(root.ch)) //root.c hai vo ek alphabet hai //basecase 
       {
           System.out.println(root.ch + ":"+s);  
           return;
       }
       printcode(root.left, s + "0"); //  appending zero to left child
       printcode(root.right, s + "1"); // appending 1 to right child 
   }
   public static void main(String[] args) {
     Scanner s = new Scanner(System.in);
     int n = 3;  // numbr of characters in array
    //  char[] chararray = {'a','b','c','d','e','f'}; //Complex Dry run 
    //  int[] charfreq = {5,9,12,13,16,45}; 

     char[] chararray = {'a','b','c'};  //Simple Dry Run 
     int[] charfreq = {4,2,8};

     PriorityQueue<HuffmanNode> q = new PriorityQueue<>(new MyComparator()); //passing our comparator so that pq can compare accordingly
     for(int i = 0;i < n;i++)  // i<6
     {                                           //steps to make huffmantree
         HuffmanNode hn = new HuffmanNode();    // making huffman hn node
         hn.ch = chararray[i];  //initialising characters from the char array into hn.c
         hn.data = charfreq[i]; //initialising frequency in hn.data

         hn.left = null;  // initially there left child will be null
         hn.right = null; // initially there right child willl be null
         q.add(hn);  //adding the huffmannodeinto queue we will have total of 6 nodes in the queue
     }
     HuffmanNode root = null;      //initially root is null
     while(q.size() > 1)  //doing it iteratively until only root node is left 
     { //bottom to top tree formation 
         HuffmanNode x = q.peek(); //storing the first min element from min heap
         q.poll(); //removing it from queue
         HuffmanNode y = q.peek(); //storing the second min element from the min heap
         q.poll(); // removing it
         HuffmanNode f = new HuffmanNode(); //making a new huffman node f 
         f.data = x.data + y.data;  //adding the two smaller nodes to make rootnode 
         f.ch = '-'; //dummy character symbol '-' whose only frequency is needed 
         f.left = x; // making root's F left child x
         f.right = y; //making root's F right child x
         root = f; // making f as root
         q.add(f); //adding it in queue
     }
     printcode(root, " ");
   }

}