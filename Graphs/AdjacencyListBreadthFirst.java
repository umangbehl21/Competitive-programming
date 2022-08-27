package Graphs;
import java.util.*;
public class AdjacencyListBreadthFirst
{
   static class pair 
    {
        int v = 0;
        String psf = "";
        pair(int v,String psf)
        {
            this.v  = v;
            this.psf = psf;
        }
    }
    public static void BreadthFirst(ArrayList<Edges>[] Vertices,int src) 
    {
        boolean visited[] = new boolean[Vertices.length];
       Queue<pair> peningNodes = new LinkedList<>();
       peningNodes.add(new pair(src,src+""));
       while(!peningNodes.isEmpty())
       {
          pair front = peningNodes.remove();
          if(!visited[front.v])  //if we are visiting a node first time then we can add its neighbour if we don't use this check we will be adding same nodes  again and again
          {  
            System.out.println(front.v + "@" + front.psf);
             visited[front.v] = true;
             for(Edges e : Vertices[front.v])
             {
                if(visited[e.nbr] == false)  //if nbr we are visiting is never visited before than add it in queue so that any other vertice don't add the same neighbour in its path 
                {
                peningNodes.add(new pair(e.nbr, front.psf + e.nbr));
                }
             }
          }
       }
    } 
    public static void main(String[] args) {
        ArrayList<Edges> Vertices[] = AdjacencyListImplementation.AdjacencyListImplementationInp();
        BreadthFirst(Vertices, Vertices[2].get(0).src);
    }
    
}
