package Graphs;
import java.util.*;
public class IsCycleInGraph 
{
   static class pair
   {
      int v;
      String psf;
      pair(int v,String psf)
      {
         this.v = v;
         this.psf = psf;
      }
   }

   public static boolean IsCycleInGraphHelper(ArrayList<Edges> Vertices[],boolean visited[],int src)  //breadth first 
   {
        Queue<pair> pendingnodes = new LinkedList<>();
        pendingnodes.add(new pair(src, src + ""));
        while(!pendingnodes.isEmpty())
        {
            pair front = pendingnodes.remove();
            if(visited[front.v] == true)  //if we came on a neighbour second time that means there is a cycle suppose there is a graph 0 -> 1 , 0 -> 2 , 1 -> 2 now 0 will add its neighbour 1 and 2 and when 1 will add it will add 2 also now 2 will not be able to add anyone as all neighbours are visited and 2 will be marked true but there is one more 2 left which was added by 1 so now it will be checked that if visited[2] == true means it was visited previously now we have came to it second time then return true there is cycle  
            {
                return true;
            }
            else 
            {
               visited[front.v] = true;
               for(Edges e : Vertices[front.v])
               {
                  if(!visited[e.nbr])
                  {
                    pendingnodes.add(new pair(e.nbr,front.psf + e.nbr ));  //pass neigbour previous path + neighbour 
                  }
               }

            }
        }
        return false;
        
   }
    public static boolean IsCycleinGraph(ArrayList<Edges> Vertices[],int src)
    {
        boolean visited[] = new boolean[Vertices.length];
        for(int i = 0;i<Vertices.length;i++)  //for unconnected graph loop will cover all components 
        {
            if(!visited[i])
            {
               boolean smallans = IsCycleInGraphHelper(Vertices, visited, src);
               if(smallans) return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<Edges>[] Vertices = AdjacencyListImplementation.AdjacencyListImplementationInp();
        System.out.println(IsCycleinGraph(Vertices, Vertices[0].get(0).src));  
    }
}
