package Graphs.LevelTwo;
import java.util.*;

import LinkedList.removedupll;
public class BellManFordAlgorithm 
{
    public static void calculateShortestDistanceFromSourceToEveryNode(int arr[][],int V) //v is total vertices
    {
        int path[] = new int[V];
        for(int i = 1;i<path.length;i++)
        {
            path[i] = Integer.MAX_VALUE;
        }
        for(int i = 0;i<V - 1;i++) //outer loop or the ith iteration runs for every vertice and try to find the shortest distance for example for i = 0 j will traverse on whole array but the node which is closest to the src or 0th node its distance can be calculated for i = 0th iteration but it will try to find the shortest path for every element in every iteration 
        {
            for(int j = 0;j<path.length;j++) //inner loop runs on the path array it checks if the path[src] + distance between src and neighbour < path[nbr] if path of source plus the distance between src and neighbour is less than the previously initialised path of the neighbour then update the distance of neighbour 
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
                    path[nbr] = path[src] + wt;
                }
            }

        }
        for(int j = 0;j<path.length;j++) //inner loop runs on the path array it checks if the path[src] + distance between src and neighbour < path[nbr] if path of source plus the distance between src and neighbour is less than the previously initialised path of the neighbour then update the distance of neighbour 
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
                System.out.println(path[i] + ""); 
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
    }
}
