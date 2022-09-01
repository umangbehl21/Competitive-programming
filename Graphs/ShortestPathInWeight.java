package Graphs;

import java.util.*;

public class ShortestPathInWeight {
   static class pair implements Comparable<pair>   
    {
       int v = 0;
       int wsf = 0;
       String psf = "";
       pair(int v,String psf,int wsf)
       {
           this.wsf = wsf;
           this.v = v;
           this.psf = psf;
       }  
    @Override
    public int compareTo(pair o) 
    {
       if(this.wsf < o.wsf) 
       {
        return -1;
       }  
       if(this.wsf > o.wsf)
       {
        return 1;         
       }
       else 
       {
        return 0;
       }
    }
        public static void PrintShortestPath_BetweenEveryNode_InTermsOfWeight(ArrayList<Edges>[]graph,int src,String psf,boolean visited[])
        { 
            PriorityQueue<pair> pendingnodes = new PriorityQueue<>(); //due to min priority queue all the path having less distance or weight between them will be printed 
            pendingnodes.add(new pair(src,src + psf, 0));
            while(!pendingnodes.isEmpty())
            {
               pair front = pendingnodes.remove();
               if(visited[front.v] == true)  //if a neighbour is already visited with less distance coverage then if the same neigbour option came second time means it is the larger distance which we don't need
               {
                continue;
               }
               visited[front.v] = true;
               System.out.println("shortest Path to reach from 0 to -> "+front.v +" is "+ front.psf + " with distance "+front.wsf);
               for(Edges e : graph[front.v])  
               {
                   if(!visited[e.nbr])
                   {
                       pendingnodes.add(new pair(e.nbr, front.psf + e.nbr, front.wsf + e.wght)); //add the neighbour by giving its path from the previous path + neighbour and the previous weight so far + e.wght 
                   }
               }

            }

        }
        public static void main(String[] args) {
            ArrayList<Edges> graph[] = AdjacencyListImplementation.AdjacencyListImplementationInp();
            boolean visited[] = new boolean[graph.length];
            PrintShortestPath_BetweenEveryNode_InTermsOfWeight(graph, graph[0].get(0).src, "", visited);
        }

         
    }



}
