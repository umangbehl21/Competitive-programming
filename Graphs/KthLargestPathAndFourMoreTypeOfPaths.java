package Graphs;
import java.util.*;
class pair implements Comparable<pair>
{
    String psf;
    int wsf;
    pair(String psf,int wsf)
    {
       this.psf = psf;
       this.wsf = wsf;
    }
    @Override
    public int compareTo(pair o) {
       if(this.wsf < o.wsf)   //swapping occurs when current weight is less than the peek weight 
       {
          return -1;
       }
       if(this.wsf > o.wsf) 
       {
       return 1;
       }  
       else 
       return 0;
    }
    

}
public class KthLargestPathAndFourMoreTypeOfPaths {
    static int swpath = Integer.MAX_VALUE;  //smallest weight path 
    static String spath = "";  //smallest path
    static int lwpath = Integer.MIN_VALUE;  //longest weight path 
    static String lpath = ""; //longest path 
    static int jlpwtc = Integer.MAX_VALUE;  //just larger path weight than criteria
    static String jlptc = "";               //just larger path than criteria 
    static int jspwtc = Integer.MIN_VALUE; //just smallest path weight than criteria 
    static String jsptc = "";
    static PriorityQueue<pair> pq = new PriorityQueue<>();
    public static void PrintAllPathHelper(ArrayList<Edges> Vertices[],int src,int des,int wsf,String psf,boolean visited[],int criteria,int k)
    {
       if(src == des)
       {
        if(wsf < swpath)
        {
          swpath = wsf;
          spath = psf;    
        }
        if(wsf > lwpath)
        {
            lwpath = wsf;
            lpath = psf;
        }
        if(wsf < criteria && wsf > jspwtc)
        {
            jspwtc = wsf;
            jsptc = psf;
        }
        if(wsf > criteria && wsf < jlpwtc)
        {
            jlpwtc = wsf;
            jlptc = psf;
        }
        if(pq.size() < k)
        {
            pq.add(new pair(psf, wsf));
        }
        else 
        {
            if(wsf > pq.peek().wsf)
            {
               pq.remove();
               pq.add(new pair(psf, wsf));
            }
        }
        return;
       }
       visited[src] = true;
       for(Edges e: Vertices[src])
       {
           if(visited[e.nbr] == false)
           {
              PrintAllPathHelper(Vertices, e.nbr, des,e.wght + wsf,psf + e.nbr, visited,criteria,k); 
           }
          
       }


    }

}
