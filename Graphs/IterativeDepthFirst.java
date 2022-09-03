package Graphs;
import java.util.*;
public class IterativeDepthFirst 
{
    static class pair{
        int v= 0;
        String psf = "";
        pair(int src,String psf)
        {
            this.v= src;
            this.psf = psf;
        }

    }
   public static void DepthFirstIterative(ArrayList<Edges>[]graph,int v,boolean visited[])  //iterative depth first is done because recursice depth first use call stack which cannot store more than 10,000 vertices or functions so seperate stack stored in heap is used to handle the alrge amount of vertices  
   {
       Stack<pair> st = new Stack<>();
       st.add(new pair(v, v+ ""));
       while(!st.isEmpty())
       {
          pair front = st.pop();
          if(visited[front.v] == true)
          {
            continue;
          }  
          visited[front.v] = true;
          System.out.println(front.v+"path ->"+ front.psf);
          for(Edges e : graph[front.v])
          {
             if(!visited[e.nbr])
             {
                st.push(new pair(e.nbr, front.psf + e.nbr));
             }

          }

       }

   }
   public static void main(String[] args) {
    ArrayList<Edges> graph[] = AdjacencyListImplementation.AdjacencyListImplementationInp();
    boolean visited[] = new boolean[graph.length];
    DepthFirstIterative(graph, graph[0].get(0).src, visited);
   }

    


}
