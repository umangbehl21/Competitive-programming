package Graphs;
import java.util.*;
public class IsGraphBipartite {   //if there are odd number of vertices and there is cycle in the odd vertices of graph it is never a bipartite and even number with cycle between even vertices is bipartite 
    static class pair
    {                            //a graph is bipartite when if it is represented in two sets all the elements should be mutually exhaustive (all elements should be present in the graph), mutually exclusive(no common elements) and all the edges of vertices should be connected across the set 
    int v = 0;
    int lvl = 0;
    pair(int v,int lvl)
     {
     this.v = v;
     this.lvl = lvl;
     }
   }
    public static void isGraphBipartite(ArrayList<Edges> []graph,int src)
    {
        int visited[] = new int[graph.length];
        for(int i = 0;i<visited.length;i++)
        {
            visited[i] = -1;
        }
        for(int i = 0;i<graph.length;i++)
        { 
            if(visited[i] == -1)
            {
              boolean ans = isGraphBipartiteHelper(graph, i,visited);
              if(ans == false)  //if any of the sub component of graph is not bipatrite or have odd cycle between then return false and return from there 
               {
                System.out.println(false);
                return;
               }    
            }
        }
        System.out.println(true);
    }
    private static boolean isGraphBipartiteHelper(ArrayList<Edges>[] graph, int src, int[] visited) 
    {
       Queue<pair> pendingnodes = new LinkedList<>();
       pendingnodes.add(new pair(src,0));
       while(!pendingnodes.isEmpty())
       {
         pair front = pendingnodes.remove();  
         if(visited[front.v] != -1)
         {
            if(front.lvl != visited[front.v])  //if a neighbour is a common neighbour with odd vertices then it will be added or appear two time in the queue with different levels means that the graph is not bipartite 
            {
                return false;
            }
         } 
         else 
         {
            visited[front.v] = front.lvl;  // if not visited now mark it as visited 
            for(Edges e : graph[front.v])
            {
                if(visited[e.nbr] == -1)  //if neighbour is unvisited then only add it 
                {
                    pendingnodes.add(new pair(e.nbr, front.lvl + 1));  //adding neighbour and passing new level to neighbour by adding previous level + 1
                }
            }
         }

       }
       return true;
    }
    public static void main(String[] args) {
        ArrayList<Edges> [] graph = AdjacencyListImplementation.AdjacencyListImplementationInp();
        isGraphBipartite(graph, graph[0].get(0).src);
    }
    
}

