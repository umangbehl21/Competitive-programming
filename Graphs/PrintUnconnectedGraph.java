package Graphs;
import java.util.*;
public class PrintUnconnectedGraph 
{
   public static ArrayList<ArrayList<Integer>>  printUnconnectedGraph(ArrayList<Edges> Vertices[],int src)
   {
      boolean visited[] = new boolean[Vertices.length];
      ArrayList<ArrayList<Integer>> list = new ArrayList<>();
      for(int i = 0;i<Vertices.length;i++)
      {
      if(!visited[i])
      {
       ArrayList<Integer> ans = new ArrayList<>();
       printUnconnectedGraphHelper(Vertices,visited,ans,i);
       list.add(ans);
      }
    }
      return list;
   }

private static ArrayList<Integer> printUnconnectedGraphHelper(ArrayList<Edges>[] Vertices, boolean[] visited, ArrayList<Integer> ans,int src) 
{
    // System.out.println(src);
   ans.add(src);
   visited[src] = true;
   for(Edges e : Vertices[src])
   {
   if(!visited[e.nbr])
   {
      printUnconnectedGraphHelper(Vertices, visited, ans,e.nbr);
   }
   }
  return ans;
}
    public static void main(String[] args) {
       ArrayList<Edges> Vertices[] = AdjacencyListImplementation.AdjacencyListImplementationInp();
      System.out.println(printUnconnectedGraph(Vertices, Vertices[0].get(0).src));
    }
}
