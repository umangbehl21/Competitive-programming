package Graphs.LevelTwo;
import java.util.*;
public class OptimisedWaterDistribution 
{
    static class pair implements Comparable<pair>
    { 
        int vtx;
        int wt;
        pair(int vtx,int wt)
        {
            this.wt = wt;
            this.vtx = vtx;
        }
        @Override
        public int compareTo(pair o) {
            if(this.wt < o.wt) return -1;

            else if(this.wt > o.wt) return 1;

            else return 0;
        }
        
    }
    public static int MinimumSpanningTree(int n,int wells[],int pipes[][])
    {
        ArrayList<pair> graph[] = new ArrayList[n + 1]; //our ArrayList will be of n+1 size as we will be adding one dummy node to connect the cost of diggint the well to its respective construction site so if there are 4 nodes adding one dummy node made it 5 
        for(int i = 0;i<graph.length;i++)
        {
            graph[i] = new ArrayList<>();
        }
        for(int i = 0;i<pipes.length;i++) 
        {
            int src = pipes[i][0]; //by pipes[i][0] we get the source , pipes[i][1] we get the neighbour of current vertice and by pipe[i][2] we get the weight between them
            int nbr = pipes[i][1]; 
            int wt = pipes[i][2];
            graph[src].add(new pair(nbr, wt));
            graph[nbr].add(new pair(src, wt));
        
        }//graph containing pipelines and its weight is prepared but we have to consider the digging costs for every construction site and include it in graph
        
        for(int i = 1;i<n;i++)  //for adding the digging cost for every vertice we will add a dummy node 0 which will connect to all vertices 
        {
            graph[i].add(new pair(0,wells[i-1]));  //the cost of digging for ith construction site is stored in wells index for 1th construction site its digging cost is stored on 0th index of wells array thats why i-1
            graph[0].add(new pair(i,wells[i-1]));  //the graph is unidirectional adding the reverse edge from 0(dummy node) to all nodes
        }
        PriorityQueue<pair> pendingnodes = new PriorityQueue<>();
        pendingnodes.add(new pair(0, 0)); //as 0 which is our dummy node is the begining of the graph add it in the priority queue
        boolean[] visited = new boolean[n + 1]; //as we have added 0 as dummy node now we have one extra vertice si n + 1 storage 
        int ans = 0;
        while(!pendingnodes.isEmpty())
        {
           pair rem = pendingnodes.remove();
           if(visited[rem.vtx] == true) 
            {
                continue;
            }
            visited[rem.vtx] = true;
            ans += rem.wt;  //adding the current weight in answer 
            for(pair nbrs : graph[rem.vtx])
            { 
                if(visited[nbrs.vtx] == false)
                {
                    pendingnodes.add(new pair(nbrs.vtx, nbrs.wt));
                }

            }

        }
        return ans;
         
    }
    public static void main(String[] args) {
        int pipes[][] = {{1,2,2},{1,4,12},{2,3,4},{2,4,8},{2,5,14},{2,3,3},{5,3,7}};
        int wells[] ={3,5,12,10,6};
        // int pipes[][] = {{1,2,1},{2,3,1}};  //in this test case we can know that it is necessary to dig atleast one well at a construction site to lay the pipe connection and its cost 
        // int wells[] = {1,2,2};
        System.out.println(MinimumSpanningTree(wells.length, wells, pipes));  //wells.length indicates the total vertices in graph
    }
}
