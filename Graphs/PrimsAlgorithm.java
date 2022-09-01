package Graphs;
import java.util.*;
public class PrimsAlgorithm {  //minimum wire required to connect all computers can be find using minimum spanning tree which have all the vertices connected in such a way that there is no cycle in them and giving the minimmum path between two vertice or computer 
    static class pair implements Comparable<pair>
    {
        int cv = 0;  //current vertice
        int av = 0;  //aquired vertice 
        int wght = 0; //weight or distance
        pair(int cv,int av,int wght)
        {
            this.av = av;
            this.cv = cv;
            this.wght = wght;
        }
        @Override
        public int compareTo(pair o) {
            if(this.wght < o.wght)
            {
                return -1;
            }
            else if(this.wght > o.wght){
                return 1;
            } 
            else 
            {
                return 0;  
            }
        }

    }
    public static void Minimum_Wire_Required_To_ConnectAllPc(ArrayList<Edges> graph[],int src,boolean visited[])
    {
        PriorityQueue<pair> pendingnodes = new PriorityQueue<>();  //min priority queue tells the minimum path from the current vertice to aquired vertice  
        pendingnodes.add(new pair(src, -1, 0));
        while(!pendingnodes.isEmpty())
        {
            pair front = pendingnodes.remove();
            if(visited[front.cv] == true)
            {
               continue;
            }
            visited[front.cv] = true;
            if(front.av != -1)                //aquired vertice of starting of graph is -1 because the wire was not acquired from any previous computer so we will not print the starting vertice which is aquired from imaginary -1 
            {
                System.out.println("[ "+front.cv+" - "+front.av+" @ "+front.wght+" ]");  //current vertice + acquired vertice + weight 
            }                                          //av shows that our current computer is acquired or connected from which previous computer 
            for(Edges e: graph[front.cv])
            {
                if(visited[e.nbr] == false)
                {
                   pendingnodes.add(new pair(e.nbr, front.cv, e.wght));
                }
            }

        }

    }
    public static void main(String[] args) {
        ArrayList<Edges> graph[] = AdjacencyListImplementation.AdjacencyListImplementationInp();
        
        boolean visited[] = new boolean[graph.length];

        Minimum_Wire_Required_To_ConnectAllPc(graph, graph[0].get(0).src, visited);
    }
}
