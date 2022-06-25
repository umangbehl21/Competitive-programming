package PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;
class MinComparator implements Comparator<String>
{

    @Override
    public int compare(String o1, String o2) {
        if(o1.length() < o2.length())
        {
           return -1;  //swapping only occurs when function returns -1 
        }
        else if(o1.length() > o2.length())
        {
            return 1;
        }
        return 0; //if both length will be equal 0 will be returned 
    }
    
}
public class StringPriorityQueueandComparator {
    public static void main(String[] args) {
    String s[] = {"at","a","umang","dev23","web","Dsa1"};
    MinComparator minc = new MinComparator();
    PriorityQueue<String> pq = new PriorityQueue<>(minc);
    for(String i : s)
    {
       pq.add(i);
    }
    System.out.println("removal according to min comparator");
    while(!pq.isEmpty())
    {
        System.out.println(pq.remove());
    }       
}
    }