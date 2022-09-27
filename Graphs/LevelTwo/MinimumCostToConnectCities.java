package Graphs.LevelTwo;
import java.io.*;
import java.util.*;
public class MinimumCostToConnectCities {

  static class Edge implements Comparable<Edge> {
    int v;
    int wt;

    Edge(int nbr, int wt) {
      this.v = nbr;
      this.wt = wt;
    }

    @Override
    public int compareTo(Edge o) {
      return this.wt - o.wt;
    }
  }
   public static int MinCost(ArrayList<ArrayList<Edge>> graph)  //by Minimum Spanning tree dijsktra algo           
  {                                                                                                 
      boolean visited[] = new boolean[graph.size()];
      PriorityQueue<Edge> pendingnodes = new PriorityQueue<>();              
      pendingnodes.add(new Edge(0,0));
      int ans = 0;
      while(!pendingnodes.isEmpty())
      {
          Edge rem = pendingnodes.remove();
          if(visited[rem.v] == true)
          {
              continue;
          }
          ans += rem.wt;
          visited[rem.v] = true;
          for(Edge nbrs : graph.get(rem.v))
          {
              if(!visited[nbrs.v])
              {
                  pendingnodes.add(new Edge(nbrs.v,nbrs.wt));
              }
          }
      }
      return ans;
  } 
  /**input 7 vertices
 // 8 edges
 // 0 1 10 src,nbr,weight
 // 0 3 40 
 // 1 2 10
 // 2 3 10 
 // 3 4 2 
 // 4 5 3
 // 4 6 8
 // 5 6 3
 **/ 
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int vtces = Integer.parseInt(br.readLine());
    ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    for (int i = 0; i < vtces; i++) {
      graph.add(new ArrayList<>());
    }

    int edges = Integer.parseInt(br.readLine());
    for (int i = 0; i < edges; i++) {
      String[] parts = br.readLine().split(" ");
      int v1 = Integer.parseInt(parts[0]);
      int v2 = Integer.parseInt(parts[1]);
      int wt = Integer.parseInt(parts[2]);
      graph.get(v1).add(new Edge(v2, wt));
      graph.get(v2).add(new Edge(v1, wt));
    }
    System.out.println(MinCost(graph));

  }

}