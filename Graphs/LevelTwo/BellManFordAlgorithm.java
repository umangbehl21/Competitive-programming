package Graphs.LevelTwo;
import java.util.*;
public class BellManFordAlgorithm   //bellman ford works on the negative edges where the djisktra donnot give the shortest path for negative edges and also bellman the Bellman-Ford algorithm can handle directed and undirected graphs with non-negative weights. However, it can only handle directed graphs with negative weights, as long as we don't have negative cycles.
{
    public static void calculateShortestDistanceFromSourceToEveryNode(int arr[][],int V,int edges) //v is total vertices
    {
        int path[] = new int[V];
        for(int i = 1;i<path.length;i++)
        {
            path[i] = Integer.MAX_VALUE;
        }
        for(int i = 1;i<=V - 1;i++) //outer loop starts from i = 1 as for i = 0 or 0th node distance is zero from itself the ith iteration runs for every vertice and try to find the shortest distance for example for i = 1 j will traverse on whole array but the node which is closest to the src or 0th node its distance can be calculated for i = 1th iteration but it will try to find the shortest path for every element in every iteration 
        {
            for(int j = 0;j<edges;j++) //inner loop runs for every edge and moves to every possible edges to find the shortest path in weight from source to other nodes it checks if the path[src] + distance between src and neighbour < path[nbr] if path of source plus the distance between src and neighbour is less than the previously initialised path of the neighbour then update the distance of neighbour 
            {
                int src = arr[j][0];
                int nbr = arr[j][1];
                int wt = arr[j][2];

                if(path[src] == Integer.MAX_VALUE) //if we add some value in Integer.MAX_VALUE Then its value change and become grater than the other node having Integer.MAX_VALUE so in that case there is no need to check if our src have max value then we cannot find the shortest path for the neighbour as adding weight in source further makes it greater rather than smaller than the previous distance of neighbour so continue
                {
                    continue; 
                }
                if(path[src] + wt < path[nbr]) 
                {
                    path[nbr] = path[src] + wt;
                }
            }

        }
        for(int j = 0;j<edges;j++) //inner loop runs on the path array it checks if the path[src] + distance between src and neighbour < path[nbr] if path of source plus the distance between src and neighbour is less than the previously initialised path of the neighbour then update the distance of neighbour 
        {
            int src = arr[j][0];
            int nbr = arr[j][1];
            int wt = arr[j][2];

            if(path[src] == Integer.MAX_VALUE) //if the distance of source is infinity and we add further more distance of nbr from src in infinity then it will remain infinity and we will be checking if infinity < infinity so continue in that case 
            {
                continue; 
            }
            if(path[src] + wt < path[nbr])
            {
               System.out.println("negative cycle");  //as we know that bellmanford don't work on the negative cycle as the oath keeps on decreasing even after vertices - 1 iteration where every node is destined to find its shortest path then print negative cycle return algo is not possible
               return;
            }
        }
        for(int i = 0;i<path.length;i++)
        {
            if(path[i] != Integer.MAX_VALUE) //if graph ss connected then path[i] will always have some shortest path but if graph is not a connected graph then it will have max value and if it have max value print 1 billion
            {
                System.out.print(path[i] + " "); 
            }
            else 
            {
                System.out.println("1000000000");
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter number of vertices");
        int vertices = sc.nextInt();
        System.out.println("enter the number of edges between vertices");
        int edges = sc.nextInt();
        int arr[][] = new int[edges][3]; //we need 3 columns for storing source , neighbour , edge
        for(int i = 0;i<arr.length;i++)
        {
            System.out.println("enter start vertice");
            int src = sc.nextInt();
            System.out.println("enter neighbour");
            int nbr = sc.nextInt();
            System.out.println("enter weight between them");
            int wt = sc.nextInt();
            arr[i][0] = src;
            arr[i][1] = nbr;
            arr[i][2] = wt;
        }
        calculateShortestDistanceFromSourceToEveryNode(arr, vertices,edges);
    }
}
