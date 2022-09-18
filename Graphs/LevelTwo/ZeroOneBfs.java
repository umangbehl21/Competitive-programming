package Graphs.LevelTwo;

import java.util.*;

public class ZeroOneBfs   //minimum number of edges required to reverse in order to reach destination 
{
    static class pair 
    {
        int vtx = 0;
        int wt = 0;
        pair(int vtx,int wt)
        {
           this.vtx = vtx;  //vertex contains the next index or neigbour 
           this.wt = wt;    //and the weight of the neighbour  
        }

    }
    public static int MinimumReverseOfEdges(ArrayList<ArrayList<pair>> graph,int des)
    { 
        LinkedList<pair> queue = new LinkedList<>();
        boolean visited[] = new boolean[graph.size()];
        queue.addLast(new pair(0, 0));  
        while(!queue.isEmpty())
        {
           pair front = queue.remove();
           visited[front.vtx] = true;
           if(front.vtx == graph.size()-1)  //in pepcoding question the start vertice start from 1 but we are converting one based indexing to 0 based all the elements in graph will be input as 1 less than the actual input by doing 0 based indexing now the destination to find will also be input as 1 less than the real destination example if destination to find is 7 then it will be present in our graph as 6 due to 0 based indexing sp thats why graph.size()-1 gives us 6 
           {
            return front.wt;
           }
           for(pair nbrs : graph.get(front.vtx))  //graph.get(0) index ArrayList on 0th index the neihbour is present on the vtx   
           {
              if(visited[nbrs.vtx] == true)
              {
                continue;
              } 
              if(nbrs.wt == 0)  //the wt 0 represent that the neighbour is connected by a direct edge not an reverse edge 
              {
                queue.addFirst(new pair(nbrs.vtx,front.wt + 0));  //if the edge is direct not a reverse eedge then add cost 0 in the record of previous edges
              }
              else 
              {
                queue.addLast(new pair(nbrs.vtx,front.wt + 1));  //if there is a reverse edge connecting the neighbour then add cost 1 in the record of the previous edges 
              }

           }
        }
        return -1;
    }
    public static void main(String[] args) {
      ArrayList<ArrayList<pair>> graph = new ArrayList<>();
      Scanner sc = new Scanner(System.in);
      System.out.println("enter the number of vertices");
      int Totalvtx = sc.nextInt();
      System.out.println("enter the number of edges");
      int edges = sc.nextInt();
      for(int i = 0;i<Totalvtx;i++)
      {
        graph.add(new ArrayList<>());
      }
      int i = 0;
      while(i++ < edges)
      {
         System.out.println("enter the start vertex");
         int sv = sc.nextInt() - 1; //in pepcoding question the start vertice start from 1 but we are converting one based indexing to 0 based all the elements will be 1 less than the actual input by doing 0 based indexing now the destination to find will also be input as 1 less than the real example if destination to find is 7 then it will be present in our graph as 6 due to 0 based indexing 
         System.out.println("enter the end vertex");
         int ev = sc.nextInt() - 1;
         graph.get(sv).add(new pair(ev, 0)); //direct edge //by graph.get(sv) we get access to a particular index ArrayList in which we can add pair 
         graph.get(ev).add(new pair(sv, 1)); //reverse edge cost is 1 if there is an edge between 2->3<-6 then in order to reach 6 from 3 the reverse of edge is done which we have to calculate the minimum reverse of edges 

      }
      System.out.println(MinimumReverseOfEdges(graph,3)); 

    }
    

}
