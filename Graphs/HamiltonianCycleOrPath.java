package Graphs;
import java.util.*;
public class HamiltonianCycleOrPath {
    
    public static void HamiltonianCycleorPath(ArrayList<Edges> Vertices[],int src)
    {
       HashSet<Integer> visited = new HashSet<>(); //HashSet don't keep duplicate values in it 
       HamiltonianCycleOrPathHelper(Vertices,src,src + "",visited,src);

    }

    private static void HamiltonianCycleOrPathHelper(ArrayList<Edges>[] Vertices, int src, String psf, HashSet<Integer> visited, int osrc) {
      
      if(visited.size() == Vertices.length - 1)
      {  
         System.out.print(psf);
         boolean hascycle = false;
         for(Edges e : Vertices[src])
         {
            if(e.nbr == osrc)  //if last src called on has direct edge to the start then hascycle = true 
            {
              hascycle = true;
              break;
            }
         }
          if(hascycle)
          {
             System.out.println("*");   //if there is cycle print * else print . 
          }
          else 
          {
            System.out.println(".");
          }
          return;

      }
      visited.add(src);
      for(Edges e : Vertices[src])
      {
          if(!visited.contains(e.nbr))
          {
             HamiltonianCycleOrPathHelper(Vertices, e.nbr, psf + e.nbr, visited, osrc);
          }
      }
      visited.remove(src);  //removing while going back so that other possibilities can be made because there can be possiblities that a node is neighbour of two or more nodes so if for one node we mark visited then it cannot be used for other neighbours 
    }
    public static void main(String[] args) {
        ArrayList<Edges> Vertices[] = AdjacencyListImplementation.AdjacencyListImplementationInp();   
        HamiltonianCycleorPath(Vertices, Vertices[0].get(0).src);
    }
}
